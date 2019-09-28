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
function confirmemail(emailconfirm_value, authNum){
    // 입력한 값이 없거나, 인증코드가 일지하지 않을 경우
   if(!emailconfirm_value || emailconfirm_value != authNum){
      alert("authorization do not match");
      emailconfirm_value="";
      s
    // 인증코드가 일치하는 경우
   }else if(emailconfirm_value==authNum){
      alert("verified");
      emailconfirm_value="";
      emailcheck.submit();
   }
}

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
<%
String email = request.getParameter("email");

// 위에서 작성한 java파일 객체 생성
EmailConfirm emailconfirm = new EmailConfirm();
String authNum=emailconfirm.connectEmail(email);
%>
<body>
	<form method="post" action="Member?cmd=gotopwmodify" name="emailcheck">
		<input type="hidden" name="id" value="${id}"> <input
			type="hidden" name="name" value="${name}"> <input
			type="hidden" name="idsea" value="${idsea }">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="Member?cmd=pwsearch"><img src="member/img/pwsearch.JPG" /></a>
		</div>
		<table style="margin: 0 auto;">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>

				<td><span style="color: #93b9e6; font-size: 20px;"><b>${name}</b></span>
					<span style="color: #93b9e6; font-size: 20px;"> <b>The
							authorization code will be sent to your ${email}</b></span> <span
					style="color: #757575"> <br>
				</span></td>

			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>


				<td align="center"><input type="text" name="emailconfirm">
				</td>

			</tr>

		</table>
		<div class="Login_button">
			<table>

				<tr>
					<td><input type="button" value="send"
						onclick="confirmemail(emailcheck.emailconfirm.value,
                    <%=authNum%>)"></td>
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