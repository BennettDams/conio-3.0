package de.conio.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.jpa.structure.post.MovieEntity;

@Transactional
public interface PostMovieRepository extends PostBaseRepository<MovieEntity> {

	
}
