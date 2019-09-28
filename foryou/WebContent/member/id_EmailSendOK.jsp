<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="action.member.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script type="text/javascript">


</script>

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
</style>

<body>
	<form method="post" name="emailcheck2">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="start.jsp"><img src="member/img/idsearch.jpg" /></a>
		</div>
		<table style="margin: 0 auto;">
			<tr>

				<td><span style="color: #93b9e6; font-size: 20px;"><b>${name}</b></span>
					Your ID is <span style="color: #93b9e6; font-size: 20px;"><b>${id}</b></span>
					<span style="color: #757575"> </span></td>


			</tr>

		</table>
		<div class="Login_button">
			<table>
				<tr>
					<td><input type="button" value="Go to Login"
						onclick="location.href='Member?cmd=login'"></td>
				</tr>
			</table>
		</div>
		<div class="topmenu_line"></div>
		<div class="Login_r">
			<a href="Member?cmd=idsearch">look for id</a> | <a
				href="Member?cmd=pwsearch">look for password</a> | <a
				href="Member?cmd=insert">Join us</a>
		</div>
		<div class="Login_B">
			<a href="start.jsp"><img src="Home/pics/foryoulogo.png" /></a>
		</div>
	</form>
</body>
</html>