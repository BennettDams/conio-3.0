package de.conio.jpa.structure.post;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import de.conio.jpa.structure.BaseEntity;

@Entity
@Table(name = "post_attachment")
public class PostAttachmentEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "attachments")
	private Set<PostEntity> posts;


	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}

	public PostAttachmentEntity(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
