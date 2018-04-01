package de.conio.postservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.Movie;
import de.conio.core.structure.Movie;
import de.conio.postservice.component.behaviour.mapper.MovieMapper;
import de.conio.postservice.component.behaviour.mapper.PostMapper;
import de.conio.postservice.component.behaviour.repository.PostMovieRepository;
import de.conio.postservice.component.structure.MovieEntity;
import de.conio.postservice.component.structure.MovieEntity;

@Service
public class PostMovieService extends CrudService<MovieEntity, Movie> {

	@Autowired
	PostMovieRepository movieRepository;


	@Override
	protected PostMovieRepository getRepository() {
		return movieRepository;
	}
	
	@Override
	public void save(Movie object) {
		getRepository().save((MovieEntity) PostMapper.convert2PostEntity(object));
	}

	@Override
	public Movie read(long id) {
		return (Movie) PostMapper.convert2Post(getRepository().findById(id).get());
	}

	@Override
	public Iterable<Movie> readAll() {
		Iterable<MovieEntity> entities = getRepository().findAll();
		List<Movie> objects = new ArrayList();
		for (MovieEntity t : entities) {
			objects.add((Movie) PostMapper.convert2Post((t)));
		}

		return objects;
	}


}
