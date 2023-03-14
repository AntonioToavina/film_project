package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "px_film_id_seq")
    @SequenceGenerator(name="pk_film_id_seq" ,sequenceName = "film_id_seq",allocationSize = 1)
    private String id;

    String title;
    String description;

    @ManyToOne(targetEntity = Filmctg.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "filmctg", referencedColumnName = "id")
    Filmctg filmctg;
    Double fond;

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

    public Filmctg getFilmctg() {
        return filmctg;
    }

    public void setFilmctg(Filmctg filmctg) {
        this.filmctg = filmctg;
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
