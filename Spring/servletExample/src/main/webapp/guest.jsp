<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GUEST</h1>
	<%
		//getAttribute 반환값이 Object 타입
		//in Java) 모든 Class는 Object로 부터 상속받는다.
		String username = (String)request.getAttribute("username");
		int userage = (Integer)request.getAttribute("userage"); //refer class
		String userphone = (String)request.getAttribute("userphone");
		
		out.println("name: "+ username + "<br/>");
		out.println("age: "+ userage + "<br/>");
		out.println("phone: "+ userphone + "<br/>");
	%>
</body>
</html>