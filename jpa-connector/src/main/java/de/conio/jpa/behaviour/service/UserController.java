package de.conio.jpa.behaviour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.UserRepository;
import de.conio.jpa.structure.user.UserEntity;

@Controller
@RequestMapping("user")
public class UserController extends CrudController<UserEntity> {
	
	//private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository /*, PasswordEncoder passwordEncoder*/) {
		this.userRepository = userRepository;
	//	this.passwordEncoder = passwordEncoder;
	}


	@GetMapping("/{username}")
	public @ResponseBody UserEntity findOneByUsername(@PathVariable("id") String username) {
		return getRepository().findOneByUsername(username);
	}
	
	@Override
	public @ResponseBody Iterable<UserEntity> readAll() {
		return getRepository().findAll();
	}

	
//	public String encodePassword(String value) {
//		return passwordEncoder.encode(value);
//	}


	@Override
	protected UserRepository getRepository() {
		return userRepository;
	}


	@Override
	public void save(UserEntity entity, String categoryId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Long id, UserEntity entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserEntity read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
