package de.conio.core.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.core.jpa.structure.post.MovieEntity;

@Transactional
public interface PostMovieRepository extends PostBaseRepository<MovieEntity> {

	
}
