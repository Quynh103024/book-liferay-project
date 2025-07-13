<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<liferay-theme:defineObjects />

<liferay-ui:error key="book-id-missing" message="Missing BookId." />
<liferay-ui:error key="permission-denied" message="Permission do not granted." />
<liferay-ui:error key="unexpected-error" message="Unexpected Error." />

<div class="alert alert-danger">
    <strong>Error:</strong> There is an error while processing your request.
</div>

<p>
    <a href="<%= themeDisplay.getURLHome() %>" class="btn btn-primary">Return page</a>
</p>
