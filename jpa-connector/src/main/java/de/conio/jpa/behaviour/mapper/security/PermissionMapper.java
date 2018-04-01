package de.conio.jpa.behaviour.mapper.security;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.structure.Permission;
import de.conio.core.structure.Role;
import de.conio.jpa.structure.security.PermissionEntity;
import de.conio.jpa.structure.security.RoleEntity;

public class PermissionMapper {

	public static Permission convert2Permission(PermissionEntity entity) {
		Permission permission = new Permission();
		permission.setName(entity.getName());
		permission.setDescription(entity.getDescription());
		
		Set<Role> roles = new HashSet<>();
		for (RoleEntity roleEntity : entity.getRoles()) {
			roles.add(RoleMapper.convert2Role(roleEntity));
		}	
		permission.setRoles(roles);
		
		permission.setLastModified(entity.getLastModified());
		permission.setCreateTime(entity.getCreateTime());
		return permission;
	}

	public static PermissionEntity convert2PermissionEntity(Permission permission) {
		PermissionEntity permissionEntity = new PermissionEntity();
		permissionEntity.setName(permission.getName());
		permissionEntity.setDescription(permission.getDescription());
		
		Set<RoleEntity> roles = new HashSet<>();
		for (Role role : permission.getRoles()) {
			roles.add(RoleMapper.convert2RoleEntity(role));
		}	
		permissionEntity.setRoles(roles);
		
		permissionEntity.setLastModified(permission.getLastModified());
		permissionEntity.setCreateTime(permission.getCreateTime());
		return permissionEntity;
	}
}
