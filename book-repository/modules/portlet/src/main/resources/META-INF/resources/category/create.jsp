<%@page import="com.hehehe.servicebuilder.model.Category"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="category/create/save" var="CategoryCreateURL" />
<h1>Category detail:</h1>
<aui:form name="fm" action="${CategoryCreateURL}">
	<aui:model-context bean="${category}" model="<%= Category.class %>" />
	<aui:input name="name">
		<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="Add Category" />
	</aui:button-row>
</aui:form>