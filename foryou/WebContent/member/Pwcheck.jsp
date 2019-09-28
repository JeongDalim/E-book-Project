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
<%
	String alert = "";
	if (request.getAttribute("alert") != null) {
		alert = (String) request.getAttribute("alert");
	}
	if (alert.equals("1")) {
%>
<script>
	if ('${view=="modi"}') {
		opener.document.form.method = "post";
		opener.document.form.action = "Member?cmd=membermodify&session=${session}&agree=${agree}";
	} else if ('${view== "del"}') {
		var yesno = confirm("Are you sure you want to withdraw yours membership");
		if (yesno == true) {
			opener.document.form.method = "post";
			opener.document.form.action = "Member?cmd=memberdelete&session=${session}&agree=${agree}";
		}
	}
	opener.document.form.submit();
	self.close();
</script>
<%
	} else if (alert.equals("-1")) {
%>
<script>
	alert("Password do not match");
</script>
<%
	}
%>
<script>
	function pwcheck() {
		if (form.pw.value == "") {
			alert("Please enter the password.");
			form.pw.focus();
			return;
		}
		form.action = "Member?cmd=pwcheckpro&session=${session}&agree=${agree}";
		form.submit();
	}
</script>
<body>
	<form name="form" method="post">
		<input type="hidden" name="pass" value="${pw }"> <input
			type="hidden" name="id" value="${id }"> <input type="hidden"
			name="view" value="${view }"> <input type="hidden"
			name="agree" value="${agree }"> <input type="hidden"
			name="session" value="${session }">
		<div class="Insert5_check">
			<table>
				<tr>
					<td>Password Check</td>
				</tr>
			</table>
		</div>
		<table class="Login_tab_S">
			<tr>
				<td class="raditd"><b>${id }<br> Enter the Your
						password.
				</b></td>
			</tr>
			<tr>
				<td><input type="password" id="pw" name="pw" class="radi_text"
					placeholder="Password" value=""></td>
			</tr>
		</table>
		<div class="Login_button">
			<table>
				<tr>
					<td><input type="button" value="send"
						onclick="javascript:pwcheck()"></td>
				</tr>
			</table>
		</div>
		<div class="topmenu_line"></div>
	</form>
</body>
</html>