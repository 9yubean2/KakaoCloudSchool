<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <c:if test="${count>0}">
	크다<br/><br/>
</c:if>
<c:if test="${count<0}">
	작다<br/><br/>
</c:if>

<c:forEach var="data" items="${list}">
	${data} <br/><br/>
</c:forEach>


<c:forEach var="i" begin="1" end="10" step="2">
	${i} <br/><br/>
</c:forEach> --%>

<c:set var="name" value="java"/>

<%--  <c:redirect url="/member/loginForm"/> --%>

<fmt:formatDate value="${day}" type="date"/><br/>
<fmt:formatDate value="${day}" type="time"/><br/>
<fmt:formatDate value="${day}" type="both"/><br/>

<%-- <jsp:include page="/member/loginForm"/> --%>

<%-- <c:import var="form" url="/member/loginForm"/>
${form}${form} --%>
