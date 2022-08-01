<%@ page import="member.vo.Member" %>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="member.vo.Member"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    Member result = (Member) request.getAttribute("member");
    String name = result.getName();
%>
<h1>Hello <%=name%>!!</h1>
</body>
</html>
