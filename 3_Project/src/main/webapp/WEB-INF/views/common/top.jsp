<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1>a{color:black; text-decoration:none;}
	h1>a:active{color: orangered;}
</style>
</head>
<body>
	<c:set var='contextPath' value='${pageContext.servletContext.contextPath }' scope='application'/>
	<%-- ${pageContext.servletContext.contextPath } :el문의 context path 불러오는 코드 --%>
	<h1 align='center'><a href='${ contextPath }'>MyBatis Project</a></h1>
</body>
</html>