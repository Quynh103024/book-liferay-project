package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Author;

import java.util.Date;

public class AuthorCreatedTimeComparator extends BaseCreatedTimeComparator<Author> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getCreateDate(Author entity) {
		// TODO Auto-generated method stub
		return entity.getCreateDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "author";
	}
}