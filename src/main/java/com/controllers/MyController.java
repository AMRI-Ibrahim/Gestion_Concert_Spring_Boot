package com.controllers;

import com.dtos.MyDTO;
import com.services.MyServiceA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyServiceA myService;
    public MyController(MyServiceA myService) {
        this.myService = myService;
    }

    @GetMapping("/documents")
    public List<MyDTO> getAllDocuments() {
        return myService.getAllDocuments();
    }
}
