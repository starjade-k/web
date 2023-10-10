<jsp:include page="top_mypage.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/class_cart.css"> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>관심강좌 목록</h3>
        </div>
    </div>

    <!-- board seach area -->

   
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">강좌번호</th>
                    <th scope="col" class="th-title">강의명</th>
                    <th scope="col" class="th-credit">학점</th>
                    <th scope="col" class="th-major-num">전공번호</th>
                    <th scope="col" class="th-max">정원</th>
                    <th scope="col" class="th-choice">선택</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>3</td>
                    <th>
                      <a>강의명입니다</a>
                	</th> 
                    <td>2023.08.06</td>
                    <td>1242</td>
                    <td>23/30</td>
                    <td><input type="checkbox" name = "choice" value = "y"></td>
                </tr>

                <tr>
                    <td>2</td>
                    <th><a>강의명입니다</a></th>
                    <td>2023.08.05</td>
                    <td>5431</td>
                    <td>18/30</td>
                    <td><input type="checkbox" name = "choice" value = "y"></td>
                </tr>

                <tr>
                    <td>1</td>
                    <th><a>강의명입니다</a></th>
                    <td>2023.08.04</td>
                    <td>2351</td>
                    <td>12/30</td>
                    <td><input type="checkbox" name = "choice" value = "y"></td>
                </tr>
                <tr>
                    <td>1</td>
                    <th><a>강의명입니다</a></th>
                    <td>2023.08.04</td>
                    <td>6343</td>
                    <td>0/30</td>
                    <td><input type="checkbox" name = "choice" value = "y"></td>
                </tr>
                </tbody>

            </table>
            <button class="d" name = "delete" style="text-align: right;" >삭제하기</button>
        </div>
    </div>

</section>

</body>
</html>