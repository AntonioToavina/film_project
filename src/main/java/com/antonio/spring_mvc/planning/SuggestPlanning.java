package com.antonio.spring_mvc.planning;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Act;
import com.antonio.spring_mvc.model.ActeurDispo;
import com.antonio.spring_mvc.model.Planning;
import com.antonio.spring_mvc.model.PlateauDispo;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class SuggestPlanning {
    Date date;
    List<PlanningDetails> planningDetails;

    public List<PlanningDetails> getPlanningDetails() {
        return planningDetails;
    }

    public void setPlanningDetails(List<PlanningDetails> planningDetails) {
        this.planningDetails = planningDetails;
    }

    public SuggestPlanning(Date date) {
        setDate(date);
    }
    public SuggestPlanning(Date date,List<PlanningDetails> planningDetails) {
        setDate(date);
        setPlanningDetails(planningDetails);
    }


    public SuggestPlanning() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Date> getAvailableDates(HibernateDAO dao, Date date1, Date date2){
        try{
            dao.openConnection();
//            String request = "SELECT day from generate_series('"+date1+"', '"+date2+"', '1 day'::interval) AS day WHERE extract('dow' FROM day) not in (0, 6)";

            String request = "SELECT day FROM generate_series(:date1, :date2, '1 day') AS day WHERE extract('dow' FROM day) not in (0, 6)";
            Query query = dao.getSession().createNativeQuery(request);
            query.setParameter("date1", date1, TemporalType.DATE);
            query.setParameter("date2", date2, TemporalType.DATE);
//            String request = "SELECT d FROM generate_series('" + date1 + "', '" + date2 + "', '1 day') d WHERE extract(dow from d) NOT IN (0, 6)";
//            return query.getResultList();

            System.out.println(query.getResultList());
            return new ArrayList<>();
        }catch(Exception e){
            if (dao.getTransaction() != null) {
                dao.getTransaction().rollback();
            }
            throw e;
        }finally {
            dao.closeSession();
        }
    }
    public List<Date> getAvailableDates(Date date1, Date date2,HibernateDAO dao) {
        List<Date> availableDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        while (calendar.getTime().compareTo(date2)<=0) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            Date d = new Date(calendar.getTime().getTime());

            System.out.println("Date: "+d+ " ; isPlanned: "+datePlanned(d,dao));
            if(!datePlanned(d,dao))
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    availableDates.add(d);
                }


            calendar.add(Calendar.DATE, 1);
        }

        return availableDates;
    }


    public List<SuggestPlanning> suggestPlanning(HibernateDAO dao, Date date1 , Date date2, String scenes){
        List<SuggestPlanning> planningList = new ArrayList<>();

        List<Date> dates=getAvailableDates(date1,date2,dao);
        List<Act> acts= (List) dao.findActOrderByPlateau(scenes);

//        System.out.println("DATE SIZE: "+dates.size());
        for (Date d :
                dates) {
            SuggestPlanning planning = new SuggestPlanning(d);

            List<PlanningDetails> planningDetails1 = new ArrayList<>();
            List<TimingHour> timingHours = new ArrayList<>();

            List<Act> toRemove=new ArrayList();
            for (int i = 0; i < acts.size(); i++) {
                List<PlanningDetails> pd = actToAdd(acts.get(i),timingHours,d,dao,true);





                for (PlanningDetails p :
                        pd) {

                    timingHours.add(new TimingHour(p.getFirstHour(),p.getLastHour()));
                    planningDetails1.add(p);

                    toRemove.add(p.getAct());

                    // Vérifiez si l'activité appartient au même plateau que la dernière activité ajoutée

                }
                if(i<acts.size()-1)
                    if(!acts.get(i+1).getScene_id().getPlateau().equals(acts.get(i).getScene_id().getPlateau())){

                        break;
                    }


            }
            acts.removeAll(toRemove);




            planning.setPlanningDetails(planningDetails1);
            planningDetails1.sort(Comparator.comparing(PlanningDetails::getFirstHour));
            planningList.add(planning);

            
        }


        planningList.sort(Comparator.comparing(SuggestPlanning::getDate));

        return planningList;
    }

    private List<PlanningDetails> actToAdd(Act act,List<TimingHour> timingHours,Date date,HibernateDAO dao,boolean getRelated){

        List<PlanningDetails> planningDetailsList = new ArrayList<>();

        PlanningDetails p = new PlanningDetails();
        p.setAct(act);
        TimingHour timing = TimingHour.generateTiming(act,timingHours);

        if(timing==null)
            return planningDetailsList;

        if(timing!=null){
            p.setFirstHour(timing.getFirstHour());
            p.setLastHour(timing.getLastHour());


        }
        if(!act.getScene_id().getPlateau().isAvailable(date,dao))
            return planningDetailsList;


        if(!act.getActeur_id().isAvailable(date,dao))
            return planningDetailsList;


        planningDetailsList.add(p);

        if(getRelated) {
            List<Act> related = act.getActRelated(dao);
            List<TimingHour> timingHourList = timingHours;
            timingHourList.add(timing);
            for (Act a :
                    related) {
                a.setFirsthour(act.getFirsthour());
//                a.setLasthour(act.getLasthour());
                List<PlanningDetails> pr = actToAdd(a, timingHourList, date, dao, false);
                for (PlanningDetails pt :
                        pr) {
                    timingHourList.add(new TimingHour(pt.getFirstHour(),pt.getLastHour()));
                }

                planningDetailsList.addAll(pr);


            }

//            System.out.println("size1: "+planningDetailsList.size()+ " ; size2: "+related.size());
            if(planningDetailsList.size()-1!=related.size())
                return new ArrayList<>();
        }



        return planningDetailsList;

    }


    public List<Planning> buildPlanning(HibernateDAO dao,int[] act_id, Date[] date, Time[] debut){
        List<Planning> plannings= new ArrayList<>();
        for (int i = 0; i < act_id.length; i++) {
            Planning p =new Planning();

            Act a=new Act();
            a.setId(act_id[i]);
            a= (Act) dao.findById(a);

            // Get the date and time as LocalDateTime objects
            LocalDateTime dateTime = LocalDateTime.of(date[i].toLocalDate(), debut[i].toLocalTime());

// Convert to Timestamp object
            Timestamp time = Timestamp.valueOf(dateTime);


            System.out.println("Date: "+date[i]+" : "+debut[i]+" ; ACT: "+a.getId()+" ; time: "+ time);

            p.setAct(a);
            p.setPlanningdate(time);

            plannings.add(p);


        }

        return plannings;
    }

    public void savePlanning(HibernateDAO dao,List<Planning> planningList){

        String observation= "planifié";

//        System.out.println("SIZE: AAAAAAAAAAAAAAAAAAAAAAAAA / ");
//        System.out.println(planningList.size());
        for (Planning p :
                planningList) {
            Date notAvailable = Date.valueOf(p.getPlanningdate().toLocalDateTime().toLocalDate());

            PlateauDispo pd=new PlateauDispo();
            pd.setPlateau(p.getAct().getScene_id().getPlateau());
            pd.setNotavailabledate(notAvailable);
            pd.setObservation(observation);



            ActeurDispo ad=new ActeurDispo();
            ad.setActeur(p.getAct().getActeur_id());
            ad.setNotavailabledate(notAvailable);
            ad.setObservation(observation);


            dao.save(p);
            dao.save(pd);

            dao.save(ad);
        }

    }

    public void savePlanning(HibernateDAO dao,int[] act_id, Date[] date, Time[] debut){
        List<Planning> plannings = buildPlanning(dao, act_id, date, debut);
        savePlanning(dao,plannings);
    }


    private static boolean datePlanned(Date date, HibernateDAO dao){
        List<Planning> plannings =(List) dao.findAll(new Planning());
        for (Planning p :
                plannings) {
//            System.out.println(Date.valueOf(p.getPlanningdate().toLocalDateTime().toLocalDate())+" ; DDDDDDDDDD: "+date);
            if(Date.valueOf(p.getPlanningdate().toLocalDateTime().toLocalDate()).equals(date))
                return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "SuggestPlanning{" +
                "date=" + date +
                ", planningDetails=" + planningDetails +
                '}';
    }
}
