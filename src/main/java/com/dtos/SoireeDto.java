package com.dtos;

import lombok.Data;

@Data
public class SoireeDto {

    private Long soi_id; // Cet attribut représente l'identifiant unique de la soirée
    private String soi_nom; // Cet attribut représente le nom de la soirée
    private Long sal_id; // Cet attribut représente l'identifiant de la salle où se déroule la soirée

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

    public Long getSal_id() {
        return sal_id;
    }

    public void setSal_id(Long sal_id) {
        this.sal_id = sal_id;
    }
}
