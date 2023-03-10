package com.services;

import com.dtos.GroupeDto;
import com.dtos.SalleDto;

import java.util.List;

public interface GroupeService {

    GroupeDto saveGroupe(GroupeDto GroupeDto);


    GroupeDto getGroupeById(Long groupeId);


    boolean deleteGroupe(Long groupeId);


    List<GroupeDto> getAllGroupes();
}
