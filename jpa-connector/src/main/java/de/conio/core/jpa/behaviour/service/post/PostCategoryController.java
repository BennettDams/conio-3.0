package de.conio.core.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.jpa.behaviour.dao.post.PostCategoryRepository;
import de.conio.core.jpa.behaviour.service.CrudController;
import de.conio.core.jpa.structure.post.PostCategoryEntity;;

@Controller
@RequestMapping("post-category")
public class PostCategoryController extends CrudController<PostCategoryEntity> {

	@Autowired
	private PostCategoryRepository postCategoryRepository;

	protected PostCategoryRepository getRepository() {
		return postCategoryRepository;
	}

	@Override
	public void save(PostCategoryEntity entity, String categoryId) {
		getRepository().save(entity);
	}

	@Override
	public void update(Long id, PostCategoryEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public PostCategoryEntity read(Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public Iterable<PostCategoryEntity> readAll() {
		return getRepository().findAll();
	}

}
