package com.antonio.spring_mvc.planning;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Act;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.sql.Date;
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
    public List<Date> getAvailableDates(Date date1, Date date2) {
        List<Date> availableDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        while (calendar.getTime().compareTo(date2)<=0) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                availableDates.add(new Date(calendar.getTime().getTime()));
            }

            calendar.add(Calendar.DATE, 1);
        }

        return availableDates;
    }


    public List<SuggestPlanning> suggestPlanning(HibernateDAO dao, Date date1 , Date date2, String scenes){
        List<SuggestPlanning> planningList = new ArrayList<>();

        List<Date> dates=getAvailableDates(date1,date2);
        List<Act> acts= (List) dao.findActOrderByPlateau(scenes);

        System.out.println("ACT SIZE: "+acts.size());
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
                    if(i<acts.size()-1)
                        if(!acts.get(i+1).getScene_id().getPlateau().equals(acts.get(i).getScene_id().getPlateau())){

                            break;
                        }
                }



            }
            acts.removeAll(toRemove);




            planning.setPlanningDetails(planningDetails1);

            planningList.add(planning);

            
        }

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
        }



        return planningDetailsList;

    }
    @Override
    public String toString() {
        return "SuggestPlanning{" +
                "date=" + date +
                ", planningDetails=" + planningDetails +
                '}';
    }
}
