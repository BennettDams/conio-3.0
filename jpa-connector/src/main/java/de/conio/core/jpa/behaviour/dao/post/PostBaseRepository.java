package de.conio.core.jpa.behaviour.dao.post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import de.conio.core.jpa.structure.post.PostEntity;

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
