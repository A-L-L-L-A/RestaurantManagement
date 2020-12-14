<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="management.i18n.default"/>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<div class="prettyForm">
<form action="Controller" method="POST">
<fmt:message key="client.login"/>
<input type="text" class="inputLabel" name="login" required>
<fmt:message key="client.password"/>
<input type="password" class="inputLabel" name="password" required>
<input type="hidden" name="command" value="signIn">
<input type="submit" value="OK" class="prettyButton">
</form>
</div>
<footer>
<a href="Controller?command=basePage"><fmt:message key="label.back"/></a>
</footer>
</body>
</html>