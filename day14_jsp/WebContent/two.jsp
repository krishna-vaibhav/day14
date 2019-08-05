<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 2nd page...</h4>
	<h4>Hello , ${param.nm}</h4>
	<h4>Value : ${requestScope.nm1}</h4>
	<h4>Date : ${requestScope.dt}</h4>
	<h4>Name 1 ${param.nm1}</h4>
</body>
</html>