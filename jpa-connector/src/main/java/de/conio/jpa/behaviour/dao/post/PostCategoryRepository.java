package de.conio.jpa.behaviour.dao.post;

import org.springframework.data.repository.CrudRepository;

import de.conio.jpa.structure.post.PostCategoryEntity;

public interface PostCategoryRepository extends CrudRepository<PostCategoryEntity,Long>{

}
