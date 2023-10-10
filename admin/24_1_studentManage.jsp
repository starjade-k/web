<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3 {
		margin-top: 20px;
	}
/* 메뉴영역에서 여백을 없애줌 */
	ul {
		margin: 0;
		padding: 0;
	}
/* ul li태그에 리스트 스타일을 없앰 */
	ul li{
		list-style: none;
	}
/* a태그에 텍스트 밑줄을 없애고 색상을 #333 */
	a {
		text-decoration: none;
		color:#333;
	}
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 700, 높이 50만큼 배경색은 #ccc, 글자색은 검정색, 라인높이50px
menu박스 가운데정렬, 글자가운데 정렬 */
	#department {
		font:bold 16px "malgun gothic";
		width:700px;
		height:50px;
		background: #ccc;
		color:black;
		line-height: 50px; 
		margin:0 auto;
		text-align: center;
		margin-top: 20px;
		margin-bottom: 20px;
	}

/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
	#department > ul > li {
		float:left;
		width:140px;
		position:relative;
	}
/*하위 메뉴를 감춰보겠 */
	#department > ul > li > ul {
		width:130px;
		display:none;
		position: absolute;
		font-size:14px;
		background: skyblue;
	}
/*마우스를 올릴 시 하위 메뉴가 보이도록*/
	#department > ul > li:hover > ul {
		display:block;
	}
	#department > ul > li > ul > li:hover {
		background: orange;
		transition: ease 1s;
		}
</style>
</head>
<body>
<!-- 웹 페이지 -->
<jsp:include page="top_admin.jsp"></jsp:include>
<h3 style = "text-align : center">관리자 - 학생 상태 관리</h3>


<form action = "studentManage_pro.jsp" method ="post">
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



</form>
</body>
</html>