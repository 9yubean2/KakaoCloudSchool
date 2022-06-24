<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
$(()=>{
	init();
})

function init(){
	$.ajax({
		url:"jQueryAjaxBoarListResult.jsp",
		dataType:"json"
	})
	.done(
		(result)=>{
			let list = result.data;
			//console.log(list);
			list.forEach((item)=>{
				$("#tbody:last")
				.append(`<tr><td>\${item.id}</td><td>\${item.title}</td><td>\${item.writer}</td><td>\${item.hit}</td></tr>`);
			});
		}
	)
	.fail( (jqXhr, error)=>{
		console.log(error);
	})
}
</script>