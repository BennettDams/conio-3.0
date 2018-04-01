package de.conio.postservice.component.behaviour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.core.structure.PostCategory;
import de.conio.postservice.component.behaviour.mapper.PostCategoryMapper;
import de.conio.postservice.component.behaviour.repository.PostCategoryRepository;
import de.conio.postservice.component.structure.PostCategoryEntity;

@Service
public class PostCategoryService extends CrudService<PostCategoryEntity, PostCategory> {

	@Autowired
	private PostCategoryRepository postCategoryRepository;

	protected PostCategoryRepository getRepository() {
		return postCategoryRepository;
	}

	@Override
	public void save(PostCategory object) {
		getRepository().save(PostCategoryMapper.convert2PostCategoryEntity(object));
	}

	@Override
	public PostCategory read(long id) {
		return PostCategoryMapper.convert2PostCategory(getRepository().findById(id).get());
	}

	@Override
	public Iterable<PostCategory> readAll() {
		Iterable<PostCategoryEntity> entities = getRepository().findAll();
		List<PostCategory> objects = new ArrayList();
		for (PostCategoryEntity t : entities) {
			objects.add(PostCategoryMapper.convert2PostCategory(t));
		}

		return objects;
	}

}
