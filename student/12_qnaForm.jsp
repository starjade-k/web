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
	<link rel="stylesheet" href="css/main.css">  
	
	<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" type="text/css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
	  
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
	<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">    
	<script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>    
	<script src="/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>
	
	
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    

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



<meta name="theme-color" content="#7952b3">

	<script type="text/javascript">
	function formCheck() {
	if (writeForm.title.value.length < 1){
	alert("제목을 입력하세요.");
	writeForm.title.focus();
	return false;
	} 
	if (writeForm.content.value.length < 1){
	alert("내용을 입력하세요.");
	writeForm.content.focus();
	return false;
	}
	return true;
	}
	</script> 
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
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body>


  
  
  
<div class="container" >

  <main span style="font-family: 'Gowun Dodum' !important;">
  <div class="py-5 text-center">
      <h2>고객센터</h2>
    </div>
    <c:forEach var="student" items="${userList}">
  <ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="BoardServlet?command=qna_list&StudentNum=${student.studentNum}">문의 내역</a>
  </li>
  <li class="nav-item">
     
     <li>
     <a class="nav-link active" href="BoardServlet?command=add_qna&StudentNum=${student.studentNum}">문의하기</a>
     </li>

  </li>
</ul>
</c:forEach>
   <!-- 
    <form name="writeForm" action="qnaForm" method="post" onsubmit="return formCheck()" enctype="multipart/form-data" >
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">제목</label>
  <input type="text" id="title" name="title" class="form-control"  >
  <input type="hidden" id="writer" name="writer" value="${username}" /> <!– 세션변수 ->
  <input type="hidden" id="writerId" name="writerId" value="${userId}" />
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
  <textarea name="content" class="form-control" id="content" rows="3"></textarea>
</div>

<br>
<br>

<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="reset">재작성</button>
  <button class="btn btn-primary" type="submit">확인</button>
</div>
</form>
-->
<form method="post" action="BoardServlet">
   <input type="hidden" name="command" value="add_qna_write">
          <div class="row g-3">
           <div class="col-2">
           </div>
            <div class="col-sm-5">
              <label for="firstName" class="form-label">제목</label>
              <input type="text" class="form-control" id='title' name="title" placeholder="- 문의 내용을 간단히 적어주세요" required> 
              <span id="message"></span>
            </div>
            <div class="col-sm-2">
              <label for="firstName" class="form-label">질문 유형</label>
             <select class="form-select"  id='type' name="type" required>
              	<option value="학점">학점</option>
              	<option value="수강신청">수강신청</option>
              	<option value="졸업">졸업</option>
              	<option value="휴학/복학/자퇴/제적/재입학">휴학/복학/자퇴/제적/재입학</option>
              	</select>
              <span id="message"></span>
            </div>
            
			<div class="col-sm-1">
			<c:forEach var="student" items="${userList}">
              <label for="firstName" class="form-label">학생</label>
              
    			<!--  교수 로그인 이후 여기 고쳐야됨-->
              <input type="text" class="form-control" name="writer"required readonly value=${student.name }> 
                   
              
              <input type="hidden" id="StudentNum" name="StudentNum" value=${student.studentNum }>
              </c:forEach>
              <span id="message"></span>
            </div>
           
          
            
              
            
            
            <!-- 여백용 -->
			 <div class="col-2">
             </div>
              <div class="col-2">
              </div>

            <div class="col-8">
              <label for="" class="form-label">내용</label>
              <div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label"></label>
				  <textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="3" placeholder="- 문의 내용을 상세히 작성하시면 보다 빠른 해결이 가능합니다"></textarea>
				</div>
            </div>
             
             
		
          <hr class="my-4">
		
          <button class="w-25 btn btn-primary btn-lg" type="submit">문의 등록</button>
         
          </div>
        </form>

  
      </main>
    </div>






 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="form-validation.js"></script>
      
  </body>
</html>
