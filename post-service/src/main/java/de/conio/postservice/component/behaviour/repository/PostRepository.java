package de.conio.postservice.component.behaviour.repository;

import org.springframework.data.repository.CrudRepository;

import de.conio.postservice.component.structure.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>{

}
