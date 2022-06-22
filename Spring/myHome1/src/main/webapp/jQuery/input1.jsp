<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<form id="form">
		<input type="hidden" name="seq" id="seq" value="1000"/><br/>
		<div id="result"></div>
		<button id="btnPress" type="button">Read Hidden Value</button><br/>
		<br/><br/>
		이름:<input type="text" name="username"/><br/>
		이메일:<input type="text" name="useremail"/><br/>
		<h1>Radio Button</h1>
		나이:<br/>
		<input type="radio" name="age" value="10">10대
		<input type="radio" name="age" value="20">20대
		<input type="radio" name="age" value="30">30대
		<input type="radio" name="age" value="40">40대
		<input type="radio" name="age" value="50">50대
		<br/>
		<h1>관심분야(checkbox)</h1>
		<input type="checkbox" name="interest" value="1">프로그래밍
		<input type="checkbox" name="interest" value="2">웹 프로그래밍
		<input type="checkbox" name="interest" value="3">앱 프로그래밍
		<input type="checkbox" name="interest" value="4">빅 데이터
		
		<h1>좋아하는 색(selected)</h1>
		<select name="color">
			<option value="">--선택하세요--</option>
			<option value="red">RED</option>
			<option value="blue">BLUE</option>
			<option value="yellow">YELLOW</option>
		</select>
		<br/>
		<textarea name="intro" cols="30" rows="10"></textarea>
	</form>
</body>
</html>
<script>
$(()=>{
	loadData();
	$("#btnPress").click(()=>{
		let username = $("input[type=text][name=username]").val();
		let useremail = $("input[type=text][name=useremail]").val();
		let userage = $("input[type=radio][name=age]:checked").val();
		let color = $("select[name=color]").val();
		let intro = $("textarea[name=intro]").val();
		//$("#result").html(`${username}, ${useremail}, ${userage}`);
		console.log(username);
		console.log(useremail);
		console.log(userage);
		let interest = "";
		$("input[type=checkbox][name=interest]:checked").each(function(){
			interest+=$(this).val()+" ";
		})
		console.log(interest);
		console.log(color);
		console.log(intro);
	});
});

function loadData(){
	$("input[type=text][name=username]").val("이규빈");
	$("input[type=text][name=useremail]").val("dlrbqls3024@naver.com");
	//radio버튼은 인덱스 대신에 eq(1), prop함수는 속성을 바꾼다.
	$("input[type=radio][name=age]").eq(1).prop("checked",true);
	$("input[type=checkbox][name=interest]").eq(1).prop("checked",true);
	$("select[name=color]").val("blue");
	$("textarea[name=intro]").val("자기소개서입니다.\n 저는 서울에서 태어나");
}
</script>