<jsp:include page="top_pro.jsp"/>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.net.URLEncoder" %>
<%@ page import="javax.sql.*, java.sql.*, javax.naming.*" %>
<%@ page import="com.pj.dao.ProDAO" %>
<%@ page import="com.pj.dto.ProDTO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<jsp:useBean id="pro" class="com.pj.dto.ProDTO" scope="session"/>
<jsp:setProperty name="pro" property="*" />
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1"> 
    <title>강의등록</title>
	<link rel="stylesheet" href="css/main.css">  
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
	  
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
	<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">    
	<script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>    
	
	
	
    

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
<% 	//StuDAO에 있는 메서드를 사용하기위해 stuDAO 인스턴스 생성
ProDAO stuDAO = new ProDAO();
		ArrayList<ProDTO> user_info = new ArrayList<ProDTO>(stuDAO.my_Info(pro.getProfessorNum()));
		%>
<div class="container">

  <main span style="font-family: 'Gowun Dodum' !important;">
  <div class="page-title">
        <div class="container">
            <h3>강의등록</h3>
        </div>
    </div>
  
    
   

  
    <div class="col-12" id="add">
      
      
        
   <form method="post" action="BoardServlet">
   <input type="hidden" name="command" value="add_class_write">
          <div class="row g-3">
           <div class="col-2">
           </div>
            <div class="col-sm-5">
              <label for="firstName" class="form-label">강의명</label>
              <input type="text" class="form-control" id='className' name="className" placeholder="강의명" required> 
              <span id="message"></span>
            </div>
            <div class="col-sm-1">
              <label for="firstName" class="form-label">전공 | 교양</label>
             <select class="form-select"  id='liberal' name="liberal" required>
              	<option value="전공">전공</option>
              	<option value="교양">교양</option>
              	</select>
              <span id="message"></span>
            </div>
            
			<div class="col-sm-2">
              <label for="firstName" class="form-label">교수</label>
              
    			<!--  교수 로그인 이후 여기 고쳐야됨-->
    			<%for(ProDTO ui : user_info) { %>
              <input type="text" class="form-control" required readonly value="<%=ui.getName()%>"> 
              <input type="hidden" id="professorNum" name="professorNum" value="<%=ui.getProfessorNum()%>">
              <input type="hidden" id="majorNum" name="majorNum" value="<%=ui.getMajorNum()%>">
              <%}
        	%>
              <span id="message"></span>
            </div>
            
            <!-- 여백용 -->
             <div class="col-2">
             </div>
              <div class="col-2">
              </div>
              
            <div class="col-sm-3">
              <label for="firstName" class="form-label">시작교시</label>
              <select class="form-select"  id='startTime' name="startTime" required>
              	<option value="1교시">1교시</option>
              	<option value="2교시">2교시</option>
              	<option value="3교시">3교시</option>
              	<option value="4교시">4교시</option>
              	<option value="5교시">5교시</option>
              	<option value="6교시">6교시</option>
              	<option value="7교시">7교시</option>
              	<option value="8교시">8교시</option>
              	<option value="9교시">9교시</option>
              	<option value="10교시">10교시</option>
              	<option value="11교시">11교시</option>
              	<option value="12교시">12교시</option>
              	<option value="13교시">13교시</option>
              </select>
              <span id="message"></span>
            </div>
          
          
             <div class="col-sm-3">
              <label for="firstName" class="form-label">종료교시</label>
              <select class="form-select"  id='lastTime' name="lastTime" required>
              	<option value="1교시">1교시</option>
              	<option value="2교시">2교시</option>
              	<option value="3교시">3교시</option>
              	<option value="4교시">4교시</option>
              	<option value="5교시">5교시</option>
              	<option value="6교시">6교시</option>
              	<option value="7교시">7교시</option>
              	<option value="8교시">8교시</option>
              	<option value="9교시">9교시</option>
              	<option value="10교시">10교시</option>
              	<option value="11교시">11교시</option>
              	<option value="12교시">12교시</option>
              	<option value="13교시">13교시</option>
              </select>
              <span id="message"></span>
            </div>
            
           
            
 			<div class="col-sm-2">
              <label for="firstName" class="form-label">학점</label>
              <select class="form-select"  id='credit' name="credit" required>
              	<option value=1>1학점</option>
              	<option value=2>2학점</option>
              	<option value=3>3학점</option>
              	<option value=4>4학점</option>
              </select>
              <span id="message"></span>
            </div>
            
            <!-- 여백용 -->
			 <div class="col-2">
             </div>
              <div class="col-2">
              </div>

            <div class="col-6">
              <label for="" class="form-label">강의실</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="classRoom" name="classRoom" placeholder="강의실 이름" required>
             
              </div>
            </div>
             
             <div class="col-2">
              <label for="" class="form-label">정원</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="max" name="max" placeholder="정원" required>
             
              </div>
            </div>
		
          <hr class="my-4">
		
          <button class="w-25 btn btn-primary btn-lg" type="submit">강의 등록</button>
         
          </div>
        </form>
      </div>
      </main>
    </div>
  





 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="form-validation.js"></script>
      
  </body>
</html>
