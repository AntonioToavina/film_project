package com.antonio.spring_mvc.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "scene")
@DynamicInsert
public class Scene {

    public Scene(){}

    public Scene(Film film, Plateau plateau, Auteur auteur,String description) {
        this.film = film;
        this.plateau = plateau;
        this.description = description;
        this.auteur=auteur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_scene_id_seq")
    @SequenceGenerator(name = "pk_scene_id_seq",sequenceName = "scene_id_seq",allocationSize = 1)
    private int id;

    @ManyToOne(targetEntity = Film.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    Film film;

    @ManyToOne(targetEntity = Plateau.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "plateau_id", referencedColumnName = "id")
    Plateau plateau;

    String description;

    @OneToOne
    @JoinColumn(name = "scenestatus_id",referencedColumnName = "id")
    Scenestatus scenestatus;

    @OneToOne
    @JoinColumn(name = "auteur_id",referencedColumnName = "id")
    Auteur auteur;

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Scenestatus getScenestatus() {
        return scenestatus;
    }

    public void setScenestatus(Scenestatus scenestatus) {
        this.scenestatus = scenestatus;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id='" + id + '\'' +
                ", film=" + film +
                ", plateau=" + plateau +
                ", description='" + description + '\'' +
                '}';
    }
}
