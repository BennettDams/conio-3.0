package de.conio.core.jpa.behaviour.dao.post;

import org.springframework.data.repository.CrudRepository;

import de.conio.core.jpa.structure.post.PostCategoryEntity;

public interface PostCategoryRepository extends CrudRepository<PostCategoryEntity,Long>{

}
