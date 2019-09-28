<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="member/css/Mem_style.css" rel="stylesheet" />
</head>
<style type="text/css">
a {
	text-decoration: none
}

.Login_tab .radi {
	font-size: 17px;
	width: 23px;
	height: 23px
}

.Login_tab input[type="text,password"] {
	margin: 0 auto;
	width: 350px;
	height: 60px;
	border: 0;
}

.raditd {
	font-family: Arial;
	font-size: 13.33px;
	color: #757575;
	width: 350px;
	height: 60px;
}

.Login_C {
	width: 400px;
	margin: 0 auto;
}

.Login_C img {
	margin-left: 20px;
	width: 180px;
	height: 50px;
}

.Login_button_io {
	margin: 0 auto;
	width: 100%;
}

.Login_button_io input {
	text-align: center;
	width: 180px;
	height: 60px;
	margin: 0 auto;
	background-color: #93b9e6;
	border: 0 solid;
	color: #fff;
}

.Login_button_io table {
	padding: 3% 0;
	width: 10%;
	margin: 0 auto;
}
</style>

<script>
	function loginsend() {
		if (form.id.value == "") {
			alert("Please enter your id.");
			form.id.focus();
			return;
		}
		if (form.pw.value == "") {
			alert("Please enter your password.");
			form.pw.focus();
			return;
		}
		if (form.business.value == "") {
			alert("Please check busines or customer.");
			return;
		}
		form.action = "Member?cmd=login_check";
		form.submit();
	}
</script>
<body>
	<form name="form" method="post">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="start.jsp"><img src="member/img/idsearch.jpg" /></a>
		</div>
		<table class="Login_tab">
			<tr>
				<td><span style="color: #93b9e6; font-size: 20px;"><b>${name }/${key }</b></span><span
					style="color: #757575"><br>Your id is </span></td>
			</tr>
			<tr>
				<td><input type="text" id="id" name="id" accesskey="L"
					placeholder="id" class="int" maxlength="41" value="${id }"></td>
			</tr>
		</table>
		<div class="Login_button_io">
			<table>
				<tr>
					<td><input type="button" value="back"
						onclick="location.href='Member?cmd=idsearch'"></td>
					<td><input type="button" value="go to Login"
						onclick="location.href='Member?cmd=login'"></td>
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
	<jsp:include page="../include/footer.jsp" />
</body>
</html>