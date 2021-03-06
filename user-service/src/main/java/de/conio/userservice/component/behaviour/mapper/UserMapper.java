package de.conio.userservice.component.behaviour.mapper;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.structure.Role;
import de.conio.core.structure.User;
import de.conio.userservice.component.structure.RoleEntity;
import de.conio.userservice.component.structure.UserEntity;

public class UserMapper {

	public static User convert2User(UserEntity entity) {
		User user = new User();
		user.setUsername(entity.getUsername());
		user.setEmail(entity.getEmail());
		user.setPassword(entity.getPassword());
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setEnabled(entity.isEnabled());
		user.setLastLogin(entity.getLastLogin());
		
		Set<Role> roles = new HashSet<Role>();
		for (RoleEntity roleEntity : entity.getRoles()) {
			System.out.println(roleEntity.getName());
			roles.add(RoleMapper.convert2Role(roleEntity));
		}
		
		user.setRoles(roles);
		
		/*Set<Post> posts = new HashSet<>();
		for (PostEntity postEntity : entity.getPosts()) {
			posts.add(PostMapper.convert2Post(postEntity));
		}
		user.setPosts(posts);*/
		
		user.setLastModified(entity.getLastModified());
		user.setCreateTime(entity.getCreateTime());
		
		return user;
	}

	public static UserEntity convert2UserEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEnabled(user.isEnabled());
		userEntity.setLastLogin(user.getLastLogin());
		
		Set<RoleEntity> roles = new HashSet<>();
		for (Role role : user.getRoles()) {
			roles.add(RoleMapper.convert2RoleEntity(role));
		}
		
		userEntity.setRoles(roles);
		
		/*Set<PostEntity> posts = new HashSet<>();
		for (Post post : user.getPosts()) {
			posts.add(PostMapper.convert2PostEntity(post));
		}
		userEntity.setPosts(posts);*/
		
		
		userEntity.setLastModified(user.getLastModified());
		userEntity.setCreateTime(user.getCreateTime());
		return userEntity;
	}
}
