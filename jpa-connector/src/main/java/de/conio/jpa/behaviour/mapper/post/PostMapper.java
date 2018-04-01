package de.conio.jpa.behaviour.mapper.post;

import java.util.HashSet;
import java.util.Set;

import de.conio.core.structure.Book;
import de.conio.core.structure.Movie;
import de.conio.core.structure.Post;
import de.conio.core.structure.PostAttachment;
import de.conio.core.structure.PostComment;
import de.conio.core.structure.Series;
import de.conio.core.structure.Tutorial;
import de.conio.core.structure.User;
import de.conio.jpa.behaviour.mapper.user.UserMapper;
import de.conio.jpa.structure.post.BookEntity;
import de.conio.jpa.structure.post.MovieEntity;
import de.conio.jpa.structure.post.PostAttachmentEntity;
import de.conio.jpa.structure.post.PostCommentEntity;
import de.conio.jpa.structure.post.PostEntity;
import de.conio.jpa.structure.post.SeriesEntity;
import de.conio.jpa.structure.post.TutorialEntity;
import de.conio.jpa.structure.user.UserEntity;

public class PostMapper {

	public static Post convert2Post(PostEntity entity) {

		Post post = null;

		String name = entity.getClass().getName();
		
		if (name.equals(BookEntity.class.getName())) {
			post = BookMapper.convert2Book((BookEntity) entity);
		}

		if (name.equals(MovieEntity.class.getName())) {
			post = MovieMapper.convert2Movie((MovieEntity) entity);
		}

		if (name.equals(SeriesEntity.class.getName())) {
			post = SeriesMapper.convert2Series((SeriesEntity) entity);
		}

		if (name.equals(TutorialEntity.class.getName())) {
			post = TutorialMapper.convert2Tutorial((TutorialEntity) entity);
		}
		
		if(post == null) {
			try {
				throw new ClassNotFoundException();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		post.setBody(entity.getBody());
		post.setTitle(entity.getTitle());
		post.setCategory(PostCategoryMapper.convert2PostCategory(entity.getCategory()));
		post.setImageUrl(entity.getImageUrl());

		Set<User> users = new HashSet<>();
		for (UserEntity user : entity.getUsers()) {
			users.add(UserMapper.convert2User(user));
		}
		post.setUsers(users);

		/*Set<PostAttachment> attachments = new HashSet<>();
		for (PostAttachmentEntity postAttachment : entity.getAttachments()) {
			attachments.add(PostAttachmentMapper.convert2PostAttachment(postAttachment));
		}
		post.setAttachments(attachments);*/

		post.setRating(entity.getRating());

		Set<PostComment> comments = new HashSet<>();
		for (PostCommentEntity postComment : entity.getComments()) {
			comments.add(PostCommentMapper.convert2PostComment(postComment));
		}

		post.setComments(comments);
		post.setLastModified(entity.getLastModified());
		post.setCreateTime(entity.getCreateTime());

		return post;
	}

	public static PostEntity convert2PostEntity(Post post){

		PostEntity postEntity = null;

		String name = post.getClass().getName();
		
		if (name.equals(Book.class.getName())) {
			postEntity = BookMapper.convert2BookEntity((Book) post);
		}

		if (name.equals(Movie.class.getName())) {
			postEntity = MovieMapper.convert2MovieEntity((Movie) post);
		}

		if (name.equals(Series.class.getName())) {
			postEntity = SeriesMapper.convert2SeriesEntity((Series) post);
		}

		if (name.equals(Tutorial.class.getName())) {
			postEntity = TutorialMapper.convert2TutorialEntity((Tutorial) post);
		}
		
		if(postEntity == null) {
			try {
				throw new ClassNotFoundException();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		postEntity.setBody(post.getBody());
		postEntity.setTitle(post.getTitle());
		postEntity.setCategory(PostCategoryMapper.convert2PostCategoryEntity(post.getCategory()));
		postEntity.setImageUrl(post.getImageUrl());

		Set<UserEntity> users = new HashSet<>();
		for (User user : post.getUsers()) {
			users.add(UserMapper.convert2UserEntity(user));
		}
		postEntity.setUsers(users);

		/*Set<PostAttachmentEntity> attachments = new HashSet<>();
		for (PostAttachment postAttachment : post.getAttachments()) {
			attachments.add(PostAttachmentMapper.convert2PostAttachmentEntity(postAttachment));
		}
		postEntity.setAttachments(attachments);*/

		post.setRating(post.getRating());

		Set<PostCommentEntity> comments = new HashSet<>();
		for (PostComment postComment : post.getComments()) {
			comments.add(PostCommentMapper.convert2PostCommentEntity(postComment));
		}

		postEntity.setComments(comments);
		post.setLastModified(post.getLastModified());
		post.setCreateTime(post.getCreateTime());

		return postEntity;
	}
}
