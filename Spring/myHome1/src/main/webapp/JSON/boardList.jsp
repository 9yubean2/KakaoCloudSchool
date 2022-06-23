<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Table</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>TABLE</h2>
		<p></p>
		<table class="table" id="mytable">
			<thead class="thead-dark">
				<th>No</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Hit</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
		<p></p>
		<ul id="list">
		
		</ul>		
	</div>
	
</body>
</html>

<script>
window.onload = function () {
	init();
}


function init() {
	var url = "jsonTest2.jsp";
	//console.log(url);
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		//console.log(this.responseText);
		let response = JSON.parse(this.responseText);
		//let totalCount = response.totalCount;
		let list = response.data;
		//console.log(list);
		
		/* 
		by. jQuery
		list.forEach((item)=>{
			$("#tbody:last")
			.append(`<tr><td>\${item.id}</td><td>\${item.title}</td><td>\${item.writer}</td><td>\${item.hit}</td></tr>`);
		}); */
		
		
		//by. JavaScript
		let tbody = document.getElementbyId("tbody");
		list.forEach((item)=>{
			let row = tbody.insertRow(tbody.rows.length);
			row.insertCell(0).innerHTML = item.id;
			row.insertCell(1).innerHTML = item.title;
			row.insertCell(2).innerHTML = item.writer;
			row.insertCell(3).innerHTML = item.hits;
		});
		
	}
	xhttp.open("GET",url,true);
	xhttp.send();
	
}

</script>