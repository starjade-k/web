<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

    
<!DOCTYPE html>
<html>

<script type="text/javascript">
<!-- 
	function clickOnlyOne(itself){
		const checkboxes = document.getElementsByName("state");
		checkboxes.forEach((checkbox) =>{
			checkbox.checked =false;
		})
		itself.checked = true;
	} 
	-->
</script>
 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3 {
		margin-top: 20px;
	}
	ul {
		margin: 0;
		padding: 0;
	}
	ul li{
		list-style: none;
	} 
	a {
		text-decoration: none;
		color:#333;
	}
	#department {
		font:bold 16px "malgun gothic";
		width:700px;
		height:50px;
		background: #ccc;
		color:black;
		line-height: 50px; 
		margin:0 auto;
		text-align: center;
		margin-top : 20px;
		margin-bottom : 20px;
	}
	#department > ul > li {
		float:left;
		width:140px;
		position:relative;
	}
	#department > ul > li > ul {
		width:130px;
		display:none;
		position: absolute;
		font-size:14px;
		background: skyblue;
	}
	#department > ul > li:hover > ul {
		display:block;
	}
	#department > ul > li > ul > li:hover {
		background: orange;
		transition: ease 1s;
		}
	#className, #classMember {
		display : inline-block;
		
	}
	#container {
		display: flex;
 		justify-content: center;
 		height : 400px;
 		
	}
	#container_1{
 		
		border-style : solid;
		border-width: 2px;
		border-color: #ccc;
		width : 700px;
		margin-top : 15px;
		padding: 15px;
		text-align : center;
	} 
	
	table {
		border-collapse: collapse;
		max-height: 320px;
  		overflow-y: scroll;
  		display: block;
	}
	th, td {
     padding: 20px;
     border-bottom: 1px solid #CCC;
	}
	tr:hover { background-color: #F5F5F5; }
	
	.submit{
	position:absolute;
	top:700px
	}

</style>

</head>
<body>
<!-- 웹 페이지 -->
<jsp:include page="top_admin.jsp"></jsp:include>
<h3 style = "text-align : center">관리자 - 학생 상태 관리</h3>


<form action = "BoardServlet" method ="post">
<input type="hidden" name="command" value="update_stu_state">
<div id = "department">
	<ul>
		<li><a href = "#">공과대학</a>
			<ul>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=1">컴퓨터공학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=2">화학공학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=3">생명공학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=4">신소재공학과</a></li>
			</ul>
		</li>	
		<li><a href = "#">자연과학대학</a>
			<ul>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=5">수학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=6">천문학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=7">통계학과</a></li>
			</ul>
		</li>	
		<li><a href = "#">문과대학</a>
			<ul>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=8">국어국문학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=9">영문학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=10">독어독문학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=11">철학과</a></li>
			</ul>
		</li>	
		<li><a href = "#">정경대학</a>
			<ul>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=12">경영학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=13">경제학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=14">정치외교학과</a></li>
				<li><a href="BoardServlet?command=admin_stu_list&MajorNum=15">행정학과</a></li>
			</ul>
		</li>	
	</ul>
</div>
<hr>
<div id="container">
<div id="container_1">
<div>

		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학년</th>
				<th>재학</th>
				<th>휴학</th>
				<th>자퇴</th>
				<th>졸업</th>
			</tr>
				
			<c:forEach var="stu" items="${stuList }">
			<tr>
				
				<td>${stu.studentNum }</td>
				<td>${stu.name }</td>
				<td>${stu.grade }</td>
				<!-- 라디오 그룹 활용해서 한번 고쳐보기 -->
				
				<c:if test="${stu.in  eq '재학'}">
					
				<input type="hidden" name="StudentNum" value="${stu.studentNum }">
				<td><input type="checkbox" name="state"  id="state" value="재학" checked="checked" ></td>			
				<td><input type="checkbox" name="state"  id="state"  value="휴학" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="자퇴" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="졸업" ></td>
				</c:if>
	
				<c:if test="${stu.in  eq '휴학'}">	
				<input type="hidden" name="StudentNum" value="${stu.studentNum }">
				<td><input type="checkbox" name="state"  id="state" value="재학" ></td>			
				<td><input type="checkbox" name="state"  id="state"  value="휴학" checked="checked" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="자퇴" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="졸업" ></td>
				</c:if>
		
				<c:if test="${stu.in  eq '자퇴'}">	
				<input type="hidden" name="StudentNum" value="${stu.studentNum }">
				<td><input type="checkbox" name="state"  id="state"  value="재학" ></td>			
				<td><input type="checkbox" name="state"  id="state"  value="휴학" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="자퇴" checked="checked" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="졸업" ></td>
				</c:if>
			
				<c:if test="${stu.in  eq '졸업'}">	
				<input type="hidden" name="StudentNum" value="${stu.studentNum }">
				<td><input type="checkbox" name="state"  id="state"  value="재학"></td>			
				<td><input type="checkbox" name="state"  id="state"  value="휴학" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="자퇴" ></td>
				<td><input type="checkbox" name="state"  id="state"  value="졸업" checked="checked" ></td>
				</c:if>
			</tr>
			
			</c:forEach>
			
			
		</table>
					
		
	
</div>

<input type="submit" value="변경" class="submit">
</div>

</div>
</form>

</body>
</html>