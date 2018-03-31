package de.conio.jpa.structure.post;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.conio.jpa.structure.BaseEntity;

@Entity
@Table(name = "post_category")
public class PostCategoryEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private Set<PostEntity> posts;

	public PostCategoryEntity(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}
	
}
