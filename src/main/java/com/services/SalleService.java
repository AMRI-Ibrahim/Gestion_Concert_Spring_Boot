package com.services;


import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {
    SalleDto saveSalle(SalleDto SalleDto);


    SalleDto getSalleById(Long concertId);


    boolean deleteSalle(Long concertId);


    List<SalleDto> getAllSalles();
}
