package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
public class V_scenestatus {

    @Id
    private int id;

    @ManyToOne(targetEntity = Scene.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "scene_id", referencedColumnName = "id")
    private Scene scene;

    private String status;

    private int value;

    public V_scenestatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
