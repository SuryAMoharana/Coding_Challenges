package com.greenstitch.payload;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {	
	
	@Size(min=4, message ="Name must have a minimum of 4 characters" )
	@NotEmpty(message = "Name must not be empty")
	private String name;
	
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Email is not valid")
	private String email;	
	
	@Past(message = "Date of birth must be in the past")
	@NotNull(message = "DOB must not be empty")
	private LocalDate dob;
	
	@Pattern(regexp = "\\d{10}", message="Phone number must be 10 digits")
	@NotEmpty(message = "Phone must not be empty")
	private String phone;
	
	@Size(min=8,message = "Password size must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).*$",
    message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit")
	@NotEmpty(message = "Password must not be empty")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private Set<String> roles;
}
