package com.services.impl;
import com.dtos.SalleDto;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.SalleService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("salleService")
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    // Enregister une nouvelle salle
    @Override
    public SalleDto saveSalle(SalleDto SalleDto) {
        // Converts the dto to the dog entity
        Salle salle = salleDtoToEntity(SalleDto);
        // Save the dog entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }
    //Retourner une salle par sont id
    @Override
    public SalleDto getSalleById(Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleEntityToDto(salle);
    }
    // Supprime salle par sont id
    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }
    //retourner tous les salles
    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(sal -> {
            salleDtos.add(salleEntityToDto(sal));
        });
        return salleDtos;
    }

    private SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setSal_id(salle.getSal_id());
        salleDto.setSal_nom(salle.getSal_nom());
        salleDto.setSal_adresse(salle.getSal_adresse());
        salleDto.setSal_capacite(salle.getSal_capacite());
        salleDto.setSal_nom_gestionnaire(salle.getSal_nom_gestionnaire());
        salleDto.setSal_prenom_gestionnaire(salle.getSal_prenom_gestionnaire());
        salleDto.setSal_association_gestionnaire(salle.getSal_association_gestionnaire());
        return salleDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Salle salleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setSal_id(salleDto.getSal_id());
        salle.setSal_nom(salleDto.getSal_nom());
        salle.setSal_adresse(salleDto.getSal_adresse());
        salle.setSal_capacite(salleDto.getSal_capacite());
        salle.setSal_nom_gestionnaire(salleDto.getSal_nom_gestionnaire());
        salle.setSal_prenom_gestionnaire(salleDto.getSal_prenom_gestionnaire());
        salle.setSal_association_gestionnaire(salleDto.getSal_association_gestionnaire());
        return salle;
    }
}
