package de.conio.postservice.component.behaviour.repository;

import javax.transaction.Transactional;

import de.conio.postservice.component.structure.SeriesEntity;

@Transactional
public interface PostSeriesRepository<T> extends PostBaseRepository<SeriesEntity>{

}
