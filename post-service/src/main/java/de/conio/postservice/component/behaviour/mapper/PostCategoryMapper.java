package de.conio.postservice.component.behaviour.mapper;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.structure.Post;
import de.conio.core.structure.PostCategory;
import de.conio.postservice.component.structure.PostCategoryEntity;
import de.conio.postservice.component.structure.PostEntity;

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
