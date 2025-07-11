<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:renderURL var="BookCreateURL">
	<portlet:param name="mvcRenderCommandName" value="book/create/view" />
</portlet:renderURL>
<aui:a cssClass="btn btn-success" href="${BookCreateURL}">Add Book</aui:a>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found" total="${totalBook}">
	<liferay-ui:search-container-results results="${entries}" />
	<liferay-ui:search-container-row
		className="com.hehehe.servicebuilder.model.Book"
		keyProperty="bookId" modelVar="entry" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text property="title" />
		<liferay-ui:search-container-column-text property="description" />
		<liferay-ui:search-container-column-text property="price" />
		<liferay-ui:search-container-column-text property="stock" />
		<liferay-ui:search-container-column-text property="num_pages" />
		<liferay-ui:search-container-column-text property="published_year" />
		<liferay-ui:search-container-column-text name="Actions">
			<portlet:renderURL var="BookUpdateURL">
				<portlet:param name="mvcRenderCommandName" value="book/update/view" />
				<portlet:param name="bookId" value="${entry.bookId}" />
			</portlet:renderURL>
			<aui:a cssClass="btn btn-info" href="${BookUpdateURL}">Update</aui:a>
			<portlet:actionURL name="book/delete/save" var="BookDeleteURL">
				<portlet:param name="bookId" value="${entry.bookId}" />
			</portlet:actionURL>
			<aui:a cssClass="btn btn-danger" href="${BookDeleteURL}"
				onclick="return confirm(’Are you sure you want to delete this book?\n (This will also delete all shoes associated with the book)’);">Delete</aui:a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>