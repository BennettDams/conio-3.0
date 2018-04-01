package de.conio.postservice.component.behaviour.repository;

import javax.transaction.Transactional;

import de.conio.postservice.component.structure.TutorialEntity;

@Transactional
public interface PostTutorialRepository extends PostBaseRepository<TutorialEntity> {

	
}
