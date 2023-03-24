package com.pokeworld.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	long fieldValue;	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not founf with %s : %l",resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
