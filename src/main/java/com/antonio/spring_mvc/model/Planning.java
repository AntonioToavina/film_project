package com.antonio.spring_mvc.model;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.planning.PlanningDetails;
import com.antonio.spring_mvc.planning.SuggestPlanning;
import com.antonio.spring_mvc.planning.TimingHour;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Planning {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "pk_planning_id_seq")
    @SequenceGenerator(name="pk_planning_id_seq" ,sequenceName = "planning_id_seq",allocationSize = 1)
    private int id;


    @OneToOne
    @JoinColumn(name = "act_id", referencedColumnName = "id")
    private Act act;

    private Timestamp planningdate;

    public Planning() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Timestamp getPlanningdate() {
        return planningdate;
    }

    public void setPlanningdate(Timestamp planningdate) {
        this.planningdate = planningdate;
    }

    public List<SuggestPlanning> buildPlanning(List<Planning> plannings) {
        Map<Date, List<PlanningDetails>> planningMap = new HashMap<>();

        // Group planning details by date
        for (Planning planning : plannings) {
            Date planningDate = Date.valueOf(planning.getPlanningdate().toLocalDateTime().toLocalDate());
            List<PlanningDetails> planningDetailsList = planningMap.getOrDefault(planningDate, new ArrayList<>());
            TimingHour timing=new TimingHour(Time.valueOf(planning.getPlanningdate().toLocalDateTime().toLocalTime()),planning.getAct().getDuration());
            PlanningDetails planningDetails = new PlanningDetails(timing.getFirstHour(), timing.getLastHour(),planning.getAct());
            planningDetailsList.add(planningDetails);
            planningMap.put(planningDate, planningDetailsList);
        }

        // Build SuggestPlanning list from grouped planning details
        List<SuggestPlanning> suggestPlanningList = new ArrayList<>();
        for (Map.Entry<Date, List<PlanningDetails>> entry : planningMap.entrySet()) {
            Date date = entry.getKey();
            List<PlanningDetails> planningDetailsList = entry.getValue();
            planningDetailsList.sort(Comparator.comparing(PlanningDetails::getFirstHour));
            suggestPlanningList.add(new SuggestPlanning(date, planningDetailsList));
        }

        suggestPlanningList.sort(Comparator.comparing(SuggestPlanning::getDate));
        return suggestPlanningList;
    }

    public List<SuggestPlanning> getPlanning(HibernateDAO dao, Date date1, Date date2){
        List<Planning> plannings = (List) dao.getPlanning(date1,date2);
        return buildPlanning(plannings);
    }
}
