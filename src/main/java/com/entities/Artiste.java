package com.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_artiste_art")
@Entity
@Data
public class Artiste {
    //les colonnes presents dans la base de donnes
    // getters et setters
    @Id
    private Long art_id;
    private String art_nom;
    private String art_prenom;
    private String art_ville_origine;
    private int art_age;
    // pour la cles etranger
    @ManyToOne
    @JoinColumn(name = "grp_id")
    private Groupe grp_id;

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

    public Groupe getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Groupe grp_id) {
        this.grp_id = grp_id;
    }
}
