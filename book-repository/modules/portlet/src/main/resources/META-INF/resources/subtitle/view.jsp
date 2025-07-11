<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:renderURL var="SubtitleCreateURL">
	<portlet:param name="mvcRenderCommandName" value="subtitle/create/view" />
</portlet:renderURL>
<aui:a cssClass="btn btn-success" href="${SubtitleCreateURL}">Add Subtitle</aui:a>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found" total="${totalSubtitle}">
	<liferay-ui:search-container-results results="${entries}" />
	<liferay-ui:search-container-row
		className="com.hehehe.servicebuilder.model.Subtitle"
		keyProperty="subtitleId" modelVar="entry" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text name="Actions">
			<portlet:renderURL var="SubtitleUpdateURL">
				<portlet:param name="mvcRenderCommandName" value="subtitle/update/view" />
				<portlet:param name="subtitleId" value="${entry.subtitleId}" />
			</portlet:renderURL>
			<aui:a cssClass="btn btn-info" href="${SubtitleUpdateURL}">Update</aui:a>
			<portlet:actionURL name="subtitle/delete/save" var="SubtitleDeleteURL">
				<portlet:param name="subtitleId" value="${entry.subtitleId}" />
			</portlet:actionURL>
			<aui:a cssClass="btn btn-danger" href="${SubtitleDeleteURL}"
				onclick="return confirm(’Are you sure you want to delete this subtitle?\n (This will also delete all shoes associated with the subtitle)’);">Delete</aui:a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>