package de.conio.core.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.core.jpa.structure.post.SeriesEntity;

@Transactional
public interface PostSeriesRepository<T> extends PostBaseRepository<SeriesEntity>{

}
