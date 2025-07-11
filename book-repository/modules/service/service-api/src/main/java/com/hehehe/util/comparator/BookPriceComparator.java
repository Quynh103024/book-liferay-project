package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Book;

public class BookPriceComparator extends BookBaseIntFieldComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Integer getField(Book entity) {
		// TODO Auto-generated method stub
		return entity.getPrice();
	}

	@Override
	protected String getFieldName() {
		// TODO Auto-generated method stub
		return "price";
	}
	
}
