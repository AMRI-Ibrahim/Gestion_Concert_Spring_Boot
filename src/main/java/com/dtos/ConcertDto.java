package com.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class ConcertDto {
    private Long con_id; // Cet attribut représente l'identifiant unique du concert
    private String con_nom; // Cet attribut représente le nom du concert
    private String con_description; // Cet attribut représente la description du concert
    private Date con_date_heure_debut; // Cet attribut représente la date et l'heure de début du concert
    private Date con_date_heure_fin; // Cet attribut représente la date et l'heure de fin du concert
    private Long soi_id; // Cet attribut représente l'identifiant de la soirée à laquelle appartient le concert
    private Long grp_id; // Cet attribut représente l'identifiant du groupe qui joue le concert

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

    public Long getSoi_id() {
        return soi_id;
    }

    public void setSoi_id(Long soi_id) {
        this.soi_id = soi_id;
    }

    public Long getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Long grp_id) {
        this.grp_id = grp_id;
    }

}
