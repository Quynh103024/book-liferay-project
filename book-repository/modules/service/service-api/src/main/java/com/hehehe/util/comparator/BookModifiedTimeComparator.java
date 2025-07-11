package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

import java.util.Date;

public class BookModifiedTimeComparator extends BaseModifiedTimeComparator<Book>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getModifiedDate(Book entity) {
		// TODO Auto-generated method stub
		return entity.getModifiedDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "book";
	}
}