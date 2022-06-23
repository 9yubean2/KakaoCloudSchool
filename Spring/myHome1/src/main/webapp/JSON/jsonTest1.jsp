<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%
JSONObject jo = new JSONObject();
//JSONObject -사용법이 Hash와 유사:put(key:value)
jo.put("result","success");
jo.put("value",100);
out.println(jo);
%>