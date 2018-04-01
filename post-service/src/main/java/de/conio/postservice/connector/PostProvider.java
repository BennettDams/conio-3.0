package de.conio.postservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.postservice.component.behaviour.service.PostService;
import de.conio.postservice.component.structure.PostEntity;;

@Controller
@RequestMapping("posts")
public class PostProvider {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("")
	public @ResponseBody Iterable<PostEntity> readAll() {
		return postService.readAll();
	}
}
