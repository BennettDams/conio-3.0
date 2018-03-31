package de.conio.core.jpa.behaviour.dao.post;

import javax.transaction.Transactional;

import de.conio.core.jpa.structure.post.TutorialEntity;

@Transactional
public interface PostTutorialRepository extends PostBaseRepository<TutorialEntity> {

	
}
