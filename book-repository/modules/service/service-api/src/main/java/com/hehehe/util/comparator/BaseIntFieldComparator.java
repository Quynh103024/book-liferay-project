package com.hehehe.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public abstract class BaseIntFieldComparator<T> extends OrderByComparator<T> {

    private static final long serialVersionUID = 1L;
    private final boolean ascending;

    public BaseIntFieldComparator() {
        this(false);
    }

    public BaseIntFieldComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(T o1, T o2) {
        Integer val1 = getField(o1);
        Integer val2 = getField(o2);
        int result = Integer.compare(val1, val2);
        return ascending ? result : -result;
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }

    @Override
    public String getOrderBy() {
        return getAlias() + "." + getFieldName() + " " + (ascending ? "ASC" : "DESC");
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] { getFieldName() };
    }

    protected abstract Integer getField(T entity);
    protected abstract String getFieldName();
    protected abstract String getAlias();
}
