package de.conio.jpa.behaviour.mapper.post;

import de.conio.core.structure.Tutorial;
import de.conio.jpa.structure.post.TutorialEntity;

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
