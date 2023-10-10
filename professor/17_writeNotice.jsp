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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<jsp:include page="top_pro.jsp"/>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="css/media.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
    #notice{ 
    	display:flex;
    	justify-content:space-between;
    }
     #top_bar, .submenu{
   			transform: translate(-15px, 0);
   		}
   		#nav3 > ul > li {
	  font-size: 22px;
	  padding: 0;
	  flex: 1;
	  text-align: left;
	  margin-right: 20px;
	}
    h2{
   			font-weight:800;
   			color:white;
   		}
    </style>
    <script>
    function boardCheck() {
    	if (document.frm.name.value.length == 0) {
    		alert("작성자를 입력하세요.");
    		return false;
    	}
    	if (document.frm.title.value.length == 0) {
    		alert("제목을 입력하세요.");
    		return false;
    	}
    	return true;
    }
    function open_win(url, name) {
    	window.open(url, name, "width=500, height=230");
    }

    	return true;
    }
    </script>
</head>

<body>
<% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
ProDAO stuDAO = new ProDAO();
		ArrayList<ProDTO> user_info = new ArrayList<ProDTO>(stuDAO.my_Info(pro.getProfessorNum()));
		%>
	<div id="wrap" align="center">
		<h1>공지사항 등록</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_write">
					<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" size="12" name="writer"> * 필수</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title">  * 필수</td>
				</tr>
				<tr>
					<td><input type = "hidden" name = "type" value ="공지"></td>
				</tr>
				<%for(ProDTO ui : user_info) { %>
				<tr>
					<td><input type = "hidden" name = "ProfessorNum" value ="<%=ui.getProfessorNum()%>"></td>
				</tr>
				<%} %>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br>
			<br> 
			<div class="bt_wrap">
			<a href="javascript:frm.submit();"  class="on" onclick="return boardCheck()" >등록</a>
			 <a href="BoardServlet?command=pro_board_list" onclick="return boardCheck()" >목록</a>
			</div>
		</form>
	</div>
</body>
</html>