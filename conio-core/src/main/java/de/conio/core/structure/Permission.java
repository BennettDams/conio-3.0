package de.conio.core.structure;

import java.util.HashSet;
import java.util.Set;


public class Permission extends Base{

	private String name;
	
	private String description;
	
	private Set<Role> roles = new HashSet();
	
	public Permission() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
