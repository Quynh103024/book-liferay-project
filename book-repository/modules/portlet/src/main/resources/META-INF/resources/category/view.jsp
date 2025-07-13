<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<portlet:renderURL var="CategoryCreateURL">
	<portlet:param name="mvcRenderCommandName" value="category/create/view" />
</portlet:renderURL>

<aui:a cssClass="btn btn-success" href="${CategoryCreateURL}">Add Category</aui:a>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found" total="${totalCategory}"
	orderByCol="${orderByCol}"	
	orderByType="${orderByType}">
	
	
	<liferay-ui:search-container-results results="${entries}" />
	<liferay-ui:search-container-row
		className="com.hehehe.servicebuilder.model.Category"
		keyProperty="categoryId" modelVar="entry" escapedModel="<%=true%>">
		
		<liferay-ui:search-container-column-text property="name" orderable="true"/>
		
		<liferay-ui:search-container-column-text name="Actions">

			<portlet:renderURL var="CategoryDetailURL">
				<portlet:param name="mvcRenderCommandName" value="category/detail/view" />
				<portlet:param name="categoryId" value="${entry.categoryId}" />
			</portlet:renderURL>
			<aui:a cssClass="btn btn-primary" href="${CategoryDetailURL}">Details</aui:a>

			<portlet:renderURL var="CategoryUpdateURL">
				<portlet:param name="mvcRenderCommandName" value="category/update/view" />
				<portlet:param name="categoryId" value="${entry.categoryId}" />
			</portlet:renderURL>
			<aui:a cssClass="btn btn-info" href="${CategoryUpdateURL}">Update</aui:a>

			<portlet:actionURL name="category/delete/save" var="CategoryDeleteURL">
				<portlet:param name="categoryId" value="${entry.categoryId}" />
			</portlet:actionURL>
			<aui:a cssClass="btn btn-danger" href="${CategoryDeleteURL}"
				onclick="return confirm('Are you sure you want to delete this category?\n(This will also delete all books associated with the category)');">Delete</aui:a>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
