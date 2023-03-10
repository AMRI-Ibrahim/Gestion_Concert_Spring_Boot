package com.controllers;

import com.dtos.GroupeDto;
import com.dtos.SalleDto;
import com.services.impl.GroupeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupe")
public class GroupeController {
    private final GroupeServiceImpl groupeService;

    // Constructeur
    public GroupeController(GroupeServiceImpl groupeService) {
        this.groupeService = groupeService;
    }

    /**
     * recupere toutes les groupes
     */
    @GetMapping
    public List<GroupeDto> getGroupes() {
        return groupeService.getAllGroupes();
    }

    /**
     * recupeer un groupe d'aprer sont id
     */
    @GetMapping("/{id}")
    public GroupeDto getGroupe(@PathVariable Long id){
        return groupeService.getGroupeById(id);
    }

    /**
     * Ajouter un groupe dans la base
     */
    @PostMapping
    public GroupeDto saveGroupe(final @RequestBody GroupeDto groupeDto){
        return groupeService.saveGroupe(groupeDto);
    }

    /**
     * Supprimer un groupe d'aprer sont id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteGroupe(@PathVariable Long id){
        return groupeService.deleteGroupe(id);
    }
}
