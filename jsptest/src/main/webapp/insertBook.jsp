<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록하기</title>
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
	<h2>도서 등록하기</h2>
	
	<form id="input">
	도서이름 : <input type="text" name="name" id="name"><br>
	출판사명 : <input type="text" name="publisher" id="publisher"><br>
	도서작가 : <input type="text" name="writer" id="writer"><br>
	도서가격 : <input type="text" name="price" id="price"><br>
	</form>
	
	<a href="listBook.min">도서 목록보기</a>
</body>
</html>