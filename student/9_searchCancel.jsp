<jsp:include page="top.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css">  

<meta charset="UTF-8">
<title>신청내역 조회 및 취소</title>

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
	   alert("취소 되었습니다.");
   }
   </script>
<br>
 	<div class="board_title" align="center">
            <h2>신청 내역 확인 및 취소</h2>
    </div>
    <br>
 <div class="board_wrap">
<table width = "1275" border = "1">
<tr>
		<th>이 름</th>
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
		<th>비 고</th>
	</tr>
<c:forEach var="stu" items="${userList}">	
		<c:forEach var="classList" items="${classList}">
			<form method = "post" action = "BoardServlet?command=stu_class_cancel&StudentNum=${stu.studentNum}&ClassNum=${classList.classNum }">
				<tr>
					<td>${stu.name}</td>
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
						<input type="submit" value="신청취소" onclick = 'confirm()' />
					</td>
				</tr>
			</form>
		</c:forEach>	
</c:forEach>
</table>
</div>
</body>
</html>