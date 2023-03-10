package com.services.impl;

import com.dtos.ArtisteDto;
import com.entities.Artiste;
import com.entities.Groupe;
import com.repositories.ArtisteRepository;
import com.repositories.GroupeRepository;
import com.services.ArtisteService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("artisteService")
public class ArtisteServiceImpl implements ArtisteService {
    private final ArtisteRepository artisteRepository;
    private final GroupeRepository groupeRepository;

    public ArtisteServiceImpl(ArtisteRepository artisteRepository, GroupeRepository groupeRepository) {
        this.artisteRepository = artisteRepository;
        this.groupeRepository = groupeRepository;
    }

    @Override
    public ArtisteDto saveArtiste(ArtisteDto artisteDto) throws ChangeSetPersister.NotFoundException {
        // Converts the artiste to the dog entity
        Artiste artiste = artisteDtoToEntity(artisteDto);
        // Save the artiste entity
        artiste = artisteRepository.save(artiste);
        // Return the new dto
        return artisteEntityToDto(artiste);
    }

    @Override
    public ArtisteDto getArtisteById(Long artisteId) {
        Artiste artiste = artisteRepository.findById(artisteId).orElseThrow(() -> new EntityNotFoundException("Artiste not found"));
        return artisteEntityToDto(artiste);
    }

    @Override
    public boolean deleteArtiste(Long artisteId) {
        artisteRepository.deleteById(artisteId);
        return true;
    }

    @Override
    public List<ArtisteDto> getAllArtistes() {
        List<ArtisteDto> artisteDtos = new ArrayList<>();
        List<Artiste> artistes = artisteRepository.findAll();
        artistes.forEach(art -> {
            artisteDtos.add(artisteEntityToDto(art));
        });
        return artisteDtos;
    }
    private ArtisteDto artisteEntityToDto(Artiste artiste){
        ArtisteDto artisteDto = new ArtisteDto();
        artisteDto.setArt_id(artiste.getArt_id());
        artisteDto.setArt_nom(artiste.getArt_nom());
        artisteDto.setArt_prenom(artiste.getArt_prenom());
        artisteDto.setArt_ville_origine(artiste.getArt_ville_origine());
        artisteDto.setArt_age(artiste.getArt_age());
        artisteDto.setGrp_id(artiste.getGrp_id().getGrp_id());
        return artisteDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Artiste artisteDtoToEntity(ArtisteDto artisteDto) throws ChangeSetPersister.NotFoundException {
        Artiste artiste = new Artiste();
        artiste.setArt_id(artisteDto.getArt_id());
        artiste.setArt_nom(artisteDto.getArt_nom());
        artiste.setArt_prenom(artisteDto.getArt_prenom());
        artiste.setArt_ville_origine(artisteDto.getArt_ville_origine());
        artiste.setArt_age(artisteDto.getArt_age());
        Groupe groupe = groupeRepository.findById(artisteDto.getGrp_id())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        artiste.setGrp_id(groupe);
        return artiste;
    }
}
