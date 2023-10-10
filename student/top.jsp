<jsp:include page="0_base.jsp"/>
<%@page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.sql.*, java.sql.*, javax.naming.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.pj.dao.StuDAO" %>
<%@ page import="com.pj.dto.StuDTO" %>
<jsp:useBean id="stu" class="com.pj.dto.StuDTO" scope="session"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">    
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

</head>
<body>
	<nav id="nav3">
	    <ul class="menu">
	    <c:forEach var="student" items="${userList}">
	    	<li><a href="#" style ="text-align: left; color: gray;">${student.name}님 환영합니다.</a>
	            <ul class="submenu" style ="text-align: left; color: gray;">
	                <li><a>이름 :${student.name}</a></li>
	                <li><a>학번 :${student.studentNum}</a></li>
	                <li><a>학년 :${student.grade}</a></li>
	                <li><a>전공 :${student.major}</a></li>
	                </ul>
	        </li>
	             	               
	            

        <li><a href="BoardServlet?command=main&studentNum=${student.studentNum}">홈으로</a></li>
        </c:forEach> 
        <li><a href="3_1_my_info.jsp">마이페이지</a>
            <ul class="submenu">
                <li><a href="3_1_my_info.jsp">내 정보 조회</a></li>
            </ul>
        </li>
        <c:forEach var="student" items="${userList}">
        <li><a href="BoardServlet?command=class_registration&StudentNum=${student.studentNum}">수강신청</a>
            <ul class="submenu">
                <li><a href="BoardServlet?command=class_notice&StudentNum=${student.studentNum}">수강신청 안내</a></li>
                <li><a href="BoardServlet?command=class_regiList&StudentNum=${student.studentNum}">신청내역</a></li>
            </ul>
        </li>
        
        <li><a href="BoardServlet?command=qna_list&StudentNum=${student.studentNum}">문의</a>
        	    
        
            <ul class="submenu">
                <li><a href="BoardServlet?command=qna_list&StudentNum=${student.studentNum}">문의내역</a></li>
                <li><a href="BoardServlet?command=board_list&StudentNum=${student.studentNum}">공지사항
                	
                </a></li>
                
            </ul>
            </c:forEach>
        </li>
        <li>
        	<a href="StudentServlet?command=home">로그아웃</a>
        </li>
    </ul>
</nav>

</body>
</html>