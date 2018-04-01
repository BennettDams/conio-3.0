package de.conio.core.structure;

import java.util.Set;

public class PostAttachment extends Base{

	private String name;
	
	private Set<Post> posts;

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public PostAttachment(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
