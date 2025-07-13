<%@page import="com.hehehe.servicebuilder.model.Subtitle"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="subtitle/create/save" var="SubtitleCreateURL" />

<h1>Subtitle Details:</h1>

<!-- Hiển thị lỗi từ SessionErrors -->
<liferay-ui:error key="required-fields-missing" message="required-fields-missing" />
<liferay-ui:error key="invalid-subtitle-name" message="invalid-subtitle-name" />
<liferay-ui:error key="subtitle-name-length-invalid" message="subtitle-name-length-invalid" />
<liferay-ui:error key="subtitle-name-exists" message="subtitle-name-exists" />

<aui:form name="fm" action="${SubtitleCreateURL}">
    <aui:model-context bean="${subtitle}" model="<%= Subtitle.class %>" />

    <aui:input name="name" label="Subtitle Name" />

    <aui:button-row>
        <aui:button type="submit" value="Add Subtitle" />
    </aui:button-row>
</aui:form>
