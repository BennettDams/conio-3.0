package de.conio.core.jpa.behaviour.mapper.post;

import de.conio.core.jpa.structure.post.BookEntity;
import de.conio.core.structure.Book;

public class BookMapper {

	public static Book convert2Book(BookEntity entity) {
		Book book = new Book();
		
		
		return book;
	}

	public static BookEntity convert2BookEntity(Book book) {
		BookEntity bookEntity = new BookEntity();
		
		return bookEntity;
	}
}
