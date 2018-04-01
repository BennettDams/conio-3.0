package de.conio.userservice.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.Role;
import de.conio.userservice.component.behaviour.repository.RoleRepository;
import de.conio.userservice.component.behaviour.service.RoleService;
import de.conio.userservice.component.structure.RoleEntity;

@Controller
@RequestMapping("role")
public class RoleProvider extends RESTProvider<Role>{
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/nameOnly")
	public @ResponseBody List<String> findAllWithNameOnly(){
		return roleService.findAllWithNameOnly();
	}
	
	@GetMapping("/{name}")
	public @ResponseBody Role findOneByName(@PathVariable("name") String name) {
		return roleService.findOneByName(name);
	}

	@Override
	public void save(Role entity, String categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, Role entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Role> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
