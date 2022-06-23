<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name:  <input type="text" id="name" name="name"><br/>
mobile:  <input type="text" id="mobile" name="mobile" ><br/>
email:  <input type="text" id="email" name="email" ><br/>
<p></p>
<button type="button" id="btnSend" >Send</button>

</body>
</html>
<script>
window.onload = function() {
	
	document.getElementById("btnSend").addEventListener("click",function(){
		let xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			console.log(this.responseText);
		}
		xhttp.open("POST", "receive2.jsp");
		xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		let tmp = "name=" + document.getElementById("name").value;
		tmp += "&mobile=" + document.getElementById("mobile").value;
		tmp += "&email=" + document.getElementById("email").value;
		console.log(tmp);
		xhttp.send(tmp);
	});
}
</script>