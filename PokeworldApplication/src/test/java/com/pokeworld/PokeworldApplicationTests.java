package com.pokeworld;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pokeworld.entities.Pokemon;
import com.pokeworld.entities.PokemonType;
import com.pokeworld.payload.PokemonDTO;
import com.pokeworld.repositories.PokemonRepo;
import com.pokeworld.services.PokemonServices;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PokeworldApplicationTests {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreatePokemonSuccess() {
	    Pokemon newPokemon = new Pokemon();
	    newPokemon.setName("Pikachu");
	    newPokemon.setHp(100);
	    newPokemon.setType(PokemonType.ELECTRIC);


	    ResponseEntity<Pokemon> response = restTemplate.postForEntity(
	        "/pokemon", newPokemon, Pokemon.class);


	    assertEquals(HttpStatus.CREATED, response.getStatusCode());

	    Pokemon createdPokemon = response.getBody();
	    assertNotNull(createdPokemon);
	    assertEquals("Pikachu", createdPokemon.getName());
	    assertEquals(100, createdPokemon.getHp());
	    assertEquals(PokemonType.ELECTRIC, createdPokemon.getType());
	}
	
	@Test
	public void testCreatePokemonInvalidInput() {
	    Pokemon newPokemon = new Pokemon();
	    newPokemon.setName("");
	    newPokemon.setHp(-10);
	    newPokemon.setType(null);

	    ResponseEntity<Pokemon> response = restTemplate.postForEntity(
	        "/pokemon", newPokemon, Pokemon.class);

	    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	    assertNull(response.getBody());
	}

}
