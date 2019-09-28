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

.Login_tab input[type="text"], .Login_tab input[type="password"] {
	margin: 0 auto;
	width: 350px;
	height: 60px;
	border: 1px solid #ccc;
}

.raditd {
	font-family: Arial;
	font-size: 13.33px;
	color: #757575;
	width: 350px;
	height: 60px;
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
			alert("please enter your password.");
			form.pw.focus();
			return;
		}
		var radio = document.getElementsByName("business");
		for (var i = 0; i < radio.length; i++) {
			if (radio[i].checked == true) {
				var search = radio[i].value;
			}
		}
		if (search == null) {
			alert("Please check your business or customer.");
			return;
		}

		form.action = "Member?cmd=login_check";
		form.submit();
	}
</script>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<form name="form" method="post">
		<div class="login_logo">FOR YOU</div>
		<table class="Login_tab">
			<tr>
				<td><input type="text" id="id" name="id" accesskey="L"
					placeholder="id" class="int" maxlength="41" value=""></td>
			</tr>
			<tr>
				<td><input type="password" id="pw" name="pw" accesskey="L"
					placeholder="password" class="int" maxlength="41" value=""></td>
			</tr>
			<tr>
				<td class="raditd">Customer &nbsp;&nbsp;<input type="radio"
					id="business" name="business" class="radi" value="no">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Business &nbsp;&nbsp;<input type="radio" id="business"
					name="business" class="radi" value="yes">
				</td>
			</tr>
		</table>
		<div class="Login_button">
			<table>
				<tr>
					<td><input type="button" value="login" onclick="loginsend()"></td>
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