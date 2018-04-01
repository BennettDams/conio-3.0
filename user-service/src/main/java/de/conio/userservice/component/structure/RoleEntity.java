package de.conio.userservice.component.structure;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "description")
	private String description;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<UserEntity> users = new HashSet<UserEntity>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinTable(name = "role_has_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	@JsonManagedReference
	private Set<PermissionEntity> permissions = new HashSet<PermissionEntity>();

	public RoleEntity() {

	}

	public RoleEntity(String name, String displayName, String description) {
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

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Set<PermissionEntity> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionEntity> permissions) {
		this.permissions = permissions;
	}

	public void addPermission(PermissionEntity permission) {
		permissions.add(permission);
		permission.getRoles().add(this);
	}
	
	public void removePermission(PermissionEntity permission) {
		permissions.remove(permission);
		permission.getRoles().remove(this);
	}
}
