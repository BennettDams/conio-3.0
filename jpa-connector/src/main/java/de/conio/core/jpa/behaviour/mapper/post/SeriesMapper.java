package de.conio.core.jpa.behaviour.mapper.post;

import de.conio.core.jpa.structure.post.SeriesEntity;
import de.conio.core.structure.Series;

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
