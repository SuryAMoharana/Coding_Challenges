package com.bluebik.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.model.Account;
import com.bluebik.model.User;
import com.bluebik.repo.AccountRepo;
import com.bluebik.repo.UserRepo;

@Service
public class UserService {	
	
	private static final BigDecimal MAX_BALANCE = BigDecimal.valueOf(10000000);
    private static final BigDecimal MIN_BALANCE = BigDecimal.ZERO;
    
    @Autowired
    private UserRepo userRepo;
    
    public User createUser(User user) {
    	
    	User newUser=userRepo.save(user);
    	return newUser;
    	
    }
    

    

}
