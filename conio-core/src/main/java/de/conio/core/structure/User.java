package de.conio.core.structure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends Base {

	private String username;

	private String email;

	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private boolean enabled;
	
	private Date lastLogin;

	private Set<Post> posts = new HashSet();
	
	private Set<Role> roles = new HashSet();

	public User() {

	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		posts.add(post);
	}

	public void removePost(Post post) {
		posts.remove(post);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	public void addRole(Role role){
		roles.add(role);
		role.getUsers().add(this);
	}
	
	public void removeRole(Role role){
		roles.remove(role);
		role.getUsers().remove(this);
	}
	
}