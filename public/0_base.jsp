<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.pj.dao.StuDAO" %>
<%@ page import="com.pj.dto.StuDTO" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<jsp:useBean id="stu" class="com.pj.dto.StuDTO" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/base.css">
    <style>
    	a{
    		color:white;
    	}
    	
    </style>
</head>
<body>
<% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
		StuDAO stuDAO = new StuDAO();
		ArrayList<StuDTO> user_info = new ArrayList<StuDTO>(stuDAO.top_Info(stu.getStudentNum()));
		%>
<div class="top-bar">
    <div class="top-img">
        <img src="img/test_logo1.png" alt="로고" />
    </div>
    <%for(StuDTO ui : user_info) { %>
    <div class="top-text">
        <h2><a class="main" href="BoardServlet?command=main&studentNum=<%=ui.getStudentNum()%>"">수강신청</a></h2>
    </div>
    <%} %>
</div>

</body>
</html>