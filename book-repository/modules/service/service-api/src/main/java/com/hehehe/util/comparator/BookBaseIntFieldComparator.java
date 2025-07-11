package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

public abstract class BookBaseIntFieldComparator extends BaseIntFieldComparator<Book>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected String getAlias() {
		return "book";
	}
}
