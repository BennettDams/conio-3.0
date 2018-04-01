package de.conio.postservice.component.behaviour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.postservice.component.behaviour.repository.PostRepository;
import de.conio.postservice.component.structure.PostEntity;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Iterable<PostEntity> readAll() {
		return postRepository.findAll();
	}
}
