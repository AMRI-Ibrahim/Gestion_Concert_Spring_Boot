package com.entities;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "t_salle_sal")
@Entity
@Data
public class Salle {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sal_id;
    private String sal_nom;
    private String sal_adresse;
    private Long sal_capacite;
    private String  sal_nom_gestionnaire;
    private String sal_prenom_gestionnaire;
    private String sal_association_gestionnaire;

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
