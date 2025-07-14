<%@ page import="com.hehehe.servicebuilder.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp" %>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<h2>Books in this Subtitle</h2>

<c:choose>
    <c:when test="${not empty books}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li>${book.getTitle()}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No books found in this subtitle.</p>
    </c:otherwise>
</c:choose>

<aui:button-row>
    <aui:button type="button" value="Back" onclick="history.back();" />
</aui:button-row>
