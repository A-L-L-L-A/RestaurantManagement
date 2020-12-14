<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="management.i18n.default"/>



<html>

<body>

<div class="prettyForm">
<form action="Controller" method="POST">
<fmt:message key="client.login"/>
<input type="text" class="inputLabel" value="${lookableClient.login}" name="login" required>
<fmt:message key="client.password"/>
<input type="password" class="inputLabel" value="${lookableClient.password}" name="password" required>
<br>
<fmt:message key="client.firstname"/>
<input type="text" class="inputLabel" value="${lookableClient.first_name}" name="first_name" required>
<fmt:message key="client.lastname"/>
<input type="text" class="inputLabel" value="${lookableClient.last_name}" name="last_name" required>
<br>
<fmt:message key="client.email"/>
<input type="email" class="inputLabel" value="${lookableClient.email}" name="email" required>
<fmt:message key="client.role"/>
<input type="number" class="inputLabel" value="${lookableClient.role_id}" name="role_id" required>
<br>
<input type="number" class="inputLabel" value="${lookableClient.bill}" name="bill" required>
<br>
<input type="hidden" name="command" value="updateClient">
<input type="hidden" name="lookableId" value="${lookableClient.id}">
<input type="submit" value="OK" class="prettyButton">
</form>
</div>
<div class="prettyForm">
<form action="Controller" method="POST">
<input type="hidden" name="command" value="deleteClient">
<input type="hidden" name="lookableId" value="${lookableClient.id}">
<input type="hidden" name="login" value="${lookableClient.login}">
<input type="submit" value="Delete" class="prettyButton">
</form>
</div>

</body>

<footer>
<a href="Controller?command=basePage"><fmt:message key="label.back"/></a>
</footer>

</html>