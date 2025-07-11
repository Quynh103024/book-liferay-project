<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:renderURL var="AuthorCreateURL">
	<portlet:param name="mvcRenderCommandName" value="author/create/view" />
</portlet:renderURL>
<aui:a cssClass="btn btn-success" href="${AuthorCreateURL}">Add Author</aui:a>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found" total="${totalAuthor}">
	<liferay-ui:search-container-results results="${entries}" />
	<liferay-ui:search-container-row
		className="com.hehehe.servicebuilder.model.Author"
		keyProperty="authorId" modelVar="entry" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text name="Actions">
			<portlet:renderURL var="AuthorUpdateURL">
				<portlet:param name="mvcRenderCommandName" value="author/update/view" />
				<portlet:param name="authorId" value="${entry.authorId}" />
			</portlet:renderURL>
			<aui:a cssClass="btn btn-info" href="${AuthorUpdateURL}">Update</aui:a>
			<portlet:actionURL name="author/delete/save" var="AuthorDeleteURL">
				<portlet:param name="authorId" value="${entry.authorId}" />
			</portlet:actionURL>
			<aui:a cssClass="btn btn-danger" href="${AuthorDeleteURL}"
				onclick="return confirm(’Are you sure you want to delete this author?\n (This will also delete all shoes associated with the author)’);">Delete</aui:a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>