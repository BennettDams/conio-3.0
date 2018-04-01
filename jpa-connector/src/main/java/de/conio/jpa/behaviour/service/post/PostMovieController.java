package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.jpa.behaviour.dao.post.PostMovieRepository;
import de.conio.jpa.behaviour.service.CrudController;
import de.conio.jpa.structure.post.MovieEntity;

@Controller
@RequestMapping("post-movie")
public class PostMovieController extends CrudController<MovieEntity> {

	@Autowired
	PostMovieRepository movieRepository;

	@Autowired
	PostCategoryController postCategoryController;

	@Override
	protected PostMovieRepository getRepository() {
		return movieRepository;
	}

	@Override
	public void save(@ModelAttribute MovieEntity entity,@ModelAttribute(name = "categoryId") String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute MovieEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public @ResponseBody MovieEntity read(@PathVariable Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public @ResponseBody Iterable<MovieEntity> readAll() {
		return getRepository().findAll();
	}

}
