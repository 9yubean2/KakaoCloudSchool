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
<div class="input-group mb-3">
<input type="text" class="form-control" placeholder="id" name="userid" id="userid">
</div>
<div class="input-group mb-3">
<input type="text" class="form-control" placeholder="pw" name="userpw" id="userpw">
</div>
<div class="input-group-append">
<button type="button" class="btn btn-success" id="btnLogin">Login</button>
</div>
</body>
</html>
<script>

$(()=>{
	$("#btnLogin").click(()=>{
		$.ajax({
			url:"login_proc.jsp",
			data:{userid:$("#userid").val(),userpw:$("#userpw").val()},
			dataType:"json",
			method:"POST"
		})
		.done((result)=>{
			if(result.status == "success"){
				alert("SUCCESS!");
				location.href="<%=request.getContextPath()%>/test1.jsp";
				
			} else {
				alert("FAIL,,");
			}
		})
		.fail((jqXHR,error)=>{
			console.log(error);
		})
		
	})
})
</script>
