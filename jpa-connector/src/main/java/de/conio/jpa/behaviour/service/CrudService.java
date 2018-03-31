package de.conio.jpa.behaviour.service;

import org.springframework.data.repository.CrudRepository;

import de.conio.jpa.structure.BaseEntity;

public abstract class CrudService<T extends BaseEntity> {

	protected abstract CrudRepository<T, Long> getRepository();

	//save and update
	public void save(T entity) {
		getRepository().save(entity);
	}

	public void delete(long id) {
		getRepository().deleteById(id);
	}

	public T read(long id) {
		return getRepository().findById(id).get();
	}
	
	public Iterable<T> readAll(){
		return getRepository().findAll();
	}

}
