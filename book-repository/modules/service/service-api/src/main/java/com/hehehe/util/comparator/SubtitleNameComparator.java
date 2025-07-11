package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Subtitle;

public class SubtitleNameComparator extends BaseNameComparator<Subtitle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "subtitle";
	}

	@Override
	protected String getName(Subtitle entity) {
		// TODO Auto-generated method stub
		return entity.getName();
	}
	
}
