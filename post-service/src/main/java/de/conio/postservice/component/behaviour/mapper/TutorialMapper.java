package de.conio.postservice.component.behaviour.mapper;

import de.conio.core.structure.Tutorial;
import de.conio.postservice.component.structure.TutorialEntity;

public class TutorialMapper {

	public static Tutorial convert2Tutorial(TutorialEntity entity) {
		Tutorial tutorial = new Tutorial();
	
		return tutorial;
	}

	public static TutorialEntity convert2TutorialEntity(Tutorial tutorial) {
		TutorialEntity tutorialEntity = new TutorialEntity();
	
		return tutorialEntity;
	}
}
