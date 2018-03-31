package de.conio.core.jpa.behaviour.dao.post;

import org.springframework.data.repository.CrudRepository;

import de.conio.core.jpa.structure.post.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>{

}
