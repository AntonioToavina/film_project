package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "plateauctg")
public class Plateauctg {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "pk_plateauctg_id_seq")
    @SequenceGenerator(name="pk_plateauctg_id_seq" ,sequenceName = "plateauctg_id_seq",allocationSize = 1)
    private String id;

    String ctgname;

    public String getCtgname() {
        return ctgname;
    }

    public void setCtgname(String ctgname) {
        this.ctgname = ctgname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
