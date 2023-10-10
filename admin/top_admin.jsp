<jsp:include page="0_loginbase.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/top.css">    
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
#nav3 {
  height: auto;
 
}
</style>

</head>
<body>
<nav id="nav3">
    <ul class="menu">
        <li>
        	<a href="BoardServlet?command=admin_class_list">강의 승인</a>      
        </li>
        <li>
        	<a href="24_1_studentManage.jsp">학생 상태 관리</a>        
        </li>
        <li>
        	<a href="StudentServlet?command=home">로그아웃</a>
        </li>
    </ul>
</nav>
</body>
</html>