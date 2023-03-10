package com.services;

import com.dtos.ConcertDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ConcertService {

    ConcertDto saveConcert(ConcertDto concertDto) throws ChangeSetPersister.NotFoundException;


    ConcertDto getConcertById(Long concertId);


    //List<ConcertDto> getConcertsByGroupe(Long grp_id);

    boolean deleteConcert(Long concertId);


    List<ConcertDto> getAllConcerts();

   // List<ConcertDto> getConcertsByGroupe(Long grpId);
}