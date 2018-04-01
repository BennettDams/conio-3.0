package de.conio.postservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.conio.core.structure.Movie;
import de.conio.postservice.component.behaviour.service.PostCategoryService;
import de.conio.postservice.component.behaviour.service.PostMovieService;

@Controller
@RequestMapping("post-movie")
public class PostMovieProvider extends RESTProvider<Movie> {

	@Autowired
	private PostMovieService movieService;

	@Autowired
	private PostCategoryService postCategoryService;

	@Override
	public void save(@ModelAttribute Movie object, @ModelAttribute(name = "categoryId") String categoryId) {
		object.setCategory(postCategoryService.read(Long.parseLong(categoryId)));

		this.movieService.save(object);
	}

	@Override
	public void update(@PathVariable Long id, @ModelAttribute Movie object) {
		movieService.save(object);
		
	}

	@Override
	public void delete(@PathVariable Long id) {
		movieService.delete(id);
		
	}

	@Override
	public @ResponseBody Movie read(@PathVariable Long id) {
		return movieService.read(id);
	}

	@Override
	public @ResponseBody Iterable<Movie> readAll() {
		return movieService.readAll();
	}

	
}
