package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//les colonnes presents dans la base de donnes
// getters et setters
@Table(name = "t_concert_con")
@Entity
@Data
public class Concert {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long con_id;
    private String con_nom;
    private String con_description;
    private Date con_date_heure_debut;
    private Date con_date_heure_fin;
    @ManyToOne
    @JoinColumn(name = "soi_id")
    private Soiree soi_id;
    @ManyToOne
    @JoinColumn(name = "grp_id")
    private Groupe grp_id;

    public Long getCon_id() {
        return con_id;
    }

    public void setCon_id(Long con_id) {
        this.con_id = con_id;
    }

    public String getCon_nom() {
        return con_nom;
    }

    public void setCon_nom(String con_nom) {
        this.con_nom = con_nom;
    }

    public String getCon_description() {
        return con_description;
    }

    public void setCon_description(String con_description) {
        this.con_description = con_description;
    }

    public Date getCon_date_heure_debut() {
        return con_date_heure_debut;
    }

    public void setCon_date_heure_debut(Date con_date_heure_debut) {
        this.con_date_heure_debut = con_date_heure_debut;
    }

    public Date getCon_date_heure_fin() {
        return con_date_heure_fin;
    }

    public void setCon_date_heure_fin(Date con_date_heure_fin) {
        this.con_date_heure_fin = con_date_heure_fin;
    }

    public Soiree getSoi_id() {
        return soi_id;
    }

    public void setSoi_id(Soiree soi_id) {
        this.soi_id = soi_id;
    }

    public Groupe getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Groupe grp_id) {
        this.grp_id = grp_id;
    }
}
