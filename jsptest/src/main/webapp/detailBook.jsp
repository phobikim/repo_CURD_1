<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 상세보기</h2>
	<hr>
	<p>도서번호 : ${vo.no }</p>
	<p>도서이름 : ${vo.name }</p>
	<p>출판사명 : ${vo.publisher }</p>
	<p>출판사명 : ${vo.writer }</p>
	<p>도서가격 : ${vo.price }</p>
	<hr>
	<a href="listBook.min">목록</a>
</body>
</html>