<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--how to import JSTL core tag library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Valid Login</h4>
	<h4 align="center">User Details ${sessionScope.bankUser.validUser}</h4>
	<h4 align="center">
		<c:url var="url" value="logout.jsp" />
		<a href="${url}">Logout</a>
	</h4>
</body>
</html>