package com.dtos;

import com.entities.Soiree;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class TicketDto {
    // L'identifiant unique du ticket
    private Long tic_id;
    // Le nom du client qui a acheté le ticket
    private String tic_nom;
    // Le prénom du client qui a acheté le ticket
    private String tic_prenom;
    // Le prix du ticket en euros
    private Long tic_prix;
    // L'identifiant de la soirée à laquelle le ticket donne accès
    private Long soi_id;
    // Le nombre de personnes accompagnant le client avec le même ticket
    private Long tic_nb_personne;

    // Les getters et setters des attributs de la classe

    public Long getTic_nb_personne() {
        return tic_nb_personne;
    }

    public void setTic_nb_personne(Long tic_nb_personne) {
        this.tic_nb_personne = tic_nb_personne;
    }

    public Long getTic_id() {
        return tic_id;
    }

    public void setTic_id(Long tic_id) {
        this.tic_id = tic_id;
    }

    public String getTic_nom() {
        return tic_nom;
    }

    public void setTic_nom(String tic_nom) {
        this.tic_nom = tic_nom;
    }

    public String getTic_prenom() {
        return tic_prenom;
    }

    public void setTic_prenom(String tic_prenom) {
        this.tic_prenom = tic_prenom;
    }

    public Long getTic_prix() {
        return tic_prix;
    }

    public void setTic_prix(Long tic_prix) {
        this.tic_prix = tic_prix;
    }

    public Long getSoi_id() {
        return soi_id;
    }

    public void setSoi_id(Long soi_id) {
        this.soi_id = soi_id;
    }
}
