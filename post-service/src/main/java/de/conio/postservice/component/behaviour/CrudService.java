package de.conio.conio.connector.jpa.behaviour.service;

import java.util.ArrayList;

import org.hibernate.cfg.ExtendsQueueEntry;
import org.springframework.data.repository.CrudRepository;

import de.conio.conio.connector.jpa.structure.BaseEntity;
import de.conio.conio.model.Base;

public abstract class CrudService<T extends BaseEntity> {

	protected abstract CrudRepository<T, Long> getRepository();

	//save and update
	public void save(T entity) {
		getRepository().save(entity);
	}

	public void delete(long id) {
		getRepository().delete(id);
	}

	public T read(long id) {
		return getRepository().findOne(id);
	}
	
	public Iterable<T> readAll(){
		return getRepository().findAll();
	}

}
