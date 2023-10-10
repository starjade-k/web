<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pj.dao.StuDAO" %>
<%@ page import="com.pj.dto.StuDTO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="stu" class="com.pj.dto.StuDTO" scope="session"/>
<jsp:setProperty name="stu" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%  
		int id = stu.getStudentNum();
		StuDTO sTo = new StuDTO();
		StuDAO stuDAO = new StuDAO();
		sTo.setTel(request.getParameter("tel"));
		sTo.setEmail(request.getParameter("email"));
		sTo.setStudentNum(id);
		stuDAO.updateMember(sTo); 
		 //session.setAttribute("StudentNum", id);
		response.sendRedirect("3_1_my_info.jsp");
		
	%>
</body>
</html>