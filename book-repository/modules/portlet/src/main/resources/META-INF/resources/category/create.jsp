<%@page import="com.hehehe.servicebuilder.model.Category"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="category/create/save" var="CategoryCreateURL" />

<h1>Category detail:</h1>

<!-- Hiển thị lỗi từ SessionErrors -->
<liferay-ui:error key="required-fields-missing" message="required-fields-missing" />
<liferay-ui:error key="invalid-author-name" message="invalid-category-name" />
<liferay-ui:error key="author-name-length-invalid" message="category-name-length-invalid" />
<liferay-ui:error key="author-name-exists" message="category-name-exists" />

<aui:form name="fm" action="${CategoryCreateURL}">
	<aui:model-context bean="${category}" model="<%= Category.class %>" />
	
	<aui:input name="name" label="Category Name" />

	<aui:button-row>
		<aui:button type="submit" value="Category Author" />
	</aui:button-row>
</aui:form>