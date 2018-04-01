package de.conio.conio.connector.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.conio.connector.jpa.behaviour.dao.post.PostRepository;
import de.conio.conio.connector.jpa.structure.post.PostEntity;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Iterable<PostEntity> readAll() {
		return postRepository.findAll();
	}
}
