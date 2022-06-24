<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");
String username = request.getParameter("username");
String useremail = request.getParameter("useremail");
String userphone = request.getParameter("userphone");
String useraddr = request.getParameter("useraddr");
//System.out.println(result);
%>
<%=userid %><br/>
<%=userpw %><br/>
<%=username %><br/>
<%=useremail %><br/>
<%=userphone %><br/>
<%=useraddr %><br/>



