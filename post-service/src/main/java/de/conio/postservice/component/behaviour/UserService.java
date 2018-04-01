package de.conio.conio.connector.jpa.behaviour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.conio.conio.connector.jpa.behaviour.dao.UserRepository;
import de.conio.conio.connector.jpa.structure.user.UserEntity;

@Service
public class UserService extends CrudService<UserEntity> {
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public UserEntity findOneByUsername(String username) {
		return getRepository().findOneByUsername(username);
	}
	
	public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}


	@Override
	protected UserRepository getRepository() {
		return userRepository;
	}

	public Iterable<UserEntity> findAll() {
		return getRepository().findAll();
	}

}
