<%@ page import="com.hehehe.servicebuilder.model.Book" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ include file="/init.jsp" %>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<h2>Books by Author</h2>

<c:choose>
    <c:when test="${not empty books}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li>${book.getTitle()}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No books found for this author.</p>
    </c:otherwise>
</c:choose>
