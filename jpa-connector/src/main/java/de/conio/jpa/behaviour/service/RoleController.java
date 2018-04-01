package de.conio.jpa.behaviour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.RoleRepository;
import de.conio.jpa.structure.security.RoleEntity;

@Controller
@RequestMapping("role")
public class RoleController extends CrudController<RoleEntity>{

	@Autowired
	private RoleRepository roleRepository;

	protected RoleRepository getRepository() {
		return roleRepository;
	}
	
	@GetMapping("/nameOnly")
	public @ResponseBody List<String> findAllWithNameOnly(){
		return getRepository().findAllWithNameOnly();
	}
	
	@GetMapping("/{name}")
	public @ResponseBody RoleEntity findOneByName(@PathVariable("name") String name) {
		return getRepository().findOneByName(name);
	}

	@Override
	public void save(RoleEntity entity, String categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, RoleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleEntity read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RoleEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
