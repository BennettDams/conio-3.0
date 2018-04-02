package de.conio.web.connector.provider.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.web.connector.consumer.post.PostCategoryConsumer;
import de.conio.web.connector.consumer.post.PostDefaultConsumer;

@Controller
@RequestMapping("posts")
public class PostDefaultProvider {

	@Autowired
	private PostCategoryConsumer categoryConsumer;
	
	@Autowired
	private PostDefaultConsumer postConsumer;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("posts", postConsumer.readAll());
		model.addAttribute("categories", categoryConsumer.readAll());

		return "posts/index";
	}
	
}
