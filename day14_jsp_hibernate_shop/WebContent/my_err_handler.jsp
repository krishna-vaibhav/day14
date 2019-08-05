<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
		Exception Details
		<%=exception%></h4>
	<h4>
		Error Mesg
		<%=exception.getMessage()%></h4>
	<%--pageContext.getErrorData().getRequestURI() --%>
	<h4>Error causing Page : ${pageContext.errorData.requestURI}</h4>
	<%-- pageContext.getErrorData().getStatusCode() --%>
<h4>Status Code : ${pageContext.errorData.statusCode}</h4>
<h4>Error Mesg Via EL Syntax : ${pageContext.exception.message}</h4>
</body>
</html>



