package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "scenestatus")
public class Scenestatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_scenestatus_id_seq")
    @SequenceGenerator(name = "pk_scenestatus_id_seq",sequenceName = "scenestatus_id_seq",allocationSize = 1)
    private int id;

    String status;

    int value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
