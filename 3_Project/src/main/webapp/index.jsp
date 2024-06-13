<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='WEB-INF/views/common/top.jsp' %>
	<jsp:include page="WEB-INF/views/common/loginbar.jsp"></jsp:include>
	
	<c:if test='${ !empty loginUser && loginUser.isAdmin == "Y" }'>
		<c:redirect url='admin.me'/> <%-- sendRedirect --%>
	</c:if>
</body>
</html>