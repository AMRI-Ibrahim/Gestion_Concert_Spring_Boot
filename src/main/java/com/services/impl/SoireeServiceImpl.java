package com.services.impl;

import com.dtos.SoireeDto;
import com.entities.Salle;
import com.entities.Soiree;
import com.repositories.SalleRepository;
import com.repositories.SoireeRepository;
import com.services.SoireeService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("soireeService")
public class SoireeServiceImpl implements SoireeService {
    private final SoireeRepository soireeRepository;
    private final SalleRepository salleRepository;

    public SoireeServiceImpl(SoireeRepository soireeRepository, SalleRepository salleRepository1) {
        this.soireeRepository = soireeRepository;
        this.salleRepository = salleRepository1;
    }
    //Enregister une soiree dans le system
    @Override
    public SoireeDto saveSoiree(SoireeDto SoireeDto) throws ChangeSetPersister.NotFoundException {
        // Converts the dto to the dog entity
        Soiree soiree = soireeDtoToEntity(SoireeDto);
        // Save the dog entity
        soiree = soireeRepository.save(soiree);
        // Return the new dto
        return soireeEntityToDto(soiree);
    }
    // retourner une soiree par sont id
    @Override
    public SoireeDto getSoireeById(Long soireeId) {
        Soiree soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeEntityToDto(soiree);
    }
    //supprimer une soiree par id
    @Override
    public boolean deleteSoiree(Long soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }
    //retourner tous les salles
    @Override
    public List<SoireeDto> getAllSoirees() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soi -> {
            soireeDtos.add(soireeEntityToDto(soi));
        });
        return soireeDtos;
    }

    private SoireeDto soireeEntityToDto(Soiree soiree){
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setSoi_id(soiree.getSoi_id());
        soireeDto.setSoi_nom(soiree.getSoi_nom());
        soireeDto.setSal_id(soiree.getSal_id().getSal_id());
        return soireeDto;
    }

    /**
     * Map dog entity to soiree dto
     */
    private Soiree soireeDtoToEntity(SoireeDto soireeDto) throws ChangeSetPersister.NotFoundException {
        Soiree soiree = new Soiree();
        soiree.setSoi_id(soireeDto.getSoi_id());
        soiree.setSoi_nom(soireeDto.getSoi_nom());
        Salle salle = salleRepository.findById(soireeDto.getSal_id())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        soiree.setSal_id(salle);
        return soiree;
    }
}
