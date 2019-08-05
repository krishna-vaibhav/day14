<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="sample-uri" prefix="test" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Hello , user name --%>
	<h4>Hello, ${sessionScope.shop.validCust.name}</h4>
	<h3>Cart Contents</h3>
	<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
		<c:forEach var="b" items="${sessionScope.shop.fetchCartDetails()}">
			<tr>
				<td>${b.title}</td>
				<td>${b.author}</td>
				<td>${b.price}</td>
			</tr>
		</c:forEach>
	</table>
	<h4>Total Value : ${sessionScope.shop.total}</h4>

	<h4>You have logged out successfully....</h4>
	<%--discard user's session --%>
	<%-- ${pageContext.session.invalidate()} --%>
	<test:logout/>
	<h4>
		<a href="index.jsp">Visit Again</a>
	</h4>
</body>
</html>






