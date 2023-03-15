package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "limitpage")
public class LimitPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlimit;

    int valeur;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setIdlimit(Integer idlimit) {
        this.idlimit = idlimit;
    }

    public Integer getIdlimit() {
        return idlimit;
    }
}
