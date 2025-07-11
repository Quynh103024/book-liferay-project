<%@page import="com.hehehe.servicebuilder.model.Author"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="author/create/save" var="AuthorCreateURL" />
<h1>Author details:</h1>
<aui:form name="fm" action="${AuthorCreateURL}">
	<aui:model-context bean="${author}" model="<%= Author.class %>" />
	<aui:input name="name">
		<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="Add Author" />
	</aui:button-row>
</aui:form>