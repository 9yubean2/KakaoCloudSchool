<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
JSONArray jsonArray = new JSONArray();
for(int i=1;i<=10;i++){
	JSONObject jo = new JSONObject();
	jo.put("id",i);
	jo.put("title","title"+i);
	jo.put("writer","writer"+i);
	jo.put("hit",100+i);
	
	jsonArray.put(jo);
}
JSONObject result = new JSONObject();

result.put("totalCount", 10);
result.put("data", jsonArray);

out.println(result);



%>