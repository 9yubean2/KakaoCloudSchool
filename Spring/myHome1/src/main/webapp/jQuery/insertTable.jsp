<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<th>View</th>
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
let data= [
	{id:1, title:"title-1", writer:"writer_1", view:11},
	{id:2, title:"title-2", writer:"writer_2", view:22},
	{id:3, title:"title-3", writer:"writer_3", view:33},
	{id:4, title:"title-4", writer:"writer_4", view:44},
	{id:5, title:"title-5", writer:"writer_5", view:55}
]

$(()=>{
	init();
});

function init() {
	data.forEach((item)=>{
		$("#tbody:last")
		.append(`<tr><td>\${item.id}</td><td>\${item.title}</td><td>\${item.writer}</td><td>\${item.view}</td></tr>`);
	});
	
	data.forEach((item)=>{
		$("#list:last")
		.append(`<li>\${item.title}</li>`);
	});
}
</script>
