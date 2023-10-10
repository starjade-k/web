<jsp:include page="top_mypage.jsp"/>
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
<link rel="stylesheet" href="css/my_info.css"> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="notice"> 
  <div class="page-title">
        <div class="container">
            <h3>내 정보 변경</h3>
        </div>
    </div>

    <div id="board-list">
        <div class="container">
            <table class="board-table">

                <tbody>
                <tr> 
                <form method = "post" name="edit" action="3_1_my_info_Action.jsp">
                <input type="hidden" name="command" value="employees_update"> 
                <% //StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
		StuDAO stuDAO = new StuDAO();
		ArrayList<StuDTO> my_info = new ArrayList<StuDTO>(stuDAO.my_Info(stu.getStudentNum()));
		for(StuDTO mi : my_info) { %>
                    <th style="text-align: center;"><a>이름 : <%=mi.getName()%></a></th> 

                    <th style="text-align: center;"><a>학번 : <%=mi.getStudentNum()%></a></th>
                	
                    <th style="text-align: center;"><a>연락처 : <input type = "text" name= "tel" class ="tel"placeholder="연락처를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '연락처를 입력해 주세요.'"></a></th>
                	
                    <th style="text-align: center;"><a>학과 : <%=mi.getMajor()%></a></th>
           	    	
                    <th style="text-align: center;"><a>E-MAIL : <input type = "text" name= "email"class = "email" placeholder="이메일을 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일을 입력해 주세요.'"></a></th>
                    <th> <input type="submit" class="d" name = "update" value = "변경하기" style="margin-left:90px; font-size: 17px;" ></th>
                    <%} 
	                %>
	               
                </form>
                </tr>
                </tbody>

            </table>
            
        </div>
    </div>

</section>

</body>
</html>