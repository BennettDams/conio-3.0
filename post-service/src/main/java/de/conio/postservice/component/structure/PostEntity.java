package de.conio.postservice.component.structure;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;
import org.hibernate.search.annotations.Field;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "post")
public abstract class PostEntity extends BaseEntity {

	@Field
	@Column(name = "title")
	private String title;

	@Field
	@Column(name = "body")
	private String body;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "rating")
	private int rating;

	@OrderBy(clause = "create_time asc")
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<PostCommentEntity> comments = new HashSet<PostCommentEntity>();

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id")
	private PostCategoryEntity category;

	/**
	 * The HashSet enables Hibernate to execute better SQL Source:
	 * https://vladmihalcea.com/2017/05/10/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
	 */
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "post_has_user", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonManagedReference
	private Set<UserEntity> users = new HashSet();*/

	/*@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "post_has_post_attachment", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "attachment_id"))
	@JsonManagedReference
	private Set<PostAttachmentEntity> attachments = new HashSet();*/

	public PostEntity() {
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

	public PostCategoryEntity getCategory() {
		return category;
	}

	public void setCategory(PostCategoryEntity category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/*public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}*/

	/*public Set<PostAttachmentEntity> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<PostAttachmentEntity> attachments) {
		this.attachments = attachments;
	}*/

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Set<PostCommentEntity> getComments() {
		return comments;
	}

	public void setComments(Set<PostCommentEntity> comments) {
		this.comments = comments;
	}

	/*public void addUser(UserEntity user) {
		users.add(user);
		user.getPosts().add(this);
	}

	public void removeUser(UserEntity user) {
		users.remove(user);
		user.getPosts().remove(this);
	}*/

	/*public void addAttachment(PostAttachmentEntity postAttachment) {
		attachments.add(postAttachment);
		postAttachment.getPosts().add(this);
	}

	public void removeAttachment(PostAttachmentEntity postAttachment) {
		attachments.remove(postAttachment);
		postAttachment.getPosts().remove(this);
	}*/

	public void addComment(PostCommentEntity comment) {
		comments.add(comment);
	}

	public void removeComment(PostCommentEntity comment) {
		comments.remove(comment);
	}

	public Set<PostCommentEntity> getTopLevelComments() {

		Set<PostCommentEntity> topComments = new HashSet<PostCommentEntity>();

		for (PostCommentEntity comment : comments) {
			if (comment.getParentId() == 0) {
				topComments.add(comment);
			}
		}
		return topComments;
	}
}