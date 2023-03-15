package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_acteur_id_seq")
    @SequenceGenerator(name="pk_acteur_id_seq" ,sequenceName = "acteur_id_seq",allocationSize = 1)
    private String id;

    String nom;

    @OneToOne
    @JoinColumn(name = "gender_id",referencedColumnName = "id")
    Gender gender;
    Date birthday;

    public String getNom() {
        return nom;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
