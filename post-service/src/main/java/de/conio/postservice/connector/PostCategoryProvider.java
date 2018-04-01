package de.conio.postservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.PostCategory;
import de.conio.postservice.component.behaviour.service.PostCategoryService;;

@Controller
@RequestMapping("post-category")
public class PostCategoryProvider extends RESTProvider<PostCategory> {

	@Autowired
	private PostCategoryService postCategoryService;

	@Override
	public void save(@ModelAttribute PostCategory object, String categoryId) {
		postCategoryService.save(object);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute PostCategory object) {
		postCategoryService.save(object);
	}

	@Override
	public void delete(@PathVariable Long id) {
		postCategoryService.delete(id);
		
	}

	@Override
	public @ResponseBody PostCategory read(@PathVariable Long id) {
		return postCategoryService.read(id);
	}

	@Override
	public @ResponseBody Iterable<PostCategory> readAll() {
		return postCategoryService.readAll();
	}

	
}
