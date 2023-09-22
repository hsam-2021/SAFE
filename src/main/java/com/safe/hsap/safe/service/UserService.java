package com.safe.hsap.safe.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.safe.hsap.safe.config.UserRegistrationDto;
import com.safe.hsap.safe.model.User;

public interface UserService extends UserDetailsService {

	User findByEmail(String email);

	User save(UserRegistrationDto registration);
}