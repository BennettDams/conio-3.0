package de.conio.jpa.behaviour.mapper.post;

import de.conio.core.structure.Series;
import de.conio.jpa.structure.post.SeriesEntity;

public class SeriesMapper {

	public static Series convert2Series (SeriesEntity entity) {
		Series series = new Series();
		
		
		return series;
	}

	public static SeriesEntity convert2SeriesEntity(Series series) {
		SeriesEntity seriesEntity = new SeriesEntity();
		
		return seriesEntity;
	}
}
