<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.hehehe.servicebuilder.model.Book" %>
<%@ page import="com.hehehe.servicebuilder.model.Category" %>
<%@ page import="com.hehehe.servicebuilder.model.Subtitle" %>
<%@ page import="com.hehehe.servicebuilder.model.Author" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>

<liferay-theme:defineObjects />

<%
	Book book = (Book) request.getAttribute("book");
	Category category = (Category) request.getAttribute("category");
	Subtitle subtitle = (Subtitle) request.getAttribute("subtitle");
	List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<liferay-ui:error key="book-not-found" message="Book not found." />
<liferay-ui:error key="author-not-found" message="Author not found." />
<liferay-ui:error key="bookauthor-load-error" message="Error while loading up BookAuthor." />
<liferay-ui:error key="permission-denied" message="Permission denied." />
<liferay-ui:error key="unexpected-error" message="Unexpected Error." />

<aui:fieldset label="Book Full Details" cssClass="mt-3">
    <aui:row>
        <aui:col width="50">
            <strong>Title:</strong> ${book.title} <br />
            <strong>Description:</strong> ${book.description} <br />
            <strong>Price:</strong> ${book.price} <br />
            <strong>Stock:</strong> ${book.stock} <br />
            <strong>Number of Pages:</strong> ${book.num_pages} <br />
            <strong>Published Year:</strong> ${book.published_year} <br />
        </aui:col>
        <aui:col width="50">
            <strong>Category:</strong> ${category.name} <br />
            <strong>Subtitle:</strong> ${subtitle.name} <br />
            <strong>Created At:</strong> ${book.createDate} <br />
            <strong>Last Modified:</strong> ${book.modifiedDate} <br />
            <strong>Thumbnail:</strong><br/>
            <img src="${book.thumbnail}" alt="Thumbnail" style="max-width: 200px;" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col>
            <strong>Authors:</strong>
            <ul>
                <c:forEach var="author" items="${authors}">
                    <li>${author.name}</li>
                </c:forEach>
            </ul>
        </aui:col>
    </aui:row>
</aui:fieldset>

<aui:button-row>
    <aui:button type="button" value="Back" onClick="history.back();" cssClass="btn-secondary" />
</aui:button-row>
