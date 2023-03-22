package com.antonio.spring_mvc.model;

import com.antonio.spring_mvc.DAO.HibernateDAO;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    public boolean isAvailable(Date date, HibernateDAO dao){
        PlateauDispo plateaudispo = new PlateauDispo();
        plateaudispo.setPlateau(this);

        List<PlateauDispo> notAvailables = (List) dao.find(plateaudispo,true,0,0);
        for (PlateauDispo dispo : notAvailables) {
            if (dispo.getNotavailabledate().equals(date)) {
                return false;
            }
        }
        return true;
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
