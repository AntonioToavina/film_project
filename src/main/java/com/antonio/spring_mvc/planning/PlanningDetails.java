package com.antonio.spring_mvc.planning;

import com.antonio.spring_mvc.model.Act;

import java.sql.Time;

public class PlanningDetails {

    Time firstHour;
    Time lastHour;
    Act act;

    public PlanningDetails(Time firstHour, Time lastHour, Act act) {
        setFirstHour(firstHour);
        setLastHour(lastHour);
        setAct(act);
    }

    public PlanningDetails() {
    }

    public Time getFirstHour() {
        return firstHour;
    }

    public void setFirstHour(Time firstHour) {
        this.firstHour = firstHour;
    }

    public Time getLastHour() {
        return lastHour;
    }

    public void setLastHour(Time lastHour) {
        this.lastHour = lastHour;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    @Override
    public String toString() {
        return "PlanningDetails{" +
                "firstHour=" + firstHour +
                ", lastHour=" + lastHour +
                ", act=" + act +
                '}';
    }
}
