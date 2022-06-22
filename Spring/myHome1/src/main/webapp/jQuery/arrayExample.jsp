<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<input type="text" name="numbers" id="num1" value="1"><br/>
	<input type="text" name="numbers" id="num2" value="3"><br/>
	<input type="text" name="numbers" id="num3" value="11"><br/>
	<input type="text" name="numbers" id="num4" value="21"><br/>
	<input type="text" name="numbers" id="num5" value="14"><br/>
	<input type="text" name="numbers" id="num6" value="11"><br/>
	<input type="text" name="numbers" id="num7" value="12"><br/>
	<input type="text" name="numbers" id="num8" value="10"><br/>
	<input type="text" name="numbers" id="num9" value="19"><br/>
	<input type="text" name="numbers" id="num10" value="17"><br/>
	---------------------------------------------<br/>
	<div id="result"></div>
	<button id="btnAddByName" type="button">ADD BY NAME</button>
	<button id="btnAddById" type="button">ADD BY ID</button>
</body>
</html>
<script>
	$(()=>{
		$("#btnAddByName").click(()=>{
			let result = 0;
			
			$("input[type=text][name=numbers]").each(function(){
				result += parseInt($(this).val());
			});
			
			$("#result").html(`<h3>Add By Name: \${result}</h3>`);
		});
		
		
		$("#btnAddById").click(()=>{
			let result = 0;
			
			for(i=1;i<=10;i++){
				result += parseInt($("#num"+i).val());
			}
			
			 $("#result").html(`<h3>Add By Id: \${result}</h3>`);
		});
	});
</script>