package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.post.PostTutorialRepository;
import de.conio.jpa.behaviour.service.CrudController;
import de.conio.jpa.structure.post.TutorialEntity;

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
	public void save(@ModelAttribute TutorialEntity entity, @ModelAttribute(name = "categoryId") String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute TutorialEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(@PathVariable Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public @ResponseBody TutorialEntity read(@PathVariable Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public @ResponseBody Iterable<TutorialEntity> readAll() {
		return getRepository().findAll();
	}
}
