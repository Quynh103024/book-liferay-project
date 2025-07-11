package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Category;

public class CategoryNameComparator extends BaseNameComparator<Category>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "category";
	}
	@Override
	protected String getName(Category entity) {
		// TODO Auto-generated method stub
		return entity.getName();
	}
}
