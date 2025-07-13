<%@page import="com.hehehe.servicebuilder.model.Author"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="author/update/save" var="AuthorUpdateURL" />

<%
    Author author = (Author) request.getAttribute("author");
%>

<c:if test="<%= SessionErrors.contains(request, \"invalid-author\") %>">
    <liferay-ui:error key="invalid-author" message="Invalid author ID. Please try again." />
</c:if>

<c:if test="<%= SessionErrors.contains(request, \"wrong-to-update-author\") %>">
    <liferay-ui:error key="wrong-to-update-author" message="Failed to update author. Please try again." />
</c:if>

<c:if test="<%= author != null %>">
    <h1>Author details:</h1>
    <aui:form name="fm" action="${AuthorUpdateURL}">
        <aui:input name="authorId" type="hidden" value="${author.getAuthorId()}" />
        <aui:input name="name" value="${author.getName()}" label="Author Name">
            <aui:validator name="required" />
        </aui:input>
        
        <aui:button-row>
        	<aui:button type="button" value="Back" onclick="history.back();" />
            <aui:button type="submit" value="Update Author" />
        </aui:button-row>
    </aui:form>
</c:if>


<c:if test="<%= author == null %>">
    <p>No author found to update.</p>
</c:if>
