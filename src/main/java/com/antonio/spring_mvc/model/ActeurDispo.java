package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "acteurdispo")
public class ActeurDispo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_acteurdispo_id_seq")
    @SequenceGenerator(name = "pk_acteurdispo_id_seq",sequenceName = "acteurdispo_id_seq",allocationSize = 1)
    private int id;

    Date notavailabledate;

    String observation;


    @ManyToOne(targetEntity = Acteur.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "acteur_id", referencedColumnName = "id")
    Acteur acteur;

    public Date getNotavailabledate() {
        return notavailabledate;
    }

    public void setNotavailabledate(Date notavailabledate) {
        this.notavailabledate = notavailabledate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
