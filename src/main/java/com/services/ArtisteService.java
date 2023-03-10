package com.services;
import com.dtos.ArtisteDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ArtisteService {
    ArtisteDto saveArtiste(ArtisteDto artisteDto) throws ChangeSetPersister.NotFoundException;


    ArtisteDto getArtisteById(Long artisteId);


    boolean deleteArtiste(Long artisteId);


    List<ArtisteDto> getAllArtistes();
}
