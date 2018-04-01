package de.conio.conio.connector.jpa.behaviour.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.conio.connector.jpa.behaviour.dao.post.PostTutorialRepository;
import de.conio.conio.connector.jpa.behaviour.service.CrudService;
import de.conio.conio.connector.jpa.structure.post.TutorialEntity;

@Service
public class PostTutorialService extends CrudService<TutorialEntity> {
	 
	@Autowired
	PostTutorialRepository tutorialRepository;

	@Override
	protected PostTutorialRepository getRepository() {
		return tutorialRepository;
	}
}
