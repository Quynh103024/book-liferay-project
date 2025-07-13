<%@page import="com.hehehe.servicebuilder.model.Subtitle"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="subtitle/update/save" var="SubtitleUpdateURL" />

<%
    Subtitle subtitle = (Subtitle) request.getAttribute("subtitle");
%>

<c:if test="<%= SessionErrors.contains(request, \"invalid-subtitle\") %>">
    <liferay-ui:error key="invalid-subtitle" message="Invalid subtitle ID. Please try again." />
</c:if>

<c:if test="<%= SessionErrors.contains(request, \"wrong-to-update-subtitle\") %>">
    <liferay-ui:error key="wrong-to-update-subtitle" message="Failed to update subtitle. Please try again." />
</c:if>

<c:if test="<%= subtitle != null %>">
    <h1>Subtitle details:</h1>
    <aui:form name="fm" action="${SubtitleUpdateURL}">
        <aui:input name="subtitleId" type="hidden" value="${subtitle.getSubtitleId()}" />
        <aui:input name="name" value="${subtitle.getName()}" label="Subtitle Name">
            <aui:validator name="required" />
        </aui:input>
        <aui:button-row>
            <aui:button type="submit" value="Update Subtitle" />
        </aui:button-row>
    </aui:form>
</c:if>

<c:if test="<%= subtitle == null %>">
    <p>No subtitle found to update.</p>
</c:if>
