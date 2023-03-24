package com.pokeworld.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeworld.entities.Pokemon;
import com.pokeworld.entities.PokemonType;
import com.pokeworld.exceptions.ResourceNotFoundException;
import com.pokeworld.payload.PokemonDTO;
import com.pokeworld.repositories.PokemonRepo;

@Service
public class PokemonServicesImpl implements PokemonServices {
	
	@Autowired
	private PokemonRepo pokeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pokemon dtoToPokemon(PokemonDTO pokemonDto) {
		Pokemon pokemon=modelMapper.map(pokemonDto, Pokemon.class);
		return pokemon;
	}
	
	public PokemonDTO pokemonToDto(Pokemon pokemon) {
		PokemonDTO pokemonDto=modelMapper.map(pokemon, PokemonDTO.class);
		return pokemonDto;
	}

	@Override
	public PokemonDTO addPokemon(PokemonDTO pokemondto) {
		Pokemon pokemon=dtoToPokemon(pokemondto);
		Pokemon savedPokemon=pokeRepo.save(pokemon);
		return pokemonToDto(savedPokemon);
	}

	@Override
	public List<PokemonDTO> findPokemonByType(PokemonType type) throws ResourceNotFoundException {
		if(type!=null) {
			List<Pokemon> pokeTypes=pokeRepo.findByType(type);
			List<PokemonDTO> pokeDtos=pokeTypes.stream().map(a->this.pokemonToDto(a)).collect(Collectors.toList());
			return pokeDtos;
		}
		else {
			List<Pokemon> allPokes=pokeRepo.findAll();
			List<PokemonDTO> pokeDtos=allPokes.stream().map(a->this.pokemonToDto(a)).collect(Collectors.toList());
			return pokeDtos;
		}
	}
}
