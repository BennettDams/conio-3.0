package de.conio.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.jpa.structure.post.TutorialEntity;

@Transactional
public interface PostTutorialRepository extends PostBaseRepository<TutorialEntity> {

	
}
