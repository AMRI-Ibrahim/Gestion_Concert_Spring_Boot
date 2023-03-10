package com.services;

import com.dtos.MyDTO;
import com.entities.MyEntity;

import java.util.List;
public interface MyServiceA {
    public List<MyDTO> getAllDocuments();
    MyDTO convertEntityToDTO(MyEntity entity);
}
