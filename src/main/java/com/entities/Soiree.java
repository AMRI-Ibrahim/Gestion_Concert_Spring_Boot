package com.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_soiree_soi")
@Entity
@Data
public class Soiree {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long soi_id;
    private String soi_nom;
    @ManyToOne
    @JoinColumn(name = "sal_id")
    private Salle sal_id;

    public Long getSoi_id() {
        return soi_id;
    }

    public void setSoi_id(Long soi_id) {
        this.soi_id = soi_id;
    }

    public String getSoi_nom() {
        return soi_nom;
    }

    public void setSoi_nom(String soi_nom) {
        this.soi_nom = soi_nom;
    }

    public Salle getSal_id() {
        return sal_id;
    }

    public void setSal_id(Salle sal_id) {
        this.sal_id = sal_id;
    }
}
