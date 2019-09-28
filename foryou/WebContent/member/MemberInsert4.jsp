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
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<div class="login_logo">FOR YOU</div>
	<div class="login_img">
		<table>
			<tr>
				<td><img src="member/img/insert4.png" /></td>
			</tr>
		</table>
	</div>
	<table class="Insert4_check">
		<tr>
			<td><img src="member/img/check.png" /></td>
		</tr>
	</table>
	<table class="Login_tab_M-4">
		<tr>
			<td><div class="Insert4_name">&nbsp;</div></td>
			<td>You have successfully joined.</td>
		</tr>
		<tr>
			<td><div class="Insert4_name">${name }</div></td>
			<td>Welcome to for you</td>
		</tr>
		<tr>
			<td class="Insert3_line"></td>
		</tr>
	</table>
	<div class="Login_button2">
		<table>
			<tr>
				<td><a href="Home?cmd=Home"><input type="button"
						value="Go to Main"></a></td>
				<td class="Login_button3"><a href="Member?cmd=login"><input
						type="button" value="Login"></a></td>
			</tr>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>