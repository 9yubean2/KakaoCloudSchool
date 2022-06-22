<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Table</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" -->
<!-- script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
<style>
.blue {
	color:#0000ff;
}
.backgroundYellow{
	padding: 10px;
	background-color:#ffff00;
}
</style>
</head>
<body>
	<h1>Add Class</h1>
	<h1>Add Class too</h1>
	<p>p Tag</p>
	<p>Append to p Tag too</p>
	<button id="btnAdd" type="button">Add</button>
	<button id="btnDelete" type="button">Delete</button>
	
</body>
</html>
<script>
$(()=>{
	$("#btnAdd").click(()=>{
		$("h1").addClass("blue");
		$("p").addClass("backgroundYellow");
	});
	$("#btnDelete").click(()=>{
		$("h1").removeClass("blue");
		$("p").removeClass("backgroundYellow");
	});
});
</script>