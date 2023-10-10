<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="css/media.css">
    <link rel="stylesheet" href="css/style.css">
    
     <c:if test="${userList != null}">
 	<jsp:include page="top.jsp"/>
 </c:if>
 <c:if test="${userList == null}">
 	<jsp:include page="top_pro.jsp"/>
 </c:if>
 
 	<link rel="stylesheet" href="css/main.css">  
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 	
    <style>
	    #notice{
	    	display:flex;
	    	justify-content:space-between;
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
	    button{
		 	 margin:auto;
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
<br>
    <div class="board_wrap">
        <div class="board_title" align ="center">
            <strong>공지사항</strong>
        </div>
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                </div>
                <c:if test="${userList != null}">
                <c:forEach var="stu" items="${userList}">
                <c:forEach var="board" items="${boardList}">
              	<div onClick="location.href='BoardServlet?command=board_view&NoticeNum=${board.noticeNum }&StudentNum=${stu.studentNum}'" style="cursor:pointer;">
                    <div class="num">${board.noticeNum}</div>
                    <div class="title" align = "center">${board.title }</div>
                    <div class="writer">${board.writer }</div>
                    <div class="date">${board.day }</div>     
                </div>
                </c:forEach>
                </c:forEach>
               </c:if>
               
               <c:if test="${userList == null}">
               <c:forEach var="board" items="${boardList}">
              	<div onClick="location.href='BoardServlet?command=pro_board_view&NoticeNum=${board.noticeNum }'" style="cursor:pointer;">
                    <div class="num">${board.noticeNum}</div>
                    <div class="title" align = "center">${board.title }</div>
                    <div class="writer">${board.writer }</div>
                    <div class="date">${board.day }</div>     
                </div>
                </c:forEach>
               </c:if>
            </div>
            <form>
             <c:if test="${userList == null}">
	            <div class="bt_wrap">
                <a href="BoardServlet?command=board_write_form" class="on">공지사항 등록</a>
            </div>
            </c:if>
            </form>
        </div>
    </div>
</body>
</html> 