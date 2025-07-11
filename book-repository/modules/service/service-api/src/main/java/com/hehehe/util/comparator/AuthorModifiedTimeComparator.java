package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Author;

import java.util.Date;

public class AuthorModifiedTimeComparator extends BaseModifiedTimeComparator<Author>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getModifiedDate(Author entity) {
		// TODO Auto-generated method stub
		return entity.getModifiedDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "author";
	}
}
