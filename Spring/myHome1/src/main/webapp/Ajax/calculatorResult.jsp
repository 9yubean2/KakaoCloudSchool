<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
String oper = request.getParameter("oper");
int result = 0;
if (oper.equals("btn1")){
	result = num1+num2;
} else if(oper.equals("btn2")){
	result = num1-num2;
} else if(oper.equals("btn3")){
	result = num1*num2;
} else
	result = num1/num2;


%>

{"status":"success","value":<%=result%>}