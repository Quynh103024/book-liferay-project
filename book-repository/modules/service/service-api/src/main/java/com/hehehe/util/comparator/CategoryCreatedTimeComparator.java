package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Category;

import java.util.Date;

public class CategoryCreatedTimeComparator extends BaseCreatedTimeComparator<Category> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getCreateDate(Category entity) {
		// TODO Auto-generated method stub
		return entity.getCreateDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "category";
	}
}