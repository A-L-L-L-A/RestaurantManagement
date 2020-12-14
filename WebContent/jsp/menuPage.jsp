<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html;charset=utf-8"%>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="management.i18n.default"/>


<html>
<body>
<fmt:message key="label.management"/>
<br>
Ordered : ${orderedDishes.size()}
<c:forEach var="temp" items="${dishList}">
	
	<form class="prettyForm">
	<fmt:message key="order.name"/>: ${temp.dish_name} <br>
	<fmt:message key="order.nomination"/>${temp.nomination}   <fmt:message key="order.price"/>${temp.price}
	<input type="hidden" name="command" value="addToCart">
	<input type="hidden" name="dish_id" value="${temp.id}">
	<input type="hidden" name="dish_name" value="${temp.dish_name}"> 
	<input type="submit" value="${order.add}">
	</form>
	
</c:forEach>

</body>
</html>