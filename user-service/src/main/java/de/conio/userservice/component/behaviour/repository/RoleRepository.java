package de.conio.userservice.component.behaviour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.conio.userservice.component.structure.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity,Long>{

	@Query("SELECT name FROM RoleEntity") 
    List<String> findAllWithNameOnly();
	
	RoleEntity findOneByName(String name);

}
