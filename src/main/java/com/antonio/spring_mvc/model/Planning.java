package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
