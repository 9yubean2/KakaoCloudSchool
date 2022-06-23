<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("====Request Success====");
String name = request.getParameter("name");
String mobile = request.getParameter("mobile");
String email = request.getParameter("email");
%>
<%=name%><br/>
<%=mobile%><br/>
<%=email%><br/>