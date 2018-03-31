package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.jpa.behaviour.dao.post.PostRepository;
import de.conio.jpa.structure.post.PostEntity;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Iterable<PostEntity> readAll() {
		return postRepository.findAll();
	}
}
