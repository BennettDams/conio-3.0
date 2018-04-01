package de.conio.postservice.component.structure;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "post_category")
public class PostCategoryEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	@JsonBackReference
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
