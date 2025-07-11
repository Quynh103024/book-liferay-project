package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Subtitle;

import java.util.Date;

public class SubtitleModifiedTimeComparator extends BaseModifiedTimeComparator<Subtitle>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getModifiedDate(Subtitle entity) {
		// TODO Auto-generated method stub
		return entity.getModifiedDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "subtitle";
	}
}
