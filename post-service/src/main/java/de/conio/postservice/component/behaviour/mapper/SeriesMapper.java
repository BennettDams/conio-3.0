package de.conio.postservice.component.behaviour.mapper;

import de.conio.core.structure.Series;
import de.conio.postservice.component.structure.SeriesEntity;

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
