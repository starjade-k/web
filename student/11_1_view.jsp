
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	  		<jsp:include page="top.jsp"/>
	
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>고객센터</title>
	<link rel="stylesheet" href="css/main.css">  
	
	<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" type="text/css" />
	
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
	<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
	

  <script type="text/javascript">
	
	
	function moveAction(where){
	  switch (where) {
	case 1:
	if(confirm("글을 삭제하시겠습니까?")){
		location.href ="#";
	}
	break;

	case 2:
	if(confirm("글을 수정하시겠습니까?")){
		location.href = "#";
	}
	break;

	  }
	 
	  }
	</script>
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    

    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Brush+Script&display=swap" rel="stylesheet">


<meta name="theme-color" content="#7952b3">   
<style>
		a {
		  text-decoration: none;
			color:white;
		}
		a:hover{
			color:white;
		}
   		h2{
   			font-weight:800;
   			color:white;
   		}
   		#top_bar, .submenu{
   			transform: translate(-30px, 0);
   		}
    </style>
  </head>
  <body>
 
  
  
  
<div class="container">

   <main span style="font-family: 'Gowun Dodum' !important;">
  <div class="py-5 text-center">
      <h2>고객센터</h2>
    </div>
  <ul class="nav nav-tabs">
  <c:forEach var="student" items="${userList}">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="BoardServlet?command=qna_list&StudentNum=${student.studentNum}">문의 내역</a>
  </li>
  		
  <li class="nav-item">
  
     <c:if test="${student.studentNum ne null}">
	 <input type="button" class="nav-link active" value="문의 내용" />
	     <li>
	     	<a class="nav-link " href="BoardServlet?command=add_qna&StudentNum=${student.studentNum }">문의하기</a>
	     </li>
     </c:if>
     <c:if test="${student.studentNum eq null}">
     	 <li>
	        <a class="nav-link" href="#">문의 내역</a>
	  	 </li>
	     <li>
	        <a class="nav-link active" href="#">답변하기</a>
	  	 </li>
	 </c:if>
  	</c:forEach>
</ul>
   


<table border="0" class="table">
<tr>
</tr>
<tr>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
</tr>
<tr>
<td>${qna.title }</td>
<td>${qna.writer }</td>
<td>${qna.day }</td>
</tr>
<tr>
      <th colspan="4">내용</th>
</tr>


<tr>
<td colspan="4" align="left"><p>${qna.content }</p><br/><br />
</td>
</tr>
</table>
<table border="0" class="table">

<tr>

<th>답변 작성일</th>
<td>${qna.answerday }</td>
<th>답변자</th>
<td>${qna.answerer }</td>

</tr>



<td colspan="4" align="left"><p>${qna.answer }</p><br/><br/>

</table>

<br/>


<br>

<c:forEach var="student" items="${userList}">
    <c:if test="${student.studentNum eq null}">
		<tr>
			<td class="writer"><strong>답변 작성</strong></td>
			<td class="content">
			<form>
				<div class="mb-3">
					<textarea id="exampleFormControlTextarea1" rows="3" name="content" class="form-control"></textarea>
				</div>
			<input type="submit" value="답변작성" class="commentBt" />
			</form>
			</td>
		</tr>
	</c:if>
</c:forEach>
</div>
</body>
</html>





