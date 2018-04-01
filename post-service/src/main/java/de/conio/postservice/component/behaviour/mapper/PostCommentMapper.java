package de.conio.postservice.component.behaviour.mapper;

import de.conio.core.structure.PostComment;
import de.conio.postservice.component.structure.PostCommentEntity;

public class PostCommentMapper {

	public static PostComment convert2PostComment(PostCommentEntity entity) {
		PostComment postComment = new PostComment();
		postComment.setCommentDepth(entity.getCommentDepth());
		postComment.setChildCount(entity.getChildCount());
		postComment.setBody(entity.getBody());
		postComment.setLikes(entity.getLikes());
		postComment.setDislikes(entity.getDislikes());
		//postComment.setUser(UserMapper.convert2User(entity.getUser()));
		postComment.setPost(PostMapper.convert2Post(entity.getPost()));
		postComment.setParentId(entity.getParentId());
		//postComment.setChildrenComments(entity.getChildrenComments());
		postComment.setLastModified(entity.getLastModified());
		postComment.setCreateTime(entity.getCreateTime());
		return postComment;
	}

	public static PostCommentEntity convert2PostCommentEntity(PostComment postComment) {
		PostCommentEntity postCommentEntity = new PostCommentEntity();
		postCommentEntity.setCommentDepth(postComment.getCommentDepth());
		postCommentEntity.setChildCount(postComment.getChildCount());
		postCommentEntity.setBody(postComment.getBody());
		postCommentEntity.setLikes(postComment.getLikes());
		postCommentEntity.setDislikes(postComment.getDislikes());
		//postCommentEntity.setUser(UserMapper.convert2UserEntity(postComment.getUser()));
		postCommentEntity.setPost(PostMapper.convert2PostEntity(postComment.getPost()));
		postCommentEntity.setParentId(postComment.getParentId());
		//postCommentEntity.setChildrenComments(postComment.getChildrenComments());
		postCommentEntity.setLastModified(postComment.getLastModified());
		postCommentEntity.setCreateTime(postComment.getCreateTime());
		return postCommentEntity;
	}
}
