package de.conio.core.structure;

import java.util.HashSet;
import java.util.Set;

public class Role extends Base {

	private String name;

	private String displayName;

	private String description;

	private Set<User> users = new HashSet();

	private Set<Permission> permissions = new HashSet();

	public Role() {

	}

	public Role(String name, String displayName, String description) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public void addPermission(Permission permission) {
		permissions.add(permission);
		permission.getRoles().add(this);
	}
	
	public void removePermission(Permission permission) {
		permissions.remove(permission);
		permission.getRoles().remove(this);
	}
}
