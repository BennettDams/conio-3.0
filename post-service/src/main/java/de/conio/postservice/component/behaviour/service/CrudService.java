package de.conio.postservice.component.behaviour.service;

import org.springframework.data.repository.CrudRepository;

import de.conio.core.structure.Base;
import de.conio.postservice.component.structure.BaseEntity;

public abstract class CrudService<T extends BaseEntity, I extends Base> {

	protected abstract CrudRepository<T, Long> getRepository();

	//save and update
	public abstract void save(I object);

	public void delete(long id) {
		getRepository().deleteById(id);
	}

	public abstract I read(long id);
	
	public abstract Iterable<I> readAll();

}
