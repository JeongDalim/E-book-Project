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
	<div class="Insert5_check">
		<table>
			<tr>
				<td>Join us</td>
			</tr>
		</table>
	</div>
	<div class="Login_button4">
		<table>
			<tr>
				<td><a href="Member?cmd=insert1&who=business"><input
						type="button" value="Business Join US"></a></td>

				<td class="Login_button5"><a
					href="Member?cmd=insert1&who=customer"><input type="button"
						value="Customer Join us"></a></td>
			</tr>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>