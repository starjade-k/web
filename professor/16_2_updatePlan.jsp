<jsp:include page="top_pro.jsp"/>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1">
    <title>강의계획서</title>
	
	
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
    .button{
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

<div class="container">

  <main span style="font-family: 'Gowun Dodum' !important;">
 <div class="page-title">
        <div class="container">
            <h3>강의계획서 수정</h3>
        </div>
    </div>

    
   

  
    <div class="col-12">
      
      
        
   <form method="post" action="BoardServlet">
      <input type="hidden" name="command" value="update_plan">
   
          <div class="row g-3">
            <div class="col-sm-8">
              <label for="firstName" class="form-label">강의명</label>
              <input type="text" class="form-control" id='className' name="className" placeholder="강의명" required readonly value="${name.className }"> 
              <input type="hidden" id="ClassNum" name="ClassNum" value="${plan.classNum }">
              <span id="message"></span>
            </div>
            
			<div class="col-sm-4">
              <label for="firstName" class="form-label">교수</label>
              <input type="text" class="form-control" id='name' name="name" required readonly value="${name.professorNum }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">1주차</label>
             <input type="text" class="form-control" id='week1' name="week1" required value="${plan.week1 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">2주차</label>
             <input type="text" class="form-control" id='week2' name="week2" required  value="${plan.week2 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">3주차</label>
             <input type="text" class="form-control" id='week3' name="week3" required  value="${plan.week3 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">4주차</label>
             <input type="text" class="form-control" id='week4' name="week4" required  value="${plan.week4 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">5주차</label>
             <input type="text" class="form-control" id='week5' name="week5" required  value="${plan.week5 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">6주차</label>
             <input type="text" class="form-control" id='week6' name="week6" required  value="${plan.week6 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">7주차</label>
             <input type="text" class="form-control" id='week7' name="week7" required  value="${plan.week7 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">8주차</label>
             <input type="text" class="form-control" id='week8' name="week8" required  value="${plan.week8 }">  
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">9주차</label>
             <input type="text" class="form-control" id='week9' name="week9" required  value="${plan.week9 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">10주차</label>
             <input type="text" class="form-control" id='week10' name="week10" required  value="${plan.week10 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">11주차</label>
             <input type="text" class="form-control" id='week11' name="week11" required  value="${plan.week11 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">12주차</label>
             <input type="text" class="form-control" id='week12' name="week12" required  value="${plan.week12 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">13주차</label>
             <input type="text" class="form-control" id='week13' name="week13" required  value="${plan.week13 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">14주차</label>
             <input type="text" class="form-control" id='week14' name="week14" required  value="${plan.week14 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">15주차</label>
             <input type="text" class="form-control" id='week15' name="week15" required  value="${plan.week15 }"> 
              <span id="message"></span>
            </div>
            <div class="col-sm-12">
              <label for="firstName" class="form-label">16주차</label>
             <input type="text" class="form-control" id='week16' name="week16" required  value="${plan.week16 }"> 
              <span id="message"></span>
            </div>
            
         
            

          <hr class="my-4">
			<div class="button">
         <a class="w-25 btn btn-primary btn-lg" href="javascript:history.back()">돌아가기</a>
          
          <input type="submit" class="w-25 btn btn-primary btn-lg" value="수정하기">
          </div>
          </div>
        </form>
      </div>
      </main>
    </div>
  





 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="form-validation.js"></script>
      
  </body>
</html>
