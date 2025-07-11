<%@page import="com.hehehe.servicebuilder.model.Author"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="author/update/save" var="AuthorUpdateURL" />
<h1>Author details:</h1>
<aui:form name="fm" action="${AuthorUpdateURL}">
	<aui:input name="authorId" type="hidden"
		value="${author.getAuthorId()}"></aui:input>
	<aui:input name="name" value="${author.getName()}">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="Update Author" />
	</aui:button-row>
</aui:form>