package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "acteurdispo")
public class ActeurDispo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_acteurdispo_id_seq")
    @SequenceGenerator(name = "pk_acteurdispo_id_seq",sequenceName = "acteurdispo_id_seq",allocationSize = 1)
    private String id;

    int dow;

    Time firsthour;

    Time lasthour;

    @ManyToOne(targetEntity = Acteur.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "acteur_id", referencedColumnName = "id")
    Acteur acteur;


    public int getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public Time getFirsthour() {
        return firsthour;
    }

    public void setFirsthour(Time firsthour) {
        this.firsthour = firsthour;
    }

    public Time getLasthour() {
        return lasthour;
    }

    public void setLasthour(Time lasthour) {
        this.lasthour = lasthour;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
