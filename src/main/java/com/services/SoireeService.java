package com.services;

import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface SoireeService {
    SoireeDto saveSoiree(SoireeDto SoireeDto) throws ChangeSetPersister.NotFoundException;


    SoireeDto getSoireeById(Long soireeId);


    boolean deleteSoiree(Long soireeId);


    List<SoireeDto> getAllSoirees();
}
