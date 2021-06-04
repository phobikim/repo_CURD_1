<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 페이지</title>
<style type="text/css">
	#insert{
		visibility: hidden;
		display: none;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	let arr;
	//입력창 지우기
	function clearInput(){
		$("#no").val("");
		$("#name").val("");
		$("#publisher").val("");
		$("#writer").val("");
		$("#price").val("");
	}
	function loadList() {
		$.ajax({
			url:"/listBook.min",
			method : "POST",
			dataType : "json"
		})
		.done(function(data) {
			$("#info").text("통신 성공/ 데이터 개수 : " + data.length);
			$("#booklist").empty();
			$.each(data, function(index, b){
				let tr = $("<tr></tr>");
				let no = $("<td></td>").html(b.no);
				let name = $("<td></td>").html(b.name);
				let publisher = $("<td></td>").html(b.publisher);
				let writer = $("<td></td>").html(b.writer);
				let price = $("<td></td>").html(b.price);
				$(tr).append(no,name,publisher,writer,price);
				$("#booklist").append(tr);
			})
			console.log(data);
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			$("#info").text("통신오류.."+ jqXHR.statusText + " ("+jqXHR.status+")");
		})
	}
	//도서 목록 가져오기
	$("#read").click(function(){
		$("#insert").css("visibility","hidden");
		$("#insert").css("display","none");
		loadList();
	});
	
	//도서 추가 div 열기
	$("#creare_div").click(function(){
		$("#info").text("도서 추가중...");
		clearInput();
		$("#insert").css("visibility","visible");
		$("#insert").css("display","inline");
	});
	
	//도서 추가 ajax 통신
	$("#create").click(function(){
		let data = new FormData( document.getElementById("input") );
		$.ajax({
			url:"/insertBookOK.min",
			method : "POST",
			dataType : "json",
			data:data
		})
		.done(function() {
			$("#insert").css("visibility","hidden");
			$("#insert").css("display","none");
			
			$("#info").text("도서 추가 완료 !!")
			loadList();
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			$("#info").text("추가 오류.."+ jqXHR.statusText + " ("+jqXHR.status+")");
		})
	});
});

</script>

</head>
<body>
	<p id="info">info..</p>
	<button id="read">도서 목록</button>
	<button id="creare_div">도서 추가</button>
	<button id="update">도서 수정</button>
	<button id="delete">도서 삭제</button>
	<hr>
	
	<div id="insert">
		<h2>도서 추가하기</h2>
		<form id="input">
			도서이름 : <input type="text" name="name" id="name"><br>
			출판사명 : <input type="text" name="publisher" id="publisher"><br>
			도서작가 : <input type="text" name="writer" id="writer"><br>
			도서가격 : <input type="text" name="price" id="price"><br>
		</form><br>
		<button id="create">추가하기</button>
		<hr>
	</div>

	<table border="1" width="100%">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서이름</th>
				<th>출판사명</th>
				<th>도서작가</th>
				<th>도서가격</th>
			</tr>
		</thead>
		
		<tbody id="booklist"></tbody>
	</table>
	

</body>
</html>