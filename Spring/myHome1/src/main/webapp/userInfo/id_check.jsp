<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

Boolean result;
if (id.equals("test")){
	result = false;
} else {
	result = true;
}

//System.out.println(result);

%>

{"check":<%=result%>}