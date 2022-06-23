<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("Server");
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");
%>
<h1>your ID is <%=userid%> ,PW is <%=userpw%></h1>