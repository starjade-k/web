<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<script language="JavaScript">
function selectAll01(selectAll)  {
	  const checkboxes 
	       = document.getElementsByName('RA');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked;
	  })
	} 

</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container {
		display: flex;
 		justify-content: center;
 		height : 400px;
 	}
 	#classProfessor {
		border-style : solid;
		border-width: 2px;
		border-color: #ccc;
		width : 700px;
		margin-right : 25px;
		margin-top : 15px;
		padding: 15px;
	} 
	table {
		border-collapse: collapse;
		max-height: 320px;
  		overflow-y: scroll;
  		display: block;
		
	}
	th, td {
     padding: 10px;
     border-bottom: 1px solid #CCC;
	}
	tr:hover { background-color: #F5F5F5; }
	#selectAll { 
		margin-top : 15px;
	}
	h3 {
		margin-top: 20px;
		margin-bottom: 20px
	}
</style>
</head>
<body>
<jsp:include page="top_admin.jsp"></jsp:include>
<h3 style = "text-align : center">관리자 - 강의승인</h3>
<hr>
<form action = "BoardServlet" method ="post">
<input type="hidden" name="command" value="admin_confirm">

<div id="container">

	<div id="classProfessor">
	<table>
		<tr>
			<th>강의명</th>
			<th>강의계획안 링크</th>
			<th>학과명</th>
			<th>강의실</th>
			<th>학점</th>
			<th>신청자</th>
			<th>승인</th>	
		</tr>
		
		
		<c:forEach var="admin" items="${classList }">
		<tr>
		
			<td>
				${admin.className }
				<input type="hidden" name="ClassNum" value="${admin.classNum }">
				
			</td>
			<td><button type="button" onclick ="window.open('BoardServlet?command=admin_select_plan&ClassNum=${admin.classNum }','강의계획서','width=1200,height=1000')">강의계획서</button></td>
			<td>${admin.major }</td>
			<td>${admin.classroom }</td>
			<td>${admin.credit }</td> 
			<td>${admin.professorName }</td>
			<c:if test="${admin.confirm  == 'true'}">
				<td>
					
					<input type="checkbox" name="RA" value="${admin.classNum }" checked>
				</td>
			</c:if>
			<c:if test="${admin.confirm  == 'false'}">
				<td>
					<input type="checkbox" name="RA" value="${admin.classNum }">
				</td>
			</c:if>
		</tr>
		</c:forEach>
		
	</table>
			<input type='checkbox' name = "RA_all"  id = "selectAll" value = "selectAll" onclick='selectAll01(this)'>모두선택/해제
			<input type="submit" value ="승인하기">	
	</div>
</div>

</form>

</body>
</html>