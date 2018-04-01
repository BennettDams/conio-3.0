package de.conio.userservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.Role;
import de.conio.userservice.component.behaviour.mapper.RoleMapper;
import de.conio.userservice.component.behaviour.repository.RoleRepository;
import de.conio.userservice.component.structure.RoleEntity;

@Service
public class RoleService extends CrudService<RoleEntity, Role>{

	@Autowired
	private RoleRepository roleRepository;

	protected RoleRepository getRepository() {
		return roleRepository;
	}
	
	public List<String> findAllWithNameOnly(){
		return getRepository().findAllWithNameOnly();
	}
	
	public Role findOneByName(String name) {
		return RoleMapper.convert2Role(getRepository().findOneByName(name));
	}

	@Override
	public void save(Role object) {
		getRepository().save(RoleMapper.convert2RoleEntity(object));
	}

	@Override
	public Role read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Role> readAll() {

		Iterable<RoleEntity> entities = getRepository().findAll();
		List<Role> objects = new ArrayList();
		for (RoleEntity t : entities) {
			objects.add(RoleMapper.convert2Role(t));
		}
		
		return objects;
		
	}
}
