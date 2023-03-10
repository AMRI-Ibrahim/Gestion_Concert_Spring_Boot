package com.dtos;

import lombok.Data;

@Data
public class SalleDto {
    private Long sal_id; // Cet attribut représente l'identifiant unique de la salle
    private String sal_nom; // Cet attribut représente le nom de la salle
    private String sal_adresse; // Cet attribut représente l'adresse de la salle
    private Long sal_capacite; // Cet attribut représente la capacité maximale de la salle en nombre de personnes
    private String  sal_nom_gestionnaire; // Cet attribut représente le nom du gestionnaire de la salle
    private String sal_prenom_gestionnaire; // Cet attribut représente le prénom du gestionnaire de la salle
    private String sal_association_gestionnaire; // Cet attribut représente le nom de l'association qui gère la salle

    public Long getSal_id() {
        return sal_id;
    }

    public void setSal_id(Long sal_id) {
        this.sal_id = sal_id;
    }

    public String getSal_nom() {
        return sal_nom;
    }

    public void setSal_nom(String sal_nom) {
        this.sal_nom = sal_nom;
    }

    public String getSal_adresse() {
        return sal_adresse;
    }

    public void setSal_adresse(String sal_adresse) {
        this.sal_adresse = sal_adresse;
    }

    public Long getSal_capacite() {
        return sal_capacite;
    }

    public void setSal_capacite(Long sal_capacite) {
        this.sal_capacite = sal_capacite;
    }

    public String getSal_nom_gestionnaire() {
        return sal_nom_gestionnaire;
    }

    public void setSal_nom_gestionnaire(String sal_nom_gestionnaire) {
        this.sal_nom_gestionnaire = sal_nom_gestionnaire;
    }

    public String getSal_prenom_gestionnaire() {
        return sal_prenom_gestionnaire;
    }

    public void setSal_prenom_gestionnaire(String sal_prenom_gestionnaire) {
        this.sal_prenom_gestionnaire = sal_prenom_gestionnaire;
    }

    public String getSal_association_gestionnaire() {
        return sal_association_gestionnaire;
    }

    public void setSal_association_gestionnaire(String sal_association_gestionnaire) {
        this.sal_association_gestionnaire = sal_association_gestionnaire;
    }


}
