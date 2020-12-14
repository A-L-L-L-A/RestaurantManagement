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
<br>
<fmt:message key="client.firstname"/>
<input type="text" class="inputLabel" name="first_name" required>
<fmt:message key="client.lastname"/>
<input type="text" class="inputLabel" name="last_name" required>
<br>
<fmt:message key="client.email"/>
<input type="email" class="inputLabel" name="email" required>
<fmt:message key="client.bill"/>
<input type="number" class="inputLabel" name="bill" required>
<fmt:message key="client.role"/>
<input type="number" class="inputLabel" name="role_id" required>
<br>
<input type="hidden" name=command value="signUp">
<input type="submit" value="OK" class="prettyButton">
</form>
</div>
</body>
<footer>
<a href="Controller?command=basePage"><fmt:message key="label.back"/></a>
</footer>
</html>