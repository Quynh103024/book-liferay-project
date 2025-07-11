package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Author;

public class AuthorNameComparator extends BaseNameComparator<Author>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "author";
	}

	@Override
	protected String getName(Author entity) {
		// TODO Auto-generated method stub
		return entity.getName();
	}
	
}
