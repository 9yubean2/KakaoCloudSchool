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
	ID:<input type="text" id="userid"> <br/>
	PW:<input type="text" id="userpw"> <br/>
	
	<div id="result"></div>
	
	<button type="button" id="btnCall">SEND</button>
</body>
</html>
<script>
$(()=>{
	$("#btnCall").click(()=>{
		$.ajax({
			url:"receive.jsp",
			method:"GET",
			dataType:"text",
			data:{userid:$("#userid").val(), userpw:$("#userpw").val()}//수신시 데이터의 형
			}
		)
		.done(
			(result)=>{
				$("#result").html(result);
			}
		)
		.fail( (jqXhr, error)=>{
			console.log(error);
		})
	})
})
</script>
