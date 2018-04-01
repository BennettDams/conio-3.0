package de.conio.postservice.component.behaviour.mapper;

import de.conio.core.structure.Movie;
import de.conio.postservice.component.structure.MovieEntity;

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
