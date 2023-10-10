<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pj.dao.ProDAO" %>
<%@ page import="com.pj.dto.ProDTO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="pro" class="com.pj.dto.ProDTO" scope="session"/>
<jsp:setProperty name="pro" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%  
		int id = pro.getProfessorNum();
		ProDTO pTo = new ProDTO();
		ProDAO proDAO = new ProDAO();
		pTo.setTel(request.getParameter("tel"));
		pTo.setEmail(request.getParameter("email"));
		pTo.setProfessorNum(id);
		proDAO.updateMember(pTo); 
		 //session.setAttribute("StudentNum", id);
		response.sendRedirect("13_my_info.jsp");
		
	%>
</body>
</html>