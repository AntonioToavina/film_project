package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "scene")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_scene_id_seq")
    @SequenceGenerator(name = "pk_scene_id_seq",sequenceName = "scene_id_seq",allocationSize = 1)
    private String id;

    @ManyToOne(targetEntity = Film.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    Film film;

    @ManyToOne(targetEntity = Plateau.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "plateau_id", referencedColumnName = "id")
    Plateau plateau;

    String description;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
