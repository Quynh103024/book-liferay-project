<%@page import="com.hehehe.servicebuilder.model.Category" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="category/update/save" var="CategoryUpdateURL" />

<%
    Category category = (Category) request.getAttribute("category");
%>

<c:if test="<%= SessionErrors.contains(request, \"invalid-category\") %>">
    <liferay-ui:error key="invalid-category" message="Invalid category ID. Please try again." />
</c:if>

<c:if test="<%= SessionErrors.contains(request, \"wrong-to-update-category\") %>">
    <liferay-ui:error key="wrong-to-update-category" message="Failed to update category. Please try again." />
</c:if>

<c:if test="<%= category != null %>">
    <h1>Category details:</h1>
    <aui:form name="fm" action="${CategoryUpdateURL}">
        <aui:input name="categoryId" type="hidden" value="${category.getCategoryId()}" />
        <aui:input name="name" value="${category.getName()}" label="Category Name">
            <aui:validator name="required" />
        </aui:input>
        <aui:button-row>
            <aui:button type="submit" value="Update Category" />
        </aui:button-row>
    </aui:form>
</c:if>

<c:if test="<%= category == null %>">
    <p>No category found to update.</p>
</c:if>
