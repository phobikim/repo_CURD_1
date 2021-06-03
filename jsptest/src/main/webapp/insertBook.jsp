<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 등록하기</h2>
	
	<form action="insertBookOK.min" method="post">
		도서번호 : <input type="text" name="no"><br>
		도서이름 : <input type="text" name="name"><br>
		출판사명 : <input type="text" name="publisher"><br>
		글쓴이 : <input type="text" name="writer"><br>
		도서가격 : <input type="text" name="price"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	<a href="listBook.min">도서 목록보기</a>
</body>
</html>