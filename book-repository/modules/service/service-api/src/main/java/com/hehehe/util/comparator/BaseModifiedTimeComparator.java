package com.hehehe.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import java.util.Date;

public abstract class BaseModifiedTimeComparator<T> extends OrderByComparator<T> {

    private static final long serialVersionUID = 1L;
    private final boolean ascending;

    public BaseModifiedTimeComparator() {
        this(false);
    }

    public BaseModifiedTimeComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(T o1, T o2) {
        Date date1 = getModifiedDate(o1);
        Date date2 = getModifiedDate(o2);
        int result = date1.compareTo(date2);
        return ascending ? result : -result;
    }

    @Override
    public String getOrderBy() {
        return getAlias() + ".modifiedDate " + (ascending ? "ASC" : "DESC");
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] {"modifiedDate"};
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }

    protected abstract Date getModifiedDate(T entity);
    protected abstract String getAlias();
}