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
<style>
h2, table{
margin-top : 20px;
}

</style>
</head>
<body>
	<div class="mb-3 mt-3">
		Name    <input type="text" id="name" class="form-control">
		Korea    <input type="text" id="kor" class="form-control">
		English    <input type="text" id="eng" class="form-control">
		Math    <input type="text" id="math" class="form-control">
		<p></p>
		<button type="button" id="btnAdd" class="btn btn-primary">Add</button>
    </div>
	
	<h2>SCORE TABLE</h2>
		<p></p>
		<table class="table" id="mytable" style="text-align:center">
			<thead class="thead-dark">
				<th>Name</th>
				<th>Korea</th>
				<th>English</th>
				<th>Math</th>
				<th>Total</th>
				<th>Average</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
</body>
</html>
<script>
$(()=>{
	$("#btnAdd").click(()=>{
		let name = $("#name").val();
		let kor = parseInt( $("#kor").val() );
		let eng = parseInt( $("#eng").val() );
		let math = parseInt( $("#math").val() );
		let total = kor + eng + math;
		let average = total / 3;
		$("#tbody:last")
		.append(`<tr><td>\${name}</td><td>\${kor}</td><td>\${eng}</td><td>\${math}</td><td>\${total}</td><td>\${average.toFixed(1)}</td></tr>`);
	});
});
</script>