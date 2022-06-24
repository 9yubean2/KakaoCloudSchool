<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	<form name="form">
		제목 : <input type="text" name="title" id="title"><br/>
		작성자 : <input type="text" name="writer" id="writer"><br/>
		내용 : <textarea type="contents" name="contents" id="contents" rows="5" cols="80"></textarea><br/>
		<button type="button" id="btnSave">등록</button>
	</form>

	
</body>
</html>
<script>
window.onload=function(){
	document.getElementById("btnSave").addEventListener("click",function(){
		var frm = document.form;
		frm.action = "/servletExample/gbc?cmd=save";
		frm.method="post";
		frm.submit();
	})
}
</script>