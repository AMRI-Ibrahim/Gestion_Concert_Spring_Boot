package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_article_art")
@Entity
@Data
public class Article {
    //les colonnes presents dans la base de donnes
    // getters et setters
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long art_id;
    private String art_titre;
    private String art_description;
    private String art_auteur;
    private Date art_date;


    public Long getArt_id() {
        return art_id;
    }

    public void setArt_id(Long art_id) {
        this.art_id = art_id;
    }

    public String getArt_titre() {
        return art_titre;
    }

    public void setArt_titre(String art_titre) {
        this.art_titre = art_titre;
    }

    public String getArt_description() {
        return art_description;
    }

    public void setArt_description(String art_description) {
        this.art_description = art_description;
    }

    public String getArt_auteur() {
        return art_auteur;
    }

    public void setArt_auteur(String art_auteur) {
        this.art_auteur = art_auteur;
    }

    public Date getArt_date() {
        return art_date;
    }

    public void setArt_date(Date art_date) {
        this.art_date = art_date;
    }




}
