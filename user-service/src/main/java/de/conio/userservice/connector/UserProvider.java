package de.conio.userservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.User;
import de.conio.userservice.component.behaviour.service.UserService;

@Controller
@RequestMapping("user")
public class UserProvider extends RESTProvider<User> {
	
	@Autowired
	private UserService userService;

	@GetMapping("/name/{username}")
	public @ResponseBody User findOneByUsername(@PathVariable("username") String username) {
		return userService.findOneByUsername(username);
	}

	@Override
	public void save(User entity, String categoryId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Long id, User entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public @ResponseBody Iterable<User> readAll() {
		return userService.readAll();
	}

}
