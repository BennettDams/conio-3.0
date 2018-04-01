package de.conio.core.structure;

import java.util.ArrayList;
import java.util.List;

public class PostComment extends Base {

	private User user;

	private Post post;

	private String body;

	private int likes;

	private int dislikes;

	private int parentId;

	private List<PostComment> childrenComments = new ArrayList();

	private int commentDepth;

	private int childCount;

	public int getCommentDepth() {
		return commentDepth;
	}

	public void setCommentDepth(int commentDepth) {
		this.commentDepth = commentDepth;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<PostComment> getChildrenComments() {
		return childrenComments;
	}

	public void setChildrenComments(List<PostComment> childrenComments) {
		this.childrenComments = childrenComments;
	}

}
