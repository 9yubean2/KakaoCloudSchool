<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ID:<input type="text" name="userid" id="userid"> <br/>
	PW:<input type="text" name="userpw" id="userpw"> <br/>
	<button type="button" id="btnSend">SEND</button>
	<div id="result"></div>
</body>
</html>
<script>
window.onload = function(){
	document.getElementById("btnSend").addEventListener("click",loadData);
}

function loadData(){
	var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	//통신 중간중간 필드에 전달된 함수를 호출
	xhttp.onload = function(){
		console.log(this.responseText);
		document.getElementById("result").innerHTML = this.responseText;
	}
	let url="receiveTest2.jsp?userid="+document.getElementById("userid").value+"&userpw="+document.getElementById("userpw").value;
	xhttp.open("GET",url,true);
	xhttp.send();
}
</script>