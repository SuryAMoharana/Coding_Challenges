package com.pokeworld.services;

import java.util.List;

import com.pokeworld.entities.PokemonType;
import com.pokeworld.exceptions.ResourceNotFoundException;
import com.pokeworld.payload.PokemonDTO;

public interface PokemonServices {
	public PokemonDTO addPokemon(PokemonDTO pokemondto);
	public List<PokemonDTO> findPokemonByType(PokemonType type) throws ResourceNotFoundException;

}
