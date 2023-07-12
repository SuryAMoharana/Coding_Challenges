package com.bluebik.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebik.model.User;

public interface UserRepo extends JpaRepository<User, Long> {	

}
