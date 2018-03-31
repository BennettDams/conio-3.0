package de.conio.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.jpa.behaviour.dao.post.PostTutorialRepository;
import de.conio.jpa.behaviour.service.CrudService;
import de.conio.jpa.structure.post.TutorialEntity;

@Service
public class PostTutorialService extends CrudService<TutorialEntity> {
	 
	@Autowired
	PostTutorialRepository tutorialRepository;

	@Override
	protected PostTutorialRepository getRepository() {
		return tutorialRepository;
	}
}
