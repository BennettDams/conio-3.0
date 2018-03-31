package de.conio.core.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.jpa.behaviour.dao.post.PostTutorialRepository;
import de.conio.core.jpa.behaviour.service.CrudController;
import de.conio.core.jpa.structure.post.TutorialEntity;

@Controller
@RequestMapping("post-tutorial")
public class PostTutorialController extends CrudController<TutorialEntity> {
	 
	@Autowired
	PostTutorialRepository tutorialRepository;

	@Autowired
	PostCategoryController postCategoryController;

	@Override
	protected PostTutorialRepository getRepository() {
		return tutorialRepository;
	}

	@Override
	public void save(TutorialEntity entity, String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(Long id, TutorialEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public TutorialEntity read(Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public Iterable<TutorialEntity> readAll() {
		return getRepository().findAll();
	}
}
