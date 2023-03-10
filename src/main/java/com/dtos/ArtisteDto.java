package com.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ArtisteDto {

    private Long art_id; // Cet attribut représente l'identifiant unique de l'artiste
    private String art_nom; // Cet attribut représente le nom de l'artiste
    private String art_prenom; // Cet attribut représente le prénom de l'artiste
    private String art_ville_origine; // Cet attribut représente la ville d'origine de l'artiste
    private int art_age; // Cet attribut représente l'âge de l'artiste
    private Long grp_id; // Cet attribut représente l'identifiant du groupe auquel appartient l'artiste

    public Long getArt_id() {
        return art_id;
    }

    public void setArt_id(Long art_id) {
        this.art_id = art_id;
    }

    public String getArt_nom() {
        return art_nom;
    }

    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public String getArt_prenom() {
        return art_prenom;
    }

    public void setArt_prenom(String art_prenom) {
        this.art_prenom = art_prenom;
    }

    public String getArt_ville_origine() {
        return art_ville_origine;
    }

    public void setArt_ville_origine(String art_ville_origine) {
        this.art_ville_origine = art_ville_origine;
    }

    public int getArt_age() {
        return art_age;
    }

    public void setArt_age(int art_age) {
        this.art_age = art_age;
    }

    public Long getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Long grp_id) {
        this.grp_id = grp_id;
    }
}
