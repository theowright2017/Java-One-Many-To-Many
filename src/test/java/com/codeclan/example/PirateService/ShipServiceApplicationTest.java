package com.codeclan.example.PirateService;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.models.Raid;
import com.codeclan.example.PirateService.models.Ship;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import com.codeclan.example.PirateService.repositories.RaidRepository;
import com.codeclan.example.PirateService.repositories.ShipRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ShipServiceApplicationTest {

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    PirateRepository pirateRepository;

    @Autowired
    RaidRepository raidRepository;

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void canCreateShip() {
//        List<Pirate> pirates = pirateRepository.findAll();
//        Ship jollyRodger = new Ship("Jolly Rodger", pirates);
//    }

    @Test
    public void canCreatePirateAndShip() {
        Ship ship = new Ship("The Flying Dutchman");
        shipRepository.save(ship);
        Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
        pirateRepository.save(pirate1);
    }

    @Test
    public void addPirateToRaid() {
        Ship ship = new Ship("The Flying Dutchman");
        shipRepository.save(ship);
        Pirate pirate = new Pirate("Jonny", "Jimbles", 32, ship);
        pirateRepository.save(pirate);
        Pirate pirate2 = new Pirate("Tony", "Tangle", 32, ship);
        pirateRepository.save(pirate2);
        Raid raid = new Raid("Skye", 20);
        raidRepository.save(raid);
        raid.addPirateToList(pirate);
        raid.addPirateToList(pirate2);
    }
}
