package com.hehehe.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public abstract class BaseNameComparator<T> extends OrderByComparator<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final boolean ascending;
	protected abstract String getAlias();
	protected abstract String getName(T entity);
	public BaseNameComparator() {
		this(false);
	}
	public BaseNameComparator(boolean ascending) {
		this.ascending = ascending;
	}
	@Override
	public boolean isAscending() {
		return this.ascending;
	}
    @Override
    public int compare(T o1, T o2) {
        String name1 = getName(o1);
        String name2 = getName(o2);
        int result = name1.compareToIgnoreCase(name2);
        return ascending ? result : -result;
    }
    @Override
    public String getOrderBy() {
        return getAlias() + "." + getField() + " " + (ascending ? "ASC" : "DESC");
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] {getField()};
    }

    protected String getField() {
        return "name";
    }
}
