package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

public class BookTitleComparator extends BaseNameComparator<Book> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "book";
	}

	@Override
	protected String getName(Book book) {
		// TODO Auto-generated method stub
		return book.getTitle();
	}
	
	@Override
	protected String getField() {
		return "title";
	}
}
