<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pj.dao.StuDAO" %>
<%@ page import="com.pj.dto.StuDTO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="stu" class="com.pj.dto.StuDTO" scope="session"/>
<jsp:setProperty name="stu" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
<%	
	int id = stu.getStudentNum(); 
	StuDTO sTo = new StuDTO();
	String new_pwd = request.getParameter("new_pwd");
	String new_pwd_chk = request.getParameter("new_pwd_chk");
	sTo.setStudentNum(id);
	String pwd = request.getParameter("pwd");
	StuDAO stuDAO = new StuDAO();
	ArrayList<StuDTO> pwd_info = new ArrayList<StuDTO>(stuDAO.check_Pwd(stu.getStudentNum()));
	for(StuDTO mi : pwd_info) {
		
			
		if(!mi.getPwd().equals(pwd)){ 
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('기존 비밀번호가 틀렸습니다.')");
            script.println("history.back()");
            script.println("</script>");
        } else if (pwd == null) { 
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('비밀번호를 입력해주세요.')");
            script.println("</script>");
        } else if (!new_pwd.equals(new_pwd_chk)){ 
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('변경 할 비밀번호가 다릅니다.')");
            script.println("history.back()");
            script.println("</script>");
            //sTo.setPwd(new_pwd);
            //stuDAO.updatePwd(new_pwd,id); 

        } else if (mi.getPwd().equals(pwd)){ 
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('변경되었습니다.')");
            script.println("location.href = '3_1_my_info.jsp'");
            script.println("</script>");
            sTo.setPwd(new_pwd);
            stuDAO.updatePwd(new_pwd,id);
        }

	}
%>


</body>
</html>