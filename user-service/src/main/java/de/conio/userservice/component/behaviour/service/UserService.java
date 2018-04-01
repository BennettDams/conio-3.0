package de.conio.userservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.User;
import de.conio.userservice.component.behaviour.mapper.UserMapper;
import de.conio.userservice.component.behaviour.repository.UserRepository;
import de.conio.userservice.component.structure.UserEntity;

@Service
public class UserService extends CrudService<UserEntity, User> {
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		//this.passwordEncoder = passwordEncoder;
	}


	public User findOneByUsername(String username) {
		return UserMapper.convert2User(getRepository().findOneByUsername(username));
	}
	
	/*public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}*/


	@Override
	protected UserRepository getRepository() {
		return userRepository;
	}


	@Override
	public void save(User object) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User read(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<User> readAll() {

		Iterable<UserEntity> entities = getRepository().findAll();
		List<User> objects = new ArrayList();
		for (UserEntity t : entities) {
			objects.add(UserMapper.convert2User(t));
		}
		
		return objects;
		
	}

}
