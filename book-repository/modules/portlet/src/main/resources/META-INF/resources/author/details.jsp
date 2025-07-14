<%@page import="com.hehehe.servicebuilder.model.Author"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<%
Author author = (Author) request.getAttribute("author");
List<Author> authorsCollab = (List<Author>) request.getAttribute("authors");
%>

<c:if test="${not empty author}">
	<div>
		<strong>Name:</strong> ${author.name}
	</div>
	<div>
		<strong>Created Date:</strong>
		<fmt:formatDate value="${author.createDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>
	<div>
		<strong>Modified Date:</strong>
		<fmt:formatDate value="${author.modifiedDate}" pattern="dd/MM/yyyy HH:mm:ss" />
	</div>

	<div>
		<strong>Collaborated Authors:</strong>
		<c:choose>
			<c:when test="${not empty authorsCollab}">
				<ul>
					<c:forEach var="collabAuthor" items="${authorsCollab}">
						<li>${collabAuthor.name}</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p>No collaborated authors found.</p>
			</c:otherwise>
		</c:choose>
	</div>

	<portlet:renderURL var="AuthorBooksURL">
		<portlet:param name="mvcRenderCommandName" value="author/books/view" />
		<portlet:param name="authorId" value="${author.authorId}" />
	</portlet:renderURL>
	<aui:a cssClass="btn btn-secondary" href="${AuthorBooksURL}">View Books By This Author</aui:a>

</c:if>

<c:if test="${empty author}">
	<p>Author not found.</p>
</c:if>

<aui:button-row>
	<aui:button type="button" value="Back" onclick="history.back();" />
</aui:button-row>
