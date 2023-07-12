package com.bluebik.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebik.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	
	

}
