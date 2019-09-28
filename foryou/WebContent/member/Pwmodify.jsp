<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="member/css/Mem_style.css" rel="stylesheet" />
</head>
<style type="text/css">
a {
	text-decoration: none
}

.Login_tab_S .radi_s {
	font-size: 17px;
	width: 23px;
	height: 23px
}

.Login_tab_S .radi_text {
	font-size: 17px;
	width: 200px;
	height: 23px
}

.raditd {
	font-family: Arial;
	font-size: 15px;
	color: #757575;
	height: 60px;
}

.Login_C {
	width: 400px;
	margin: 0 auto;
}

.Login_C img {
	margin-left: 20px;
	width: 210px;
	height: 50px;
}

.Login_tab_S {
	margin: 0 auto;
	width: 300px;
	height: 200px;
	padding-bottom: 30px;
}

.Login_tab_S tr td {
	margin: 0 auto;
	width: 100%;
}
</style>
<c:if test="${not empty row }">
	<c:if test="${row!=0 }">
		<script>
			alert("${id}'s password Changed '");
			location.href="Member?cmd=login";
		</script>
	</c:if>
</c:if>
<script>
	function pwmodify(){	
		if(form.pw.value==""){
			alert("Please enter the new password.");
			form.pw.focus();
			return;
		}
		if(form.pwcheck.value==""){
			alert("Please enter the new password check.");
			form.pwcheck.focus();
			return;
		}else if(form.pw.value!=form.pwcheck.value){
			alert("Password do not match.");
			form.pwcheck.focus();
			return;
		}
		form.submit();
	}
</script>
<body>
	<form name="form" method="post" action="Member?cmd=pwmodify">
		<input type="hidden" name="idsea" value="${idsea }"> <input
			type="hidden" name="id" value="${id }">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="Member?cmd=pwsearch"><img src="member/img/pwsearch.JPG" /></a>
		</div>
		<table class="Login_tab_S">
			<tr>
				<td class="raditd"><b>${id }<br> Please Enter the new
						password
				</b></td>
			</tr>
			<tr>
				<td><input type="text" id="pw" name="pw" class="radi_text"
					placeholder="new password" value=""></td>
			</tr>
			<tr>
				<td><input type="text" id="pwcheck" name="pwcheck"
					class="radi_text" placeholder="new password check" value="">
				</td>
			</tr>
		</table>
		<div class="Login_button">
			<table>
				<tr>
					<td><input type="button" value="완료"
						onclick="javascript:pwmodify()"></td>
				</tr>
			</table>
		</div>
		<div class="topmenu_line"></div>
		<div class="Login_r">
			<a href="Member?cmd=idsearch">Look for id</a> | <a
				href="Member?cmd=pwsearch">Look for password</a> | <a
				href="Member?cmd=insert">Join us</a>
		</div>
		<div class="Login_B">
			<a href="start.jsp"><img src="Home/pics/foryoulogo.png" /></a>
		</div>
	</form>
</body>
</html>