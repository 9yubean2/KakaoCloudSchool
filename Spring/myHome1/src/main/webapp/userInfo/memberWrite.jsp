<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container" >
		<h3 style="margin-top: 50px">SignUp</h3>
		<div style="margin-top: 30px">
			<!-- <form name="myform" id="myform" method="post" enctype="multipart/form-data"> -->
			<form name="myform" id="myform" method="post">
			<input type="hidden" id="idCheckIn" value="N"/>
			<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="Enter ID" name="userid" id="userid">
      			<div class="input-group-append">
      				<button type="button" class="btn btn-success" id="btnCheck">Check</button>
      			</div>
    		</div>
    		<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="Enter Password" name="userpw" id="userpw">
    		</div>
    		<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="name" name="username" id="username">
    		</div>
    		<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="phone" name="userphone" id="userphone">
    		</div>
    		<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="email" name="useremail" id="useremail">
    		</div>
    		<div class="input-group mb-3">
      			<input type="text" class="form-control" placeholder="address" name="useraddr" id="useraddr">
    		</div>
    		<div class="input-group mb-3">
      			<input type="file" class="form-control" name="userfile" id="userfile">
    		</div>
    		<div>
			<button type="button" class="btn btn-success" id="btnSignup" >SignUp</button>
			</div>
			</form>
			
		</div>
		
		
	</div>
</body>
</html>
<script>
//id 중복체크 idcheck.jsp
//if userid == test 면 result:false
//true면 idcheckyn 필드의 값을 y로 바꾸고 prop("readonly",true)로 추가입력 안되게 막기
$(()=>{
	$("#btnCheck").click(()=>{
		//console.log($("#idCheckIn").val());
		check();
	})
	$("#btnSignup").click(()=>{
		let parameter = "userid="+$("#userid").val()+"&userpw="+$("#userpw").val()+"&username="+$("#username").val()+"&useremail="+$("#useremail").val()+"&userphone="+$("#userphone").val()+"&useraddr="+$("#useraddr").val();
		console.log(parameter);
		//form에enctype 지정하면 직렬화 불가
		console.log("====직렬화====");
		parameter = $("#myform").serialize();
		console.log(parameter);
		/* const formData = new FormData(document.myform);
		//첨부파일이 있으면 첨부파일을 별도로 추가해야한다.
		formData.append("upload",file.files[0]);
		
		console.log(formData);
		for(value of formData.values()){
			console.log(value);
		} */
		$.ajax({
			url:"userInfoSave.jsp",
			method:"POST",
			dataType:"text", //파싱 필요 없다
			data:parameter//수신시 데이터의 형
			}
		)
		.done(
			(result)=>{
				//console.log(result);
				location.href="<%=request.getContextPath()%>/index.jsp";
			}
		)
		.fail((jqXhr, error)=>{
			console.log(error);
		})
		
	})
})
function check() {
	let inputId = $("#userid").val();
	console.log(inputId);
	$.ajax({
		url:"id_check.jsp",
		method:"POST",
		dataType:"json", //파싱 필요 없다
		data:{id:inputId}//수신시 데이터의 형
		}
	)
	.done(
		(result)=>{
			if(result.check == true){
				alert("OK");
				$("#idCheckIn").val("Y");
				$("#userid").prop("readonly",true);
				
			} else {
				alert("Already Exist");
			}
		}
	)
	.fail((jqXhr, error)=>{
		console.log(error);
	})
}
</script>