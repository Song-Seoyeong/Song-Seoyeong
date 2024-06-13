<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#boardDiv{margin-left: 150px; margin-right: 150px; margin-top: 150px; min-height:350px; border: 1px solid black; padding: 30px;}
	#boardDiv>table{width: 100%; text-align: center; height: 100%;}
	th{border-bottom: 1px solid black;}
	#writeLabel{float: right;}
	#writeLabel:hover{font-weight: bold; text-decoration: underline;}
	
	.pagingArea *{margin: 0 10px;}
	.pagingArea a{color: black; text-decoration: none;}
	.pagingArea a:hover{font-weight: bold; text-decoration: underline;}
	.disable{color: lightgray;}
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<jsp:include page="../common/loginbar.jsp"/>
	<div id="boardDiv">
		<label id="writeLabel">[ 글쓰기 ]</label>
		<br><br><br>
		<table>
			<tr>
				<th width="5%"></th>
				<th width="10%">글번호</th>
				<th width="40%">글제목</th>
				<th width="18%">작성자</th>
				<th width="17%">작성일</th>
				<th width="10%">조회수</th>
			</tr>
			<tr>
				<td colspan="6">조회된 리스트가 없습니다.</td>
			</tr>
		</table>
	</div>
</body>
</html>