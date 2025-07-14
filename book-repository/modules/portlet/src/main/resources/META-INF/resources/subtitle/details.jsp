<%@page import="com.hehehe.servicebuilder.model.Subtitle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<%
Subtitle subtitle = (Subtitle) request.getAttribute("subtitle");
%>

<c:if test="${not empty subtitle}">
	<div>
		<strong>Name:</strong> ${subtitle.name}
	</div>
	<div>
		<strong>Created Date:</strong>
		<fmt:formatDate value="${subtitle.createDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>
	<div>
		<strong>Modified Date:</strong>
		<fmt:formatDate value="${subtitle.modifiedDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>

	<portlet:renderURL var="SubtitleBooksURL">
		<portlet:param name="mvcRenderCommandName" value="subtitle/books/view" />
		<portlet:param name="subtitleId" value="${subtitle.subtitleId}" />
	</portlet:renderURL>
	<aui:a cssClass="btn btn-secondary" href="${SubtitleBooksURL}">View Books Related To This Subtitle</aui:a>
</c:if>

<c:if test="${empty subtitle}">
	<p>Subtitle not found.</p>
</c:if>

<aui:button-row>
	<aui:button type="button" value="Back" onclick="history.back();" />
</aui:button-row>
