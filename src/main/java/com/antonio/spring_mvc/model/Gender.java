package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_gender_id_seq'")
    @SequenceGenerator(name="pk_gender_id_seq'" ,sequenceName = "gender_id_seq'",allocationSize = 1)
    private int id;

    String gendername;

    public String getGendername() {
        return gendername;
    }

    public void setGendername(String gendername) {
        this.gendername = gendername;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
