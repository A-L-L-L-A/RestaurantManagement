<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="management.i18n.default"/>
<html>
<head>
<meta charset="utf-8">
</head>
<header>
<div class="link">
<a href="Controller?command=changeLang&theLocale=ru_RU"><fmt:message key="label.language"/> ru</a>
<a href="Controller?command=changeLang&theLocale=en_EN"><fmt:message key="label.language"/> en</a>
</div>
</header>
<body>


<c:if test="${curClient == null}">
<div class="link">
<a href="Controller?command=signInPage"><fmt:message key="label.signin"/></a>
<a href="Controller?command=signUpPage"><fmt:message key="label.signup"/></a>
</div>
</c:if>

<c:if test="${curClient.role_id == 0}">
<div class="link">
<a href="Controller?command=clientsManagement"><fmt:message key="label.management"/></a>
</div>
</c:if>


<c:if test="${curClient != null}">
<div class="link">
<a href="Controller?command=exit"><fmt:message key="label.exit"/></a>
</div>
</c:if>

</body>
</html>