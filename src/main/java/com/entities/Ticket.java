package com.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_ticket_tic")
@Entity
@Data
public class Ticket {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long tic_id;
    private String tic_nom;
    private String tic_prenom;
    private Long tic_prix;
    private Long tic_nb_personne;
    @ManyToOne
    @JoinColumn(name = "soi_id")
    private Soiree soi_id;

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

    public Soiree getSoi_id() {
        return soi_id;
    }

    public void setSoi_id(Soiree soi_id) {
        this.soi_id = soi_id;
    }
}
