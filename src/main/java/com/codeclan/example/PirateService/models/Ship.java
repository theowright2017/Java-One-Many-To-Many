package com.codeclan.example.PirateService.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ships")

public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="ship")
    private List<Pirate> listOfPirates;


    public Ship(String name){
        this.name = name;
        this.listOfPirates = new ArrayList<Pirate>();
    }

    public Ship() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pirate> getListOfPirates() {
        return listOfPirates;
    }

    public void setListOfPirates(List<Pirate> listOfPirates) {
        this.listOfPirates = listOfPirates;
    }
}
