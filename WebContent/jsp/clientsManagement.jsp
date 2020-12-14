<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="management.i18n.default"/>


<html>
<body>
<fmt:message key="label.management"/>
<br>

<c:forEach var="temp" items="${clientList}">
	
	<a href="Controller?command=clientInfo&login=${temp.login}&password=${temp.password}">${temp.login}</a>
	<br>
	
</c:forEach>

</body>
</html>