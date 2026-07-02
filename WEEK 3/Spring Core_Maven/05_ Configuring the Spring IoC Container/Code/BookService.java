package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

	private BookRepository bookRepository;

	// Spring calls this to inject the dependency
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void listBooks() {
		bookRepository.findAllBooks();
	}
}
