<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import = "com.dia.control.guestbook.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	<%GuestbookDTO data = (GuestbookDTO)request.getAttribute("data");%>
	<%= data.getId() %><br/>
	<%=data.getTitle() %><br/>
	<%= data.getWriter() %><br/>
	<%= data.getWdate() %><br/>
	<%= data.getHit() %><br/>
	

</body>
</html>