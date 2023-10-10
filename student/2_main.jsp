<jsp:include page="top.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>  

<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">  
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
			
<section class="intro">
	<div class = "card">
		<i class = "fab fa-css3-alt"></i>
		<h1><a href= "#">수강신청</a></h1>
		<div class = "p">
			<p>수강신청 입니다.
			<a href="#">
			<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
			</a>
		</div>
	</div>
	<div class = "card">
		<!--<i class = "fab fa-css3-alt"></i>-->
		<h1><a href="#">비밀번호 변경</a></h1>
		<div class = "p">
			<p>비밀번호 변경 입니다.
			<a href =#>
			<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
			</a>
		</div>
	</div>
	<div class = "card">
		<!--<i class = "fab fa-css3-alt"></i>-->
		<h1>수강신청 안내</a></h1>

		<div class = "p">
			<p>수강신청 안내 입니다.
		<a href = "#">
		<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
		</a>	
		</div>
	</div>
	<div class = "card">
		<!--<i class = "fab fa-css3-alt"></i>-->
		<h1><a href = "#">과목조회</a></h1>
		<div class = "p">
			<p>과목조회 입니다.
			<a href = "#">
			<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
			</a>
		</div>
	</div>
	<div class = "card">
		<!--<i class = "fab fa-css3-alt"></i>-->
		<h1><a href = "#">졸업사정조회</a></h1>
		<div class = "p">
			<p>졸업사정조회 입니다.
			<a href = "">
			<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
			</a>	
		</div>
	</div>
	<div class = "card">
		<!--<i class = "fab fa-css3-alt"></i>-->
		<h1><a href="#">공지사항 안내</a></h1>
		<div class = "p">
			<p>공지사항 안내 입니다.
			<a href="#">
			<span class="btn-more" onclick="fnMenuLoad('/view?attribute=noticeMain&amp;pPage=001',this.id);" id="menu_noti_1"></span>
			</a>
		</div>
	</div>
</section>

<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>공지사항</h3>
        </div>
    </div>

    <!-- board seach area -->
    <div id="board-search">
        <div class="container">
        <!-- 
            <div class="search-window">
                <form action="">
                     <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                        <button type="submit" class="btn btn-dark">검색</button>
                     -->
                    </div>
                </form>
            </div>
        </div>
    </div>
   
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${boardList}">
                <tr onClick="location.href='BoardServlet?command=board_view&NoticeNum=${board.noticeNum }&StudentNum=${stu.studentNum}'" style="cursor:pointer;">
                    <td>${board.noticeNum}</td>
                    <th>
                      
                      ${board.title }
                      
                    </th>
                    <td>${board.day }</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</section>
</body>
</html>