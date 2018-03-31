package de.conio.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.jpa.structure.post.SeriesEntity;

@Transactional
public interface PostSeriesRepository<T> extends PostBaseRepository<SeriesEntity>{

}
