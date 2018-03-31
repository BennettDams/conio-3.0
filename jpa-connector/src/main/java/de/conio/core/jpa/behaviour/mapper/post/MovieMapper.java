package de.conio.core.jpa.behaviour.mapper.post;

import de.conio.core.jpa.structure.post.MovieEntity;
import de.conio.core.structure.Movie;

public class MovieMapper {

	public static Movie convert2Movie(MovieEntity entity) {
		Movie movie = new Movie();
		
		return movie;
	}

	public static MovieEntity convert2MovieEntity(Movie movie) {
		MovieEntity movieEntity = new MovieEntity();
		
		return movieEntity;
	}
}
