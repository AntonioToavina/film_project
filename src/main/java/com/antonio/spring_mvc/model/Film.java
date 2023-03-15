package com.antonio.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "px_film_id_seq")
    @SequenceGenerator(name="pk_film_id_seq" ,sequenceName = "film_id_seq",allocationSize = 1)
    private String id;

    String title;
    String description;

    @OneToOne
    @JoinColumn(name = "filmctg_id", referencedColumnName = "id")
    Filmctg filmctg_id;
    Double fond;

    Date production_date;

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Filmctg getFilmctg_id() {
        return filmctg_id;
    }

    public void setFilmctg_id(Filmctg filmctg) {
        this.filmctg_id = filmctg;
    }

    public Double getFond() {
        return fond;
    }

    public void setFond(Double fond) {
        this.fond = fond;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
