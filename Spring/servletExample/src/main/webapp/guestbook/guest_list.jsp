<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import = "com.dia.control.guestbook.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	<form name="form">
		<input type="hidden" name="cmd" id="cmd" value/>
		<%
	
		List<GuestbookDTO> datalist = (List<GuestbookDTO>)request.getAttribute("datalist");
		%>
		<table>
		<%
		for(int i=0;i<datalist.size();i++){
			GuestbookDTO dto = datalist.get(i); 
		%>
			<tr>
				<td><%= dto.getId() %></td>
				<td><a href="<%=request.getContextPath() %>/gbc?cmd=view&id=<%=dto.getId()%>">
				<%=dto.getTitle() %></a></td>
			
				<td><%= dto.getWriter() %></td>
				<td><%= dto.getWdate() %></td>
				<td><%= dto.getHit() %></td>
			</tr>
		<%} %>
		</table>
	</form>
	<button id="btnWrite" type="button"> 작성 </button>

</body>
</html>
<script>
window.onload = function() {
	document.getElementById("btnWrite").addEventListener("click",function(){
		var frm = document.form;
		frm.action = "/servletExample/gbc";
		frm.cmd.value="write";
		frm.method = "post";
		frm.submit();
	})
}
</script>