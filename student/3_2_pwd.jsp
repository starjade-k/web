<jsp:include page="top_mypage.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/pwd.css"> 
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>

<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>비밀번호 변경</h3>
        </div>
    </div>

    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <tbody>
                <tr>
                <form method = "post" name="edit" action = "3_2_pwd_Action.jsp">
                    <th style="text-align: center"><a>현재 비밀번호 <input type = "password" name= "pwd" id="pwd"  placeholder="비밀번호를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력해 주세요.'"></a></th> 

                    <th style="text-align: center"><a>변경 할 비밀번호  <input type = "password" name= "new_pwd" id ="new_pwd"  placeholder="비밀번호를 입력해 주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력해 주세요.'"></a></th>
                	
                    <th style="text-align: center"><a>변경 할 비빌번호 확인  <input type = "password" name= "new_pwd_chk" id ="new_pwd_chk"  placeholder="비밀번호 확인해주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호 확인해주세요.'"></a></th>
                	<th> <input type="submit" class="d" name = "update" value = "변경하기" style="margin-left:90px; font-size: 17px;" ></th>
                </form>
                </tr>
                </tbody>

            </table>
        </div>
    </div>

</section>

</body>
</html>