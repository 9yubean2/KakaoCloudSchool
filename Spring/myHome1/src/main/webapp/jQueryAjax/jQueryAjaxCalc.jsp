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
num1:  <input type="text" id="num1" ><br/>
num2:  <input type="text" id="num2" ><br/>
<p></p>
<button type="button" id="btn1" >+</button>
<button type="button" id="btn2" >-</button>
<button type="button" id="btn3" >*</button>
<button type="button" id="btn4" >/</button>
<div id="result"></div>
</body>
</html>
<script>
$(()=>{
	for(i=1;i<=4;i++){
		$("#btn"+i).click(calc)
	}
})

function calc(event){
	let num1 = $("#num1").val();
	let num2 = $("#num2").val();
	var oper = event.target.id;
	$.ajax({
		url:"jQueryAjaxCalcResult.jsp",
		dataType:"json", //파싱 필요 없다
		data:{num1:num1, num2:num2, oper:oper}//수신시 데이터의 형
		}
	)
	.done(
		(result)=>{
			if(result.status == "success"){
				$("#result").html(result.value);
			} else {
				$("#result").html("error");
			}
			
		}
	)
	.fail( (jqXhr, error)=>{
		console.log(error);
	})
}
</script>