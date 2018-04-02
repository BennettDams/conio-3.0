package de.conio.core.structure;

import java.util.HashSet;
import java.util.Set;

public abstract class Post extends Base {

	private Long id;

	private String title;

	private String body;

	private String imageUrl;

	private int rating;

	private Set<PostComment> comments = new HashSet();

	private PostCategory category;

	private Set<User> users = new HashSet();

	private Set<PostAttachment> attachments = new HashSet();

	public Post() {
		super();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PostCategory getCategory() {
		return category;
	}

	public void setCategory(PostCategory category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<PostAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<PostAttachment> attachments) {
		this.attachments = attachments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Set<PostComment> getComments() {
		return comments;
	}

	public void setComments(Set<PostComment> comments) {
		this.comments = comments;
	}

	public void addUser(User user) {
		users.add(user);
		user.getPosts().add(this);
	}

	public void removeUser(User user) {
		users.remove(user);
		user.getPosts().remove(this);
	}

	public void addAttachment(PostAttachment postAttachment) {
		attachments.add(postAttachment);
		postAttachment.getPosts().add(this);
	}

	public void removeAttachment(PostAttachment postAttachment) {
		attachments.remove(postAttachment);
		postAttachment.getPosts().remove(this);
	}

	public void addComment(PostComment comment) {
		comments.add(comment);
	}

	public void removeComment(PostComment comment) {
		comments.remove(comment);
	}

	public Set<PostComment> getTopLevelComments() {

		Set<PostComment> topComments = new HashSet<PostComment>();

		for (PostComment comment : comments) {
			if (comment.getParentId() == 0) {
				topComments.add(comment);
			}
		}
		return topComments;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}