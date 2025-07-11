<%@page import="com.hehehe.servicebuilder.model.Subtitle"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="subtitle/create/save" var="SubtitleCreateURL" />
<h1>Subtitle detail:</h1>
<aui:form name="fm" action="${SubtitleCreateURL}">
	<aui:model-context bean="${subtitle}" model="<%= Subtitle.class %>" />
	<aui:input name="name">
		<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="Add Subtitle" />
	</aui:button-row>
</aui:form>