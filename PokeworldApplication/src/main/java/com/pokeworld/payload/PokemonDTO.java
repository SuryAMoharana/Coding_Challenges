package com.pokeworld.payload;

import com.pokeworld.entities.PokemonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {
	
	private Long id;
	private String name;
	private Integer hp;
	private PokemonType type;

}
