package de.conio.core.structure;

import java.util.Set;

public class PostCategory extends Base{
	
	private String name;
	
	private Set<Post> posts;

	public PostCategory(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
}
