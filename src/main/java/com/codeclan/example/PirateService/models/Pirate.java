package com.codeclan.example.PirateService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pirates")

public class Pirate {

    //follow rules of POJO for hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //starts all table id at 1
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name="ship_id", nullable=false)
    private Ship ship;

    @JsonIgnore // to prevent infinite loop when populating tables???
    @ManyToMany
    @JoinTable(
      name = "pirates_raids",
      joinColumns = { @JoinColumn(
              name = "pirate_id",
              nullable = false,
              updatable = false)
      },
            inverseJoinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            }
    )

    private List<Raid> raids;

    public Pirate(String firstName, String lastName, int age, Ship ship){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
    }

    public Pirate(){} //empty constructor is needed to persist data to database

    public void addRaidToList(Raid raid){
        this.raids.add(raid);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
