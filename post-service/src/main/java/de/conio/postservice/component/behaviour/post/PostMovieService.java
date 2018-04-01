package de.conio.conio.connector.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.conio.connector.jpa.behaviour.dao.post.PostMovieRepository;
import de.conio.conio.connector.jpa.behaviour.service.CrudService;
import de.conio.conio.connector.jpa.structure.post.MovieEntity;

@Service
public class PostMovieService extends CrudService<MovieEntity> {

	@Autowired
	PostMovieRepository movieRepository;


	@Override
	protected PostMovieRepository getRepository() {
		return movieRepository;
	}

}
