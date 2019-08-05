<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="shop"/>
<body>
	<h4 align="center">Books Under Category ${param.category}</h4>
	<form action="add_to_cart.jsp">
		<table style="background-color: cyan; margin: auto;">
			<c:forEach var="bk" items="${sessionScope.shop.books}">
				<tr>
					<td><input type="checkbox" name="bkId" value="${bk.bookId}"></td>
					<td>${bk.title}</td>
					<td>${bk.author}</td>
					<td>${bk.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Add To Cart" /></td>
			</tr>
		</table>
	</form>

</body>
</html>