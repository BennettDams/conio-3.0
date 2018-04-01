package de.conio.postservice.component.behaviour.mapper;

import de.conio.core.structure.Book;
import de.conio.postservice.component.structure.BookEntity;

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
