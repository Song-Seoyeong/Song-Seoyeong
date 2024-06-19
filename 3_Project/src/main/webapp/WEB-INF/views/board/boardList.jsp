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
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test='${ !empty list }'>
				<c:forEach items="${ list }" var='b'>
					<tr>
						<td>${b.isNotice == 'N' ? "" :'[공지]' }</td>
						<td>${ b.boardNo }</td>
						<td>${ b.title }</td>
						<td>${ b.writer }</td>
						<td>${ b.updateDate }</td>
						<td>${ b.count }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		
		<br><br><br>
		<div class='pagingArea' align='center'>
			<!-- 이전 -->
			<c:if test="${ pi.currentPage <=1 }">
				<span class="disable">[이전]</span>
			</c:if>
			<c:if test="${ pi.currentPage >1 }">
				<c:url value='${ loc }' var="bListBack"> <!--  loc = g현재 contextPath.url-->
					<c:param name="page" value="${ pi.currentPage - 1 }"/>
					<c:if test='${ condition != null }'>
						<c:param name='condition' value='${codition}'/>
						<c:param name='value' value='${value}'/>
					</c:if>
				</c:url>
				<a href='${ contextPath }/list.bo?page=${ pi.currentPage - 1}'>[이전]</a>
			</c:if>
			
			<!-- 숫자 -->
			<c:forEach begin="${ pi.startPage }" end="${ pi.endPage }" var='p'>
				<c:if test="${ p eq pi.currentPage }">
					<font color='red' size='4'><b>[${ p }]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url value="${ loc }" var="bListNum">
						<c:param name='page' value="${ p }"/>
						<c:if test='${ condition != null }'>
							<c:param name='condition' value='${codition}'/>
							<c:param name='value' value='${value}'/>
						</c:if>
					</c:url>
					<a href='${ bListNum }'>${ p }</a>
				</c:if>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				<span class="disable">[다음]</span>
			</c:if>
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url value="${ loc }" var='bListGo'>
					<c:param name="page" value='${ pi.currentPage + 1 }'/>
					<c:if test='${ condition != null }'>
						<c:param name='condition' value='${codition}'/>
						<c:param name='value' value='${value}'/>
					</c:if>
				</c:url>
				<a href="${ contextPath }/list.bo?page=${ pi.currentPage + 1}">[다음]</a>
			</c:if>
		</div>
	</div>
	<br>
	
	<div id='searchArea' align='center'>
		<label>검색 조건</label>
		<select>
			<option value='-'>--------</option>
			<option value='writer'>작성자</option>
			<option value='title'>제목</option>
			<option value='content'>내용</option>
		</select>
		<input type='search'/>
		<button>검색하기</button>
	</div>
	<br><br><br><br>
	<script>
		window.onload = () =>{
			document.getElementById('searchArea').querySelector('button').addEventListener('click', function(){
				const value = this.previousElementSibling.value;
				// 				버튼/버튼 이전의 input 영역의 /값
				const condition = this.previousElementSibling.previousElementSibling.value;
				//					버튼/버튼이전의input영역의	/이전의 select의			/값
				
				location.href='${ contextPath }/search.bo?value=' + value + '&condition=' + condition;
				console.log(value + condition);
			});
			
			const tds = document.querySelectorAll('td');
			for(const td of tds){
				const parent = td.parentElement;
				td.addEventListener('mouseenter', ()=>{
					parent.style.background = 'pink';
					parent.style.cursor = 'pointer';
				})
				td.addEventListener('mouseout', ()=>{
					parent.style.background = 'white';
				})
				td.addEventListener('click', ()=>{
					const boardNo = parent.children[1].innerText;
					location.href = '${contextPath}/selectBoard.bo?bId=' + boardNo;
				})
			}
			
			document.getElementById('writeLabel').addEventListener('click', ()=>{
				console.log('${loginUser}');
				if(${loginUser} == null){
					
					alret("로그인 후 이용하세요")
				}else{
					location.href = '${ contextPath }/insertBoardView.bo';
				}
			})
			
			
			
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		};
	</script>
</body>
</html>