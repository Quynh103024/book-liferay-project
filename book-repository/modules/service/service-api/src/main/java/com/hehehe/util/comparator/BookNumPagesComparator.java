package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

public class BookNumPagesComparator extends BookBaseIntFieldComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Integer getField(Book entity) {
		// TODO Auto-generated method stub
		return entity.getNum_pages();
	}

	@Override
	protected String getFieldName() {
		// TODO Auto-generated method stub
		return "num_pages";
	}
	
}