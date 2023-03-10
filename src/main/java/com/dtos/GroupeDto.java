package com.dtos;

import lombok.Data;

@Data
public class GroupeDto {
    private Long grp_id;// id de groupe
    private String grp_nom; // le nom du groupe



    public Long getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Long grp_id) {
        this.grp_id = grp_id;
    }

    public String getGrp_nom() {
        return grp_nom;
    }

    public void setGrp_nom(String grp_nom) {
        this.grp_nom = grp_nom;
    }
}
