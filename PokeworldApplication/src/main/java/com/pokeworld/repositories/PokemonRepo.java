package com.pokeworld.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokeworld.entities.Pokemon;
import com.pokeworld.entities.PokemonType;

public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
	
	List<Pokemon> findByType(PokemonType type);

}
