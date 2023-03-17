package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "plateaudispo")
public class PlateauDispo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_plateaudispo_id_seq")
    @SequenceGenerator(name = "pk_plateaudispo_id_seq",sequenceName = " plateaudispo_id_seq",allocationSize = 1)
    private int id;



    @ManyToOne(targetEntity = Plateau.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "plateau_id", referencedColumnName = "id")
    Plateau plateau;

    Date notavailabledate;
    String observation;

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

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
