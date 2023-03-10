package com.services.impl;

import com.dtos.ArticleDto;
import com.dtos.MyDTO;
import com.entities.Article;
import com.entities.MyEntity;
import com.repositories.MyRepository;
import com.services.MyServiceA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("documentsService")
public class MyService implements MyServiceA {


    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<MyDTO> getAllDocuments() {
        List<MyDTO> dto = new ArrayList<>();
        List<MyEntity> entities = myRepository.findAll();
        entities.forEach(art -> {
            dto.add(convertEntityToDTO(art));
        });
        return dto;
    }


    public MyDTO convertEntityToDTO(MyEntity entity) {
        MyDTO dto = new MyDTO();
        dto.set_id(entity.get_id());
        dto.setId(entity.getId());
        dto.setField1(entity.getField1());
        dto.setField2(entity.getField2());
        return dto;
    }
}
