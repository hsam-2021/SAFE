package com.safe.hsap.safe.util;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.safe.hsap.safe.model.Role;
import com.safe.hsap.safe.model.User;
import com.safe.hsap.safe.repository.RoleRepository;
import com.safe.hsap.safe.repository.UserRepository;

@Component
public class HsapUtil {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@EventListener
	public void loadInitialLoginData(ApplicationReadyEvent event) {
		if (roleRepository.roleExistExist("ROLE_ADMIN") == 0) {
			User userAdmin = new User("admin", "admin", "admin@safe.com", passwordEncoder.encode("admin"));
			userAdmin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
			userRepository.save(userAdmin);
		}
	}
}
