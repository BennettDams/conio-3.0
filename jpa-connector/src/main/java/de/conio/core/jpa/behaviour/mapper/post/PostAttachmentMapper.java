package de.conio.core.jpa.behaviour.mapper.post;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.jpa.structure.post.PostAttachmentEntity;
import de.conio.core.jpa.structure.post.PostEntity;
import de.conio.core.structure.Post;
import de.conio.core.structure.PostAttachment;

public class PostAttachmentMapper {

	public static PostAttachment convert2PostAttachment(PostAttachmentEntity entity) {
		PostAttachment postAttachment = new PostAttachment();
		postAttachment.setName(entity.getName());
		
		Set<Post> posts = new HashSet<>();
		for (PostEntity post : entity.getPosts()) {
			posts.add(PostMapper.convert2Post(post));
		}
		postAttachment.setPosts(posts);
		
		postAttachment.setLastModified(entity.getLastModified());
		postAttachment.setCreateTime(entity.getCreateTime());
		return postAttachment;
	}

	public static PostAttachmentEntity convert2PostAttachmentEntity(PostAttachment postAttachment) {
		PostAttachmentEntity postAttachmentEntity = new PostAttachmentEntity();
		postAttachmentEntity.setName(postAttachment.getName());
		
		Set<PostEntity> posts = new HashSet<>();
		for (Post post : postAttachment.getPosts()) {
			posts.add(PostMapper.convert2PostEntity(post));
		}
		postAttachmentEntity.setPosts(posts);
		
		postAttachmentEntity.setLastModified(postAttachment.getLastModified());
		postAttachmentEntity.setCreateTime(postAttachment.getCreateTime());
		return postAttachmentEntity;
	}
}
