package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.post.PostCategoryRepository;
import de.conio.jpa.behaviour.service.CrudController;
import de.conio.jpa.structure.post.PostCategoryEntity;;

@Controller
@RequestMapping("post-category")
public class PostCategoryController extends CrudController<PostCategoryEntity> {

	@Autowired
	private PostCategoryRepository postCategoryRepository;

	protected PostCategoryRepository getRepository() {
		return postCategoryRepository;
	}

	@Override
	public void save(@ModelAttribute PostCategoryEntity entity, @ModelAttribute(name = "categoryId") String categoryId) {
		getRepository().save(entity);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute PostCategoryEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(@PathVariable Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public @ResponseBody PostCategoryEntity read(@PathVariable Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public @ResponseBody Iterable<PostCategoryEntity> readAll() {
		return getRepository().findAll();
	}

}
