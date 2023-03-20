package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "plateau")
public class Plateau {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "pk_plateau_id_seq")
    @SequenceGenerator(name="pk_plateau_id_seq" ,sequenceName = "plateau_id_seq",allocationSize = 1)
    private int id;

    String location;

    String description;

    double price;

    @OneToOne
    @JoinColumn(name = "plateauctg_id",referencedColumnName = "id")
    Plateauctg plateauctg;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Plateauctg getPlateauctg() {
        return plateauctg;
    }

    public void setPlateauctg(Plateauctg plateauctg) {
        this.plateauctg = plateauctg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", plateauctg=" + plateauctg +
                '}';
    }
}
