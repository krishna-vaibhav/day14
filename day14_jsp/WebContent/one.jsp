<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 1st page...</h4>
	<c:set var="dt" value="<%=new Date()%>" scope="request"/>
	<%
	  out.flush();
	%>
	<jsp:include page="two.jsp">
		<jsp:param value="1234" name="nm1" />
	</jsp:include>
	<h4>Back in 1st page...</h4>
</body>
</html>