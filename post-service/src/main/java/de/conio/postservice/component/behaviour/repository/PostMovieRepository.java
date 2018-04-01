package de.conio.postservice.component.behaviour.repository;

import javax.transaction.Transactional;

import de.conio.postservice.component.structure.MovieEntity;

@Transactional
public interface PostMovieRepository extends PostBaseRepository<MovieEntity> {

	
}
