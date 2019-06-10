package com.codeclan.example.PirateService;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateServiceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;



	@Test
	public void contextLoads() {
	}

//	@Test
//	public void canCreatePirate() {
//		Pirate jack = new Pirate("Jack", "Sparrow", 32);
//		pirateRepository.save(jack);
//		List<Pirate> allPirates = pirateRepository.findAll();
//	}

//	@Test
//	public void canCreatePirateAndShip() {
//
//	}

	//running the test file will save to database and server will show table contents on 8080
}
