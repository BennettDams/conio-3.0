package de.conio.core.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.conio.core.jpa.behaviour.dao.post.PostMovieRepository;
import de.conio.core.jpa.behaviour.service.CrudController;
import de.conio.core.jpa.structure.post.MovieEntity;

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
	public void save(MovieEntity entity, String categoryId) {
		entity.setCategory(postCategoryController.read(Long.parseLong(categoryId)));
		getRepository().save(entity);
	}

	@Override
	public void update(Long id, MovieEntity entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public MovieEntity read(Long id) {
		return getRepository().findById(id).get();
	}

	@Override
	public Iterable<MovieEntity> readAll() {
		return getRepository().findAll();
	}

}
