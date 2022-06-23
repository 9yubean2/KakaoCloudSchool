<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
window.onload = function(){
	/* document.getElementById("btnAdd").addEventListener("click",Add);
	document.getElementById("btnSub").addEventListener("click",Sub);
	document.getElementById("btnMul").addEventListener("click",Mul);
	document.getElementById("btnDiv").addEventListener("click",Div); */
	for(i=1;i<=4;i++){
		document.getElementById("btn"+i).addEventListener("click",calc);
	}
	
}
function calc(event){
	let num1 = document.getElementById("num1").value;
	let num2 = document.getElementById("num2").value;
	var oper = event.target.id;
	var url = "calculatorResult.jsp?num1="+num1+"&num2="+num2+"&oper="+oper;
	//console.log(url);
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		let data = JSON.parse(this.responseText);
		if (data.status == "success"){
			document.getElementById("result").innerHTML = data.value;
		} else
			document.getElementById("result").innerHTML = "ERROR";
		//document.getElementById("result").innerHTML = result;
	}
	xhttp.open("GET",url,true);
	xhttp.send();
}
/* 
function Add(){
	let num1 = parseInt(document.getElementById("num1").value);
	let num2 = parseInt(document.getElementById("num2").value);
	let result = num1 + num2;
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		document.getElementById("result").innerHTML = this.responseText;
	}
	let url="calculatorResult.jsp?num1="+document.getElementById("num1").value+"&num2="+document.getElementById("num2").value+"&result="+result;
	xhttp.open("GET",url,true);
	xhttp.send();
}
function Sub(){
	let num1 = parseInt(document.getElementById("num1").value);
	let num2 = parseInt(document.getElementById("num2").value);
	let result = num1 - num2;
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		document.getElementById("result").innerHTML = this.responseText;
	}
	let url="calculatorResult.jsp?num1="+document.getElementById("num1").value+"&num2="+document.getElementById("num2").value+"&result="+result;
	xhttp.open("GET",url,true);
	xhttp.send();
}

function Mul(){
	let num1 = parseInt(document.getElementById("num1").value);
	let num2 = parseInt(document.getElementById("num2").value);
	let result = num1 * num2;
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		document.getElementById("result").innerHTML = this.responseText;
	}
	let url="calculatorResult.jsp?num1="+document.getElementById("num1").value+"&num2="+document.getElementById("num2").value+"&result="+result;
	xhttp.open("GET",url,true);
	xhttp.send();
}
function Div(){
	let num1 = parseInt(document.getElementById("num1").value);
	let num2 = parseInt(document.getElementById("num2").value);
	let result = num1 / num2;
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		document.getElementById("result").innerHTML = this.responseText;
	}
	let url="calculatorResult.jsp?result="+result;
	xhttp.open("GET",url,true);
	xhttp.send();
} */
</script>