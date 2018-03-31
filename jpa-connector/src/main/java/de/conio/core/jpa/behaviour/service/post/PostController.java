package de.conio.core.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.jpa.behaviour.dao.post.PostRepository;
import de.conio.core.jpa.structure.post.PostEntity;;

@Controller
@RequestMapping("posts")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("")
	public Iterable<PostEntity> readAll() {
		return postRepository.findAll();
	}
}
