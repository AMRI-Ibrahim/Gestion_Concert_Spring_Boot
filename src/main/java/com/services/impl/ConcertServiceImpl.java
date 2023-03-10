package com.services.impl;

import com.dtos.ConcertDto;
import com.entities.Concert;
import com.entities.Groupe;
import com.entities.Soiree;
import com.repositories.ConcertRepository;
import com.repositories.GroupeRepository;
import com.repositories.SoireeRepository;
import com.services.ConcertService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;
    private final SoireeRepository soireeRepository;
    private final GroupeRepository groupeRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository, SoireeRepository soireeRepository, GroupeRepository groupeRepository) {
        this.concertRepository = concertRepository;
        this.soireeRepository = soireeRepository;
        this.groupeRepository = groupeRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) throws ChangeSetPersister.NotFoundException {
        // Converts the dto to the dog entity
        Concert concert = concertDtoToEntity(concertDto);
        // Save the dog entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return concertEntityToDto(concert);

    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }



    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(con -> {
            concertDtos.add(concertEntityToDto(con));
        });
        return concertDtos;
    }
    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setCon_id(concert.getCon_id());
        concertDto.setCon_nom(concert.getCon_nom());
        concertDto.setCon_description(concert.getCon_description());
        concertDto.setCon_date_heure_debut(concert.getCon_date_heure_debut());
        concertDto.setCon_date_heure_fin(concert.getCon_date_heure_fin());
        concertDto.setSoi_id(concert.getSoi_id().getSoi_id());
        concertDto.setGrp_id(concert.getGrp_id().getGrp_id());
        return concertDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Concert concertDtoToEntity(ConcertDto concertDto) throws ChangeSetPersister.NotFoundException {
        Concert concert = new Concert();
        concert.setCon_id(concertDto.getCon_id());
        concert.setCon_nom(concertDto.getCon_nom());
        concert.setCon_description(concertDto.getCon_description());
        concert.setCon_date_heure_debut(concertDto.getCon_date_heure_debut());
        concert.setCon_date_heure_fin(concertDto.getCon_date_heure_fin());
        Soiree soiree = soireeRepository.findById(concertDto.getSoi_id())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        concert.setSoi_id(soiree);
        Groupe groupe = groupeRepository.findById(concertDto.getGrp_id())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        concert.setGrp_id(groupe);
        return concert;
    }
}
