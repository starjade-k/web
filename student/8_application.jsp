<jsp:include page="top.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css">  

<meta charset="UTF-8">
<title>수강 신청</title>
     <style>
   	.board_wrap{
   		display:flex;
   		justify-content:center; 
   	}
   </style>
</head>
<body>
<script>
   function confirm(){
	   alert("신청 되었습니다.");
   }
   
</script>
<br>
	<div class="board_title" align="center">
        <h2>수강신청</h2>
    </div>
 <div class="board_wrap">
<c:forEach var="stu" items="${userList}">        
	<form method = "post" action = "BoardServlet?command=search_class&StudentNum=${stu.studentNum}">
</c:forEach>
	<table width = "1263" border = "1" align = "center">
		<caption>강 의 목 록 </caption>
		<fieldset>
		<legend> 검색 정보</legend>
	   		<strong>구분</strong>
	   		<select name = "select">
	   		<option value ="전체">전체
	   		<option value ="전공">전공
	   		<option value ="교양">교양
	   		</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	   		<strong>학과</strong>
	   		<select name = "major">
	   		<option value ="전체">전체
	   		<option value = "컴퓨터공학과">컴퓨터공학
	   		<option value = "화학공학과">화학공학
	   		<option value = "생명공학과">생명공학
	   		</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	   		<strong>강의명 검색</strong>
	   		<input type = "text" name ="search" placeholder="강의명으로 검색">	
	   		<input type="submit" value="검색"><br>
	 	</fieldset>
	</form>
	<tr>
		<th>번 호</th>
		<th>교 시</th>
		<th>강의명</th>
		<th>교 수</th>
		<th>전 공</th>
		<th>구 분</th>
		<th>호 수 </th>
		<th>강의 계획</th>
		<th>학 점</th>
		<th>정 원</th>
		<th>신 청</th>
	</tr>
<c:forEach var="stu" items="${userList}">

		<c:forEach var="classList" items="${classList}">
		<form method = "post" action="BoardServlet?command=stu_add_class&StudentNum=${stu.studentNum}&ClassNum=${classList.classNum }">
			<tr>
				<td>${classList.classNum}</td>
				<td>${classList.time}</td>
				<td>${classList.className}</td>
				<td>${classList.professorName}</td>
				<td>${classList.major}</td>
				<td>${classList.liberal}</td>
				<td>${classList.classroom}</td>
				<td><button type="button" onclick ="window.open('BoardServlet?command=admin_select_plan&ClassNum=${classList.classNum }','강의계획서','width=1200,height=1000')">강의계획서</button></td>
				<td>${classList.credit}</td>
				<td>${classList.max}</td>
				<td>
					<input type="submit" value="신청" onclick = 'confirm()' />
				</td>
			</tr>
		</form>	
		</c:forEach>
>
</c:forEach>
</table>
</div>
</body>
</html>