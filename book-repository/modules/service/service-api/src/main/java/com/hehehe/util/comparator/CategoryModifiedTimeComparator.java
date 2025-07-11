package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Category;

import java.util.Date;

public class CategoryModifiedTimeComparator extends BaseModifiedTimeComparator<Category>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getModifiedDate(Category entity) {
		// TODO Auto-generated method stub
		return entity.getModifiedDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "category";
	}
}