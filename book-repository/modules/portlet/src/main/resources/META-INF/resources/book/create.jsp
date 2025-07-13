<%@page import="com.hehehe.servicebuilder.model.Book"%>
<%@ page import="java.time.LocalDate"%>

<%
int currentYear = LocalDate.now().getYear();
int startYear = 105;
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="book/create/save" var="BookCreateURL" />
<h1>Book details:</h1>
<aui:form name="fm" action="${BookCreateURL}">
	<aui:model-context bean="${book}" model="<%= Book.class %>" />
	<aui:input name="title">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="description">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="thumbnail" type="text" maxlength="500" size="200">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="price" type="number" label="Price">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="stock" type="number" label="Stock">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="pages" type="number" label="Number of Pages">
		<aui:validator name="required" />
	</aui:input>
	<aui:select name="publicYear" label="Publication Year">
		<c:forEach var="year" begin="<%=startYear%>" end="<%=currentYear%>"
			step="1">
			<aui:option value="${year}" selected="${book.published_year == year}">${year}</aui:option>
		</c:forEach>
	</aui:select>
	<!-- Author (Multiple select) -->
	<aui:select name="authorIds" label="Author" multiple="true"
		style="height: 200px; overflow-y: scroll;">
		<c:forEach var="author" items="${allAuthor}">
			<aui:option value="${author.authorId}"
				selected="${book != null && book.authorIds != null && book.authorIds.contains(author.authorId)}">
            ${author.name}
        </aui:option>
		</c:forEach>
	</aui:select>
	<!-- Category (Single select) -->
	<aui:select name="categoryId" label="Category">
		<c:forEach var="category" items="${allCategory}">
			<aui:option value="${category.categoryId}"
				selected="${book.categoryId == category.categoryId}">
            ${category.name}
        </aui:option>
		</c:forEach>
	</aui:select>

	<!-- Subtitle (Single select) -->
	<aui:select name="subtitleId" label="Subtitle">
		<c:forEach var="subtitle" items="${allSubtitle}">
			<aui:option value="${subtitle.subtitleId}"
				selected="${book.subtitleId == subtitle.subtitleId}">
            ${subtitle.name}
        </aui:option>
		</c:forEach>
	</aui:select>
	<aui:button-row>
		<aui:button type="submit" value="Add Book" />
	</aui:button-row>
</aui:form>
