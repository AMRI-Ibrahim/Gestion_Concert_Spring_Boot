package com.controllers;
import com.dtos.SoireeDto;
import com.services.impl.SoireeServiceImpl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/soiree")
public class SoireeController {
    private final SoireeServiceImpl soireeService;

    public SoireeController(SoireeServiceImpl soireeService) {
        this.soireeService = soireeService;
    }

    /**
     * <p>Recupere toutes les soirre dans la base</p>
     */
    @GetMapping
    public List<SoireeDto> getSoirees() {
        return soireeService.getAllSoirees();
    }

    /**
     * recupere une soiree d'apres sont id
     */
    @GetMapping("/{id}")
    public SoireeDto getSoiree(@PathVariable Long id){
        return soireeService.getSoireeById(id);
    }

    /**
     * Creation d'une nouvelle soiree
     */
    @PostMapping
    public SoireeDto saveSoiree(final @RequestBody SoireeDto soireeDto) throws ChangeSetPersister.NotFoundException {
        return soireeService.saveSoiree(soireeDto);
    }


    /**
     * Delete a soiree par sont id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSoiree(@PathVariable Long id){
        return soireeService.deleteSoiree(id);
    }
}
