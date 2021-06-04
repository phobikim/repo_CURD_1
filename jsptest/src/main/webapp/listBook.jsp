<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//상품 등록
	$("#btnInsert").click(function(){
		let data = $("input").serializeArray();
		console.log(data);
		$.ajax({
			url:"/insertBookOK.min",
			type:"post",
			data:data,
			success: function() {
				alert("등록 성공");
			}
			
		});
	});
	
});

</script>
</head>
<body>
	<h2>도서 목록</h2>
	
	<hr>
	<table border="1" width="80%">
		<thead>
			<tr >
				<th>도서번호</th>
				<th>도서이름</th>
				<th>출판사명</th>
				<th>도서작가</th>
				<th>도서가격</th>
			</tr>
		</thead>
		<tbody id="BookList"></tbody>
	</table>
	<br>
	<hr>
	
	<form id="input">
		도서이름 : <input type="text" name="name" id="name"><br>
		출판사명 : <input type="text" name="publisher" id="publisher"><br>
		도서작가 : <input type="text" name="writer" id="writer"><br>
		도서가격 : <input type="text" name="price" id="price"><br>
	</form>
	<button id="btnInsert">도서 등록</button>
	<!-- <a href="insertBook.min">도서 등록하기</a> -->
</body>
</html>