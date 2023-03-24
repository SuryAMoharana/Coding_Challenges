package com.pokeworld.entities;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, PokemonType> {

	@Override
	public PokemonType convert(String source) {
		return PokemonType.valueOf(source.toUpperCase());
	}
	

}
