package com.codeclan.example.PirateService.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="location")
    private String location;

    @Column(name="loot")
    private int loot;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pirate_raid",
            joinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false
            )}
    )

    private List<Pirate> pirates;

    public Raid(String location, int loot){
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<Pirate>();
    }

    public void addPirateToList(Pirate pirate){
        this.pirates.add(pirate);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }
}
