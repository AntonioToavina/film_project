package com.antonio.spring_mvc.model;

import com.antonio.spring_mvc.DAO.HibernateDAO;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_acteur_id_seq")
    @SequenceGenerator(name="pk_acteur_id_seq" ,sequenceName = "acteur_id_seq",allocationSize = 1)
    private int id;

    String nom_acteur;

    @OneToOne
    @JoinColumn(name = "gender_id",referencedColumnName = "id")
    Gender gender;
    Date birthday;


    public String getNom_acteur() {
        return nom_acteur;
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

    public void setNom_acteur(String nom) {
        this.nom_acteur = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public boolean isAvailable(Date date, HibernateDAO dao){
        ActeurDispo acteurDispo = new ActeurDispo();
        acteurDispo.setActeur(this);

        List<ActeurDispo> notAvailables = (List) dao.find(acteurDispo,true,0,0);
        for (ActeurDispo dispo : notAvailables) {
            if (dispo.getNotavailabledate().equals(date)) {
                return false;
            }
        }
        return true;
    }
}
