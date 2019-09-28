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

<script>
	function bsend(){
		if(form.bno.value==""){
			alert("Please enter corporate registration number.");
			form.bno.focus();
			return;
		}
		if(form.eorp.value==""){
			alert("Please enter tel or email.");
			form.eorp.focus();
			return;
		}
		form.action="Member?cmd=pwsearch_pro";
		form.submit();
	}
	function telcheck(){
		if(form.telchk.value==''){
			alert('Please enter the authorization.');
			return;
		}else if(form.telchk.value!=form.randomStr.value){
			alert('authorization do not match.');
			return;
		}
		form.action="Member?cmd=gotopwmodify";
		form.submit();
	}
</script>
<body>
	<form name="form" method="post">
		<input type="hidden" name="id" value="${id }"> <input
			type="hidden" name="randomStr" value="${randomStr }">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="Member?cmd=pwsearch"><img src="member/img/pwsearch.JPG" /></a>
		</div>
		<c:if test="${empty idsea}">
			<table class="Login_tab_S">
				<tr>
					<td class="raditd"><input type="radio" id="idsea" name="idsea"
						class="radi_s" value="publisher"
						onclick="location.href='Member?cmd=pwsearch1&idsea=publisher&id=${id}&business=yes';">&nbsp;&nbsp;&nbsp;&nbsp;verification
						as business code</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${not empty idsea}">
			<table class="Login_tab_S">
				<c:if test="${idsea=='publisher' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="publisher"
							onclick="location.href='Member?cmd=pwsearch1&idsea=publisher&id=${id}';"
							checked>&nbsp;&nbsp;&nbsp;&nbspverification;verification
							as business code</td>
					</tr>
					<c:if test="${empty row || row==0 }">
						<tr>
							<td><input type="text" id="bno" name="bno" class="radi_text"
								placeholder="corporate registration number" value=""></td>
						</tr>
						<tr>
							<td><input type="text" id="eorp" name="eorp"
								class="radi_text" placeholder="Email or Tel number" value="">
								<input type="button" value="next" onclick="javascript:bsend()">
							</td>
						</tr>
					</c:if>
					<c:if test="${not empty row&&row!=0 }">
						<tr>
							<td><input type="text" id="telchk" name="telchk"
								class="radi_text" placeholder="Authorization" value="">
								<input type="button" value="send"
								onclick="javascript:telcheck()"></td>
						</tr>
					</c:if>
				</c:if>
			</table>
		</c:if>
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