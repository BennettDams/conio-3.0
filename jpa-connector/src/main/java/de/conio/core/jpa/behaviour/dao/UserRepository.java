package de.conio.core.jpa.behaviour.dao;

import org.springframework.data.repository.CrudRepository;

import de.conio.core.jpa.structure.user.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long>{

	UserEntity findOneByUsername(String username);

}
