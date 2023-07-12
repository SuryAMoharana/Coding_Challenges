package com.greenstitch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenstitch.entities.ERole;
import com.greenstitch.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByName(ERole name);

}
