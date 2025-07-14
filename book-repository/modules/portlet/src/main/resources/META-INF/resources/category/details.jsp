<%@page import="com.hehehe.servicebuilder.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<%
Category category = (Category) request.getAttribute("category");
%>

<c:if test="${not empty category}">
	<div>
		<strong>Name:</strong> ${category.name}
	</div>
	<div>
		<strong>Created Date:</strong>
		<fmt:formatDate value="${category.createDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>
	<div>
		<strong>Modified Date:</strong>
		<fmt:formatDate value="${category.modifiedDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>


	<portlet:renderURL var="CategoryBooksURL">
		<portlet:param name="mvcRenderCommandName" value="category/books/view" />
		<portlet:param name="categoryId" value="${category.categoryId}" />
	</portlet:renderURL>
	<aui:a cssClass="btn btn-secondary" href="${CategoryBooksURL}">View Books Related In This Category</aui:a>
</c:if>

<c:if test="${empty category}">
	<p>Category not found.</p>
</c:if>

<aui:button-row>
	<aui:button type="button" value="Back" onclick="history.back();" />
</aui:button-row>
