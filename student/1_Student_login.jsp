<jsp:include page="/0_loginbase.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<head>
<link rel="stylesheet" href="css/login.css">
<style>
	.radio{
		text-align:center;
	}
</style>
</head>
<body>

<img class = "login-design" src="img/test_logo1.png" alt="로고" />

<div class="whole-form">
    <div class="login-container">
    <hr class = "login-hr">
        <form method = "post" action = "StudentServlet">
        	<input type="hidden" name="command" value="loginStudent">
            <div class="input-container">
                <label for="username" class = "label-flex">아이디</label>
                <input type="text" id="studentNum" name="studentNum" placeholder="아이디를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디를 입력해 주세요.'">
            </div>
            <div class="input-container">
                <label for="password" class = "label-flex">비밀번호</label>
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력해 주세요.'">
            </div>
            <div class="radio">
	            <input type="radio" name="loginCheck" value="student" checked="checked" onclick = "location.href='1_Student_login.jsp'">학생
				<input type="radio" name="loginCheck" value="professor" onclick = "location.href='1_Professor_login.jsp'">교수
				<input type="radio" name="loginCheck" value="admin" onclick = "location.href='1_Admin_login.jsp'">관리자
			</div>
		<hr class = "login-hr">
            <div class="button-container">
            <button class="forgot-password" type="button" onclick="location.href='#'">ID|PW찾기</button>
            <button type="submit">로그인</button>
            
            </div>
        </form>
    </div>
</div>
</body>
</html>