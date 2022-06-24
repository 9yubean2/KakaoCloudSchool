<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");

if(userid.equals("test") && userpw.equals("1234")){
	
%>
{"status":"success"}
<%}else{%>
{"status":"fail"}
<%}%>