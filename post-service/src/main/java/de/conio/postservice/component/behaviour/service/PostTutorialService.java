package de.conio.postservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.Tutorial;
import de.conio.postservice.component.behaviour.mapper.PostMapper;
import de.conio.postservice.component.behaviour.repository.PostTutorialRepository;
import de.conio.postservice.component.structure.TutorialEntity;

@Service
public class PostTutorialService extends CrudService<TutorialEntity, Tutorial> {

	@Autowired
	PostTutorialRepository tutorialRepository;

	@Override
	protected PostTutorialRepository getRepository() {
		return tutorialRepository;
	}

	@Override
	public void save(Tutorial object) {
		getRepository().save((TutorialEntity) PostMapper.convert2PostEntity(object));
	}

	@Override
	public Tutorial read(long id) {
		return (Tutorial) PostMapper.convert2Post(getRepository().findById(id).get());
	}

	@Override
	public Iterable<Tutorial> readAll() {
		Iterable<TutorialEntity> entities = getRepository().findAll();
		List<Tutorial> objects = new ArrayList();
		for (TutorialEntity t : entities) {
			objects.add((Tutorial) PostMapper.convert2Post((t)));
		}

		return objects;
	}
}
