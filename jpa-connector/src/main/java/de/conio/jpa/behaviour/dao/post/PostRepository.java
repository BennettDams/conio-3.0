package de.conio.jpa.behaviour.dao.post;

import org.springframework.data.repository.CrudRepository;

import de.conio.jpa.structure.post.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>{

}
