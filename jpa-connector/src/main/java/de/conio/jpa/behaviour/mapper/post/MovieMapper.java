package de.conio.jpa.behaviour.mapper.post;

import de.conio.core.structure.Movie;
import de.conio.jpa.structure.post.MovieEntity;

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
