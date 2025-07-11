package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

public class BookStockComparator extends BookBaseIntFieldComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Integer getField(Book entity) {
		// TODO Auto-generated method stub
		return entity.getStock();
	}

	@Override
	protected String getFieldName() {
		// TODO Auto-generated method stub
		return "stock";
	}
	
}
