package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "actype")
public class Acttype {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_acttype_id_seq")
    @SequenceGenerator(name = "pk_acttype_id_seq",sequenceName = "acttype_id_seq",allocationSize = 1)
    private String id;

    String typename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
