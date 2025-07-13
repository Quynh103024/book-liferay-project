<%@page import="com.hehehe.servicebuilder.model.Author"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="author/create/save" var="AuthorCreateURL" />

<h1>Author Details:</h1>

<!-- Hiển thị lỗi từ SessionErrors -->
<liferay-ui:error key="required-fields-missing" message="required-fields-missing" />
<liferay-ui:error key="invalid-author-name" message="invalid-author-name" />
<liferay-ui:error key="author-name-length-invalid" message="author-name-length-invalid" />
<liferay-ui:error key="author-name-exists" message="author-name-exists" />

<aui:form name="fm" action="${AuthorCreateURL}">
	<aui:model-context bean="${author}" model="<%= Author.class %>" />
	
	<aui:input name="name" label="Author Name" />

	<aui:button-row>
		<aui:button type="button" value="Back" onclick="history.back();" />
		<aui:button type="submit" value="Add Author" />		
	</aui:button-row>
</aui:form>

