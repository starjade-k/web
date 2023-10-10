<jsp:include page="top.jsp"/>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko"> 
  <head>

  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1">
    <title>고객센터</title>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
	  
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
	<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
	
	
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
      <link rel="stylesheet" href="css/main.css">  
    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">

  <link href="form-validation.css" rel="stylesheet">

<meta name="theme-color" content="#7952b3">

    <style>
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
   			transform: translate(-30px, 0);
   		}
    </style>

    
    <!-- Custom styles for this template -->
   
  </head>
  <body>
 
 
  

  
  
<div class="container">

  <main span style="font-family: 'Gowun Dodum' !important;">
  <div class="py-5 text-center">
    </div> 
    <c:forEach var="student" items="${userList}">
    
  <ul class="nav nav-tabs">
       <c:if test="${student.studentNum ne null}">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="BoardServlet?command=qna_list&StudentNum=${student.studentNum}">문의 내역</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="BoardServlet?command=add_qna&StudentNum=${student.studentNum }">문의하기</a>
  </li>
     </c:if>
  <c:if test="${student.studentNum eq null}">
	     <li>
	        <a class="nav-link active" href="#">문의 내역</a>
	  	 </li>
	 </c:if>
</ul>
   </c:forEach>

<table border="0" class="table">
<thead>
    <tr>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">답변여부</th>
      <th scope="col">작성일</th>
      
    </tr>
  </thead>
    <c:forEach var="student" items="${userList}">
		<c:forEach var="qna" items="${qna}">
			<tr onClick="location.href='BoardServlet?command=select_qna&QnaNum=${qna.qnaNum }&StudentNum=${student.studentNum }'" style="cursor:pointer;">
				<td align="left" class="subject">${qna.title }</a></td>
				<td class="writer">${qna.writer }</td>
				<c:if test="${qna.answer eq null}">
				<td class="comment">X</td>
				</c:if>
				<c:if test="${qna.answer ne null}">
				<td class="comment">O</td>
				</c:if>
				<td class="writeDate">${qna.day }</td>
			</tr>
		</c:forEach>
		</c:forEach>
</table>
	${pageHttp}
<br/><br/>
</main>


   

  
    
    </div>


</div>


 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="form-validation.js"></script>
      
  </body>
</html>
