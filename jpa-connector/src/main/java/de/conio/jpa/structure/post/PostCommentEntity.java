package de.conio.jpa.structure.post;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Field;

import de.conio.jpa.structure.BaseEntity;
import de.conio.jpa.structure.user.UserEntity;

@Entity
@Table(name = "post_comment")
public class PostCommentEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private PostEntity post;

	@Field
	@Column(name = "body")
	private String body;

	@Column(name = "likes")
	private int likes;

	@Column(name = "dislikes")
	private int dislikes;

	@Column(name = "parent_id")
	private int parentId;

	@OneToMany(mappedBy = "parentId")
	private List<PostCommentEntity> childrenComments = new ArrayList<>();

	@Transient
	private int commentDepth;

	@Transient
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<PostCommentEntity> getChildrenComments() {
		return childrenComments;
	}

	public void setChildrenComments(List<PostCommentEntity> childrenComments) {
		this.childrenComments = childrenComments;
	}

}
