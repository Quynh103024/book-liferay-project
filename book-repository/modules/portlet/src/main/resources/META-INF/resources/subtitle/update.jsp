<%@page import="com.hehehe.servicebuilder.model.Subtitle"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="subtitle/update/save" var="SubtitleUpdateURL" />
<h1>Subtitle details:</h1>
<aui:form name="fm" action="${SubtitleUpdateURL}">
	<aui:input name="subtitleId" type="hidden"
		value="${subtitle.getSubtitleId()}" />
	<aui:input name="name" value="${subtitle.getName()}">
		<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="Update Subtitle" />
	</aui:button-row>
</aui:form>