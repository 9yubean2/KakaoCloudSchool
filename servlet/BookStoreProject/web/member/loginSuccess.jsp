<%@ page import="member.vo.Member" %><%--
  Created by IntelliJ IDEA.
  User: Dia
  Date: 2022/07/26
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
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
