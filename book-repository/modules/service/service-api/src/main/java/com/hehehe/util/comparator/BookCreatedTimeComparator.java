package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

import java.util.Date;

public class BookCreatedTimeComparator extends BaseCreatedTimeComparator<Book> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getCreateDate(Book entity) {
		// TODO Auto-generated method stub
		return entity.getCreateDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "book";
	}
}
