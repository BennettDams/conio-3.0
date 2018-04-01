package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.post.PostRepository;
import de.conio.jpa.structure.post.PostEntity;;

@Controller
@RequestMapping("posts")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("")
	public @ResponseBody Iterable<PostEntity> readAll() {
		return postRepository.findAll();
	}
}
