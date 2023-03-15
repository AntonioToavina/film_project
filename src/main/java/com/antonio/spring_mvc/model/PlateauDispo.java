package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "plateaudispo")
public class PlateauDispo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_plateaudispo_id_seq")
    @SequenceGenerator(name = "pk_plateaudispo_id_seq",sequenceName = " plateaudispo_id_seq",allocationSize = 1)
    private String id;

    int dow;

    Time firsthour;

    Time lasthour;

    @ManyToOne(targetEntity = Plateau.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "plateau_id", referencedColumnName = "id")
    Plateau plateau;

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

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
