
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>

 <c:if test="${userList != null}">
 	<jsp:include page="top.jsp"/>
 </c:if>
 <c:if test="${userList == null}">
 	<jsp:include page="top_pro.jsp"/>
 </c:if>
 
 	<link rel="stylesheet" href="css/main.css">  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 
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
   		
    </style>
    <script type="text/javascript">
    if (window.name == 'delete') {
    	alert('삭제되었습니다.');
    	window.opener.parent.location.href = "BoardServlet?command=board_delete&num=${param.num}";
    	}
    </script>
</head>
<body>
 <div class="board_wrap">
        <div class="board_title">
            <strong>공지사항</strong>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                   ${board.title }
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>${board.noticeNum }</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>${board.writer }</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>${board.day }</dd>
                    </dl>
                </div>
                <div class="cont">
                  ${fn:replace(board.content,replaceChar,"<br/>")}
                </div>
            </div>
    
            <div class="bt_wrap">
                <a href="javascript:window.history.back();" class="on">목록</a>
            <c:if test="${userList == null}">
         <a href="BoardServlet?command=board_update_form&NoticeNum=${board.noticeNum}">수정</a>
        <a href="BoardServlet?command=board_delete&NoticeNum=${board.noticeNum}">삭제</a>
           </c:if>
               
            </div>
        </div>
		
    </div>
</body>
</html>