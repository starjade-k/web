<jsp:include page="0_loginbase.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@ page import="javax.sql.*, java.sql.*, javax.naming.*" %>
<%@ page import="com.pj.dao.ProDAO" %>
<%@ page import="com.pj.dto.ProDTO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<jsp:useBean id="pro" class="com.pj.dto.ProDTO" scope="session"/>
<jsp:setProperty name="pro" property="*" />
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
#myClass{
	border:none;
	background: transparent;
}
#nav > ul > li{
    	text-align:left;
    } 
</style>

</head>
<body>
<% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
ProDAO stuDAO = new ProDAO();
		ArrayList<ProDTO> user_info = new ArrayList<ProDTO>(stuDAO.my_Info(pro.getProfessorNum()));
		%>
<nav id="nav3">
    <ul class="menu">
   		<li>
        	<a href="13_my_info.jsp">교수 정보</a>     
        	<ul class="submenu">
                <li><a href="13_1_my_info_update.jsp">교수 정보 변경</a></li>
                <li><a href="13_2_pwd.jsp">비밀번호 변경</a></li>
               	
            </ul>   
        </li>
        <li>
        	<a href="BoardServlet?command=add_class">강의등록</a>      
        </li>
        <li>
        	<a>
        	
        	<form action="BoardServlet" method="post" name="myClass">
        	<%for(ProDTO ui : user_info) { %>
        	<input type="hidden" name="command" value="class_list">
        	<input type="hidden" id="professorNum" name="professorNum" value="<%=ui.getProfessorNum()%>">
        	<input type="hidden" id="majorNum" name="majorNum" value="<%=ui.getMajorNum()%>">
        	
        	
        	<%}
        	%>
        	<a href="javascript:myClass.submit();" >내 강의조회</a>
        	
        	</form>
        	</a>         
        </li>
        <li>
        	<a href="BoardServlet?command=all_qna_list">문의내역</a>   
        	<ul class="submenu">
                <li><a href="BoardServlet?command=pro_board_list">공지사항</a></li>
            </ul>     
        </li>
        <li>
        	<a href="StudentServlet?command=home">로그아웃</a>
        </li>
    </ul>
</nav>
</body>
</html>