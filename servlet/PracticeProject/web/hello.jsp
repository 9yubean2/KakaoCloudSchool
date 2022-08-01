<%--
  Created by IntelliJ IDEA.
  User: Dia
  Date: 2022/07/26
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.ArrayList" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");
    %>
    이것은 소리없는 아우성!<br><br>
    <h1>Hello <%=name%>!</h1>
</body>
</html>
