package de.conio.postservice.component.behaviour.repository;

import org.springframework.data.repository.CrudRepository;

import de.conio.postservice.component.structure.PostCategoryEntity;

public interface PostCategoryRepository extends CrudRepository<PostCategoryEntity,Long>{

}
