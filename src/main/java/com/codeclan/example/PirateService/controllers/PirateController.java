package com.codeclan.example.PirateService.controllers;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pirates")
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;

    @GetMapping
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){ // pathVariable allows us to access id above - {id}
        return pirateRepository.findById(id);
    }
    //optional means if no object found return null, if search for route with id that doesn't exist, page will
    // show null
}
