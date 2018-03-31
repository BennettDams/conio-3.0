package de.conio.jpa.behaviour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.conio.jpa.structure.security.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity,Long>{

	@Query("SELECT name FROM RoleEntity") 
    List<String> findAllWithNameOnly();
	
	RoleEntity findOneByName(String name);

}
