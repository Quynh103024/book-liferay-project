<%@page import="com.hehehe.servicebuilder.model.Category"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="category/update/save" var="CategoryUpdateURL" />
<h1>Category details:</h1>
<aui:form name="fm" action="${CategoryUpdateURL}">
	<aui:input name="categoryId" type="hidden" value="${category.getCategoryId()}"></aui:input>
 <aui:input name="name" value="${category.getName()}">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button-row>
			<aui:button type="submit" value="Update category" />
		</aui:button-row>
</aui:form>
