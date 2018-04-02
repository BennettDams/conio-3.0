package de.conio.web.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.conio.connector.jpa.behaviour.service.post.PostCategoryService;
import de.conio.conio.connector.jpa.behaviour.service.post.PostService;

@Controller
@RequestMapping("posts")
public class PostDefaultController {

	@Autowired
	private PostCategoryService postCategoryService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("posts", postService.readAll());
		model.addAttribute("categories", postCategoryService.readAll());

		return "posts/index";
	}
	
}
