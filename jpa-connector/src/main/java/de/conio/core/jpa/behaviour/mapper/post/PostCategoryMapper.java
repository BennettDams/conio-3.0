package de.conio.core.jpa.behaviour.mapper.post;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.jpa.structure.post.PostCategoryEntity;
import de.conio.core.jpa.structure.post.PostEntity;
import de.conio.core.structure.Post;
import de.conio.core.structure.PostCategory;

public class PostCategoryMapper {

	public static PostCategory convert2PostCategory(PostCategoryEntity entity) {
		PostCategory postCategory = new PostCategory();
		postCategory.setName(entity.getName());
		
		Set<Post> posts = new HashSet<>();
		for (PostEntity postEntity : entity.getPosts()) {
			posts.add(PostMapper.convert2Post(postEntity));
		}
		postCategory.setPosts(posts);
		
		postCategory.setLastModified(entity.getLastModified());
		postCategory.setCreateTime(entity.getCreateTime());
		return postCategory;
	}

	public static PostCategoryEntity convert2PostCategoryEntity(PostCategory postCategory) {
		PostCategoryEntity postCategoryEntity = new PostCategoryEntity();
		postCategoryEntity.setName(postCategory.getName());
		
		Set<PostEntity> posts = new HashSet<>();
		for (Post post : postCategory.getPosts()) {
			posts.add(PostMapper.convert2PostEntity(post));
		}
		postCategoryEntity.setPosts(posts);
		
		postCategoryEntity.setLastModified(postCategory.getLastModified());
		postCategoryEntity.setCreateTime(postCategory.getCreateTime());
		return postCategoryEntity;
	}
}
