package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//les colonnes presents dans la base de donnes
// getters et setters
@Table(name = "t_groupe_grp")
@Entity
public class Groupe {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grp_id;
    private String grp_nom;

    public Long getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Long grp_id) {
        this.grp_id = grp_id;
    }

    public String getGrp_nom() {
        return grp_nom;
    }

    public void setGrp_nom(String grp_nom) {
        this.grp_nom = grp_nom;
    }
}
