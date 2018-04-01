package de.conio.postservice.component.behaviour.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import de.conio.postservice.component.structure.PostEntity;

/**
 * 
 * @author Jonas
 *
 * @param <T>
 * http://blog.netgloo.com/2014/12/18/handling-entities-inheritance-with-spring-data-jpa/
 * https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-springdatajpa-inheritance
 */

@NoRepositoryBean
public interface PostBaseRepository<T extends PostEntity> extends CrudRepository<T, Long> {

}
