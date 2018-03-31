package de.conio.core.jpa.structure.user;

import java.util.Date;
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

import de.conio.core.jpa.structure.BaseEntity;
import de.conio.core.jpa.structure.post.PostEntity;
import de.conio.core.jpa.structure.security.RoleEntity;

@Entity
@Table(name = "User")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "last_login")
	private Date lastLogin;

	@ManyToMany(mappedBy = "users")
	private Set<PostEntity> posts = new HashSet();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "user_has_role", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet();

	public UserEntity() {

	}

	public UserEntity(String username, String email, String password) {
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

	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void addPost(PostEntity post) {
		posts.add(post);
	}

	public void removePost(PostEntity post) {
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

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}
	
	public void addRole(RoleEntity role){
		roles.add(role);
		role.getUsers().add(this);
	}
	
	public void removeRole(RoleEntity role){
		roles.remove(role);
		role.getUsers().remove(this);
	}
	
}