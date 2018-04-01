package de.conio.userservice.component.behaviour.repository;

import org.springframework.data.repository.CrudRepository;

import de.conio.userservice.component.structure.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long>{

	UserEntity findOneByUsername(String username);

}
