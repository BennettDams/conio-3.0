package de.conio.userservice.component.behaviour.mapper;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.structure.Permission;
import de.conio.core.structure.Role;
import de.conio.userservice.component.structure.PermissionEntity;
import de.conio.userservice.component.structure.RoleEntity;

public class RoleMapper {

	public static Role convert2Role(RoleEntity entity) {
		Role role = new Role();
		role.setName(entity.getName());
		role.setDisplayName(entity.getDisplayName());
		role.setDescription(entity.getDescription());
		
		/*Set<User> users = new HashSet<>();
		for (UserEntity user : entity.getUsers()) {
			users.add(UserMapper.convert2User(user));
		}
		role.setUsers(users);*/
		
		Set<Permission> permissions = new HashSet<>();
		for (PermissionEntity permission : entity.getPermissions()) {
			permissions.add(PermissionMapper.convert2Permission(permission));
		}
		role.setPermissions(permissions);
		
		role.setLastModified(entity.getLastModified());
		role.setCreateTime(entity.getCreateTime());
		return role;
	}

	public static RoleEntity convert2RoleEntity(Role role) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName(role.getName());
		roleEntity.setDisplayName(role.getDisplayName());
		roleEntity.setDescription(role.getDescription());
		
		/*Set<UserEntity> users = new HashSet<>();
		for (User user : role.getUsers()) {
			users.add(UserMapper.convert2UserEntity(user));
		}
		roleEntity.setUsers(users);*/
		
		Set<PermissionEntity> permissions = new HashSet<>();
		for (Permission permission : role.getPermissions()) {
			permissions.add(PermissionMapper.convert2PermissionEntity(permission));
		}
		roleEntity.setPermissions(permissions);
		
		roleEntity.setLastModified(role.getLastModified());
		roleEntity.setCreateTime(role.getCreateTime());
		return roleEntity;
	}
}
