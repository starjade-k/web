<jsp:include page="top_pro.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.sql.*, java.sql.*, javax.naming.*" %>
<%@ page import="com.pj.dao.ProDAO" %>
<%@ page import="com.pj.dto.ProDTO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<jsp:useBean id="pro" class="com.pj.dto.ProDTO" scope="session"/>
<jsp:setProperty name="pro" property="*" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css">  
<link rel="stylesheet" href="css/my_info.css"> 
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	  button{
	 	 margin:auto;
	  }
		a {
		  text-decoration: none;
			color:white;
		}
		a.main:hover{
			color:white;
		}	
		a:hover{
		color:black; 
		}
   		h2{
   			font-weight:800;
   			color:white;
   		}
   		 #top_bar, .submenu{
   			transform: translate(-15px, 0);
   		}
   	
    </style>
</head>
<body>
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>교수 정보 변경</h3>
        </div>
    </div>

    <div id="board-list">
        <div class="container">
            <table class="board-table">

                <tbody>
                <tr> 
                <form method = "post" name="edit" action="13_1_my_info_Action.jsp">
                <% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
				ProDAO proDAO = new ProDAO();
				ArrayList<ProDTO> my_info = new ArrayList<ProDTO>(proDAO.my_Info(pro.getProfessorNum()));
				for(ProDTO mi : my_info) { %>
                    <th style="text-align: center"><a>이름 : <%=mi.getName()%></a></th> 

                    <th style="text-align: center"><a>교번 : <%=mi.getProfessorNum()%></a></th>
                                    	
                    <th style="text-align: center"><a>연락처 : <input type = "text" name= "tel"placeholder="연락처를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '연락처를 입력해 주세요.'"></a></th>
                	
                    <th style="text-align: center"><a>학과 : <%=mi.getMajor()%></a></th>
           	    	
                    <th style="text-align: center"><a>E-MAIL : <input type = "text" name= "email" placeholder="이메일을 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일을 입력해 주세요.'"></a></th>
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