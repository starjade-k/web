<jsp:include page="0_base.jsp"/>
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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/mypage.css">   
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
		StuDAO stuDAO = new StuDAO();
		ArrayList<StuDTO> user_info = new ArrayList<StuDTO>(stuDAO.top_Info(stu.getStudentNum()));
		%>
	<nav id="nav3">
	    <ul class="menu">
	    <%for(StuDTO ui : user_info) { %>
	    	<li><a href="#" style ="text-align: left; color: gray;"><%=ui.getName()%>님 환영합니다.</a>
	            <ul class="submenu" style ="text-align: left; color: gray;">
	                <li><a>이름 :<%=ui.getName()%></a></li>
	                <li><a>학번 :<%=ui.getStudentNum()%></a></li>
	                <li><a>학년 :<%=ui.getGrade()%></a></li>
	                <li><a>전공 :<%=ui.getMajorNum()%></a></li>
	                
	               
            </ul>
        </li>
        <li>
      	  	<a href="BoardServlet?command=main&studentNum=<%=ui.getStudentNum()%>">홈으로</a>
        </li>
         <%} 
	                %>
        <li><a href="3_1_my_info.jsp">내 정보 조회</a>
            <ul class="submenu">
                <li><a href="3_1_my_info_update.jsp">내 정보 변경</a></li>
                <li><a href="3_2_pwd.jsp">비밀번호 변경</a></li>
            </ul>
        </li>
       
        
    </ul>
</nav>
</body>
</html>