package com.hehehe.util.comparator;

import com.hehehe.servicebuilder.model.Subtitle;

import java.util.Date;

public class SubtitleCreatedTimeComparator extends BaseCreatedTimeComparator<Subtitle> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Date getCreateDate(Subtitle entity) {
		// TODO Auto-generated method stub
		return entity.getCreateDate();
	}

	@Override
	protected String getAlias() {
		// TODO Auto-generated method stub
		return "subtitle";
	}
}