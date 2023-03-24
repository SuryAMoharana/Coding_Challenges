package com.pokeworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokeworld.entities.Pokemon;
import com.pokeworld.entities.PokemonType;
import com.pokeworld.payload.PokemonDTO;
import com.pokeworld.services.PokemonServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonServices pokeServices;
	
	@PostMapping("/addPokemon")
	ResponseEntity<PokemonDTO> createPokemon(@Valid @RequestBody PokemonDTO pokemonDto){
		PokemonDTO newPokemon=pokeServices.addPokemon(pokemonDto);
		return new ResponseEntity<>(newPokemon,HttpStatus.CREATED);
	}
	
	@GetMapping("/pokemons")
	ResponseEntity<List<PokemonDTO>> getAllPokemon(@RequestParam(value="type", required = false) PokemonType type){
		return ResponseEntity.ok(pokeServices.findPokemonByType(type));
	}
}
