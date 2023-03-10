package com.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDto {

    private Long art_id; // Cet attribut représente l'identifiant unique de l'article
    private String art_titre; // Cet attribut représente le titre de l'article
    private String art_description; // Cet attribut représente la description de l'article
    private String art_auteur; // Cet attribut représente le nom de l'auteur de l'article
    private Date art_date; // Cet attribut représente la date de publication de l'article

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
