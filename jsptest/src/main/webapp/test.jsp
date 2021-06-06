<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>도서 페이지</title>
<style type="text/css">
	#tableinfo{
		visibility: hidden;
		display: none;
	}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	loadList();
	
	$(document).on("click","tr",function(){
		$("#tableinfo").css("visibility","visible");
		$("#tableinfo").css("display","inline");
		$("tr").removeClass("active");
		let td_arr = $(this).find("td");
		
		$("#no").val(  $(td_arr[0]).text()   );
		$("#name").val(  $(td_arr[1]).text()   );
		$("#publisher").val(  $(td_arr[2]).text()   );
		$("#writer").val(  $(td_arr[3]).text()  );
		$("#price").val(  $(td_arr[4]).text()  );
	});
	
	//입력창 지우기
	function clearInput(){
		$("#name").val("");
		$("#publisher").val("");
		$("#writer").val("");
		$("#price").val("");
	}
	
	//search
	$("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#booklist tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
  	});
	
	//목록 가져오기
	function loadList() {
		$.ajax({
			url:"/listBook.min",
			method : "POST",
			dataType : "json"
		})
		.done(function(data) {
			$("#info").text("info.. 통신 성공/ 데이터 개수 : " + data.length);
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
			$("#info").text("info.. 통신오류/ "+ jqXHR.statusText + " ("+jqXHR.status+")");
		})
	}
	//도서 목록 가져오기 = read 버튼
	$("#read").click(function(){
		$("#insert").css("visibility","hidden");
		$("#insert").css("display","none");
		loadList();
	});

	//도서 추가 ajax 통신
	$("#submit").click(function(){
		let data = $("#input").serializeArray();
		$.ajax({
			url:"/insertBookOK.min",
			method : "POST",
			data:data
		})
		.done(function() {
			$("#tableinfo").css("visibility","hidden");
			$("#tableinfo").css("display","none");
			alert("도서 등록 성공" );
			$("#info").text("info.. 도서 추가 완료 !!")
			loadList();
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			$("#info").text("info.. 추가 오류/ "+ jqXHR.statusText + " ("+jqXHR.status+")");
		})
	});
	//도서 추가 - 취소
	$("#cancle").click(function(){
		$("#tableinfo").css("visibility","hidden");
		$("#tableinfo").css("display","none");
	});
	//도서 추가 끝==========================================================
	
	$("#update").click(function(){
		let data = $("#input").serializeArray();
		console.log(data);
		$.ajax({
			url:"/updateBook.min",
			method: "POST",
			data:data
		})
		.done(function(){
			$("#tableinfo").css("visibility","hidden");
			$("#tableinfo").css("display","none");
			alert("도서 수정 성공" );
			$("#info").text("info.. 도서 수정 완료 !!")
			loadList();
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			$("#info").text("info.. 수정 오류/ "+ jqXHR.statusText + " ("+jqXHR.status+")");
		})
		
	});
	
	$("#delete").click(function(){
		alert("삭제");
	});
		

});

</script>

</head>
<body>
	
	<div class="panel panel-default">
    	<div class="panel-body">
    		<p id="info">info..</p>
			<!--  
			<button id="read" class="btn btn-success">도서 목록</button>
    		<button class="btn btn-success" id="creare_div">도서 추가</button>
			<button class="btn btn-warning" id="update">도서 수정</button>
			<button class="btn btn-danger" id="delete">도서 삭제</button>
			-->
    	</div>
  	</div>
  	
	<div class="container">
		<div class="jumbotron">
			<!-- search -->
			<p>검색하기</p>
			<input class="form-control" id="myInput" type="text" placeholder="Search..">
		</div>
	</div>
	
	<h2>도서 목록</h2>
	<table class="table table-hover">
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
	
	<!--테이블 추가/수정/삭제  -->
	<div class="container" id="tableinfo">
  		<div class="jumbotron">
			<h3 id="menu_info"><small>정보를 입력해주세요.</small></h3>
			<hr>
			<form id="input">
				<div class="form-group">
					<label>도서번호:</label>
					<input type="text" readonly class="form-control" name="no" id="no">
			    </div>
			    <div class="form-group">
					<label>도서이름:</label>
					<input type="text" class="form-control" name="name" id="name">
			    </div>
			     <div class="form-group">
					<label>출판사명:</label>
					<input type="text" class="form-control" name="publisher" id="publisher">
			    </div>
			     <div class="form-group">
					<label>도서작가:</label>
					<input type="text" class="form-control" name="writer" id="writer">
			    </div>
			     <div class="form-group">
					<label>도서가격:</label>
					<input type="text" class="form-control" name="price" id="price">
			    </div>
			</form><br>
			<button class="btn btn-success btn-sm" id="submit">추가</button>
			<button class="btn btn-warning btn-sm" id="update">수정</button>
			<button class="btn btn-danger btn-sm" id="delete">삭제</button>
			<button class="btn btn-default btn-sm" id="cancle">취소</button>
		</div>
	</div>

</body>
</html>