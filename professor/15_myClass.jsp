<jsp:include page="top_pro.jsp"/>
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
    <title>내 강의조회</title>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
	  
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
	<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">    
	<script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>    
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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Brush+Script&display=swap" rel="stylesheet">

 
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
  
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
   			transform: translate(-15px, 0);
   		}
   		#link{
   			color:blue;
   		}
   		
    </style>
  </head>
  <body>
  
    <main span style="font-family: 'Gowun Dodum' !important;">
  
<div class="container">

  	<div class="page-title">
        <div class="container">
            <h3>내 강의조회</h3>
        </div>
    </div>

	<table class="table">
	   <thead>
	    <tr>
	      <th scope="col">강의명</th>
	      <th scope="col">강의시간</th>
	      <th scope="col">강의실</th>
	      <th scope="col">정원</th>
	      <th scope="col">학점</th>
	      <th scope="col">강의계획서</th>
	      <th scope="col">승인여부</th>
	    </tr>
	  </thead>
	  
	  	<c:forEach var="plan" items="${classList }">
		  <tr>
		      <td scope="col">${plan.className}</td>
		      <td scope="col">${plan.time }</td>
		      <td scope="col">${plan.classroom }</td>
		      <td scope="col">${plan.max }</td>
		      <td scope="col">${plan.credit }</td>
		      
		      
		      <td scope="col">
		       <c:if test="${plan.planYN == 'N'}">
		      <a id=link href="BoardServlet?command=add_plan_write&ClassNum=${plan.classNum }">강의계획서 작성</a>
		      </c:if>
		      <c:if test="${plan.planYN == 'Y'}">
		      <a id=link href="BoardServlet?command=select_plan&ClassNum=${plan.classNum }">강의계획서</a>
		      </c:if>
		      </td>
		      <td scope="col">
		      	<c:if test="${plan.confirm  == 'true'}">
		      		승인됨
		      	</c:if>
		      	<c:if test="${plan.confirm  == 'false'}">
		      		대기중
		      	</c:if>
		      </td>
		 </tr>
		 </c:forEach>
	
  	</table>
  	
  

  </main>
  





 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="form-validation.js"></script>
      
  </body>
</html>
