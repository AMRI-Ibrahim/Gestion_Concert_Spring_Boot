package com.services.impl;

import com.dtos.GroupeDto;
import com.dtos.SalleDto;
import com.entities.Groupe;
import com.entities.Salle;
import com.repositories.GroupeRepository;
import com.services.GroupeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("groupeService")
public class GroupeServiceImpl implements GroupeService {
    private final GroupeRepository groupeRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    //Enregister un nouveau groupe
    @Override
    public GroupeDto saveGroupe(GroupeDto GroupeDto) {
        // Converts the dto to the groupe entity
        Groupe groupe = groupeDtoToEntity(GroupeDto);
        // Save the groupe entity
        groupe = groupeRepository.save(groupe);
        // Return the new dto
        return groupeEntityToDto(groupe);
    }
    // Retourner un groupe d'apres sont id
    @Override
    public GroupeDto getGroupeById(Long groupeId) {
        Groupe groupe = groupeRepository.findById(groupeId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return groupeEntityToDto(groupe);
    }
    //supprimer un groupe par un id
    @Override
    public boolean deleteGroupe(Long groupeId) {
        groupeRepository.deleteById(groupeId);
        return true;
    }
    // Retourner tous les groupes
    @Override
    public List<GroupeDto> getAllGroupes() {
        List<GroupeDto> groupeDtos = new ArrayList<>();
        List<Groupe> groupes = groupeRepository.findAll();
        groupes.forEach(sal -> {
            groupeDtos.add(groupeEntityToDto(sal));
        });
        return groupeDtos;
    }

    private GroupeDto groupeEntityToDto(Groupe groupe){
        GroupeDto groupeDto = new GroupeDto();
        groupeDto.setGrp_id(groupe.getGrp_id());
        groupeDto.setGrp_nom(groupe.getGrp_nom());
        return groupeDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Groupe groupeDtoToEntity(GroupeDto groupeDto){
        Groupe groupe = new Groupe();
        groupe.setGrp_id(groupeDto.getGrp_id());
        groupe.setGrp_nom(groupeDto.getGrp_nom());
        return groupe;
    }
}
