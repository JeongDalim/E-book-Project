<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	width: 180px;
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
	function psend() {
		if (form.name.value == "") {
			alert("Please enter your name.");
			form.name.focus();
			return;
		}
		if (form.tel.value == "") {
			alert("Please enter your tel number.");
			form.tel.focus();
			return;
		}
		form.submit();
	}
	function esend() {
		if (form.name.value == "") {
			alert("Please enter your name.");
			form.name.focus();
			return;
		}
		if (form.email.value == "") {
			alert("Please enter your email.");
			form.email.focus();
			return;
		}
		form.submit();
	}
	function bsend() {
		if (form.bno.value == "") {
			alert("Please enter your corporate registration number");
			form.bno.focus();
			return;
		}
		if (form.eorp.value == "") {
			alert("Please enter your email or tel number.");
			form.eorp.focus();
			return;
		}
		form.submit();
	}
</script>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<form name="form" method="post" action="Member?cmd=idsearch_pro">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="Member?cmd=idsearch"><img src="member/img/idsearch.jpg" /></a>
		</div>
		<c:if test="${empty idsea}">
			<table class="Login_tab_S">
				<tr>
					<td class="raditd"><input type="radio" id="idsea" name="idsea"
						class="radi_s" value="tel"
						onclick="location.href='Member?cmd=idsearch&idsea=tel';">&nbsp;&nbsp;&nbsp;&nbsp;내
						The password find from your cell phone.</td>
				</tr>
				<tr>
					<td class="raditd"><input type="radio" id="idsea" name="idsea"
						class="radi_s" value="email"
						onclick="location.href='Member?cmd=idsearch&idsea=email';">&nbsp;&nbsp;&nbsp;&nbsp;내
						The password find from your email.</td>
				</tr>
				<tr>
					<td class="raditd"><input type="radio" id="idsea" name="idsea"
						class="radi_s" value="publisher"
						onclick="location.href='Member?cmd=idsearch&idsea=publisher';">&nbsp;&nbsp;&nbsp;&nbsp;Look
						for business id</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${not empty idsea}">
			<table class="Login_tab_S">
				<c:if test="${idsea=='tel' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="tel"
							onclick="location.href='Member?cmd=idsearch&idsea=tel';" checked>&nbsp;&nbsp;&nbsp;&nbsp;<b>The
								id find from your cell phone</b></td>
					</tr>
					<tr>
						<td><input type="text" id="name" name="name"
							class="radi_text" placeholder="name" value=""></td>
					</tr>
					<tr>
						<td><input type="text" id="tel" name="tel" class="radi_text"
							placeholder="tel" value=""> <input type="button"
							value="Next" onclick="javascript:psend()"></td>
					</tr>
				</c:if>
				<c:if test="${idsea!='tel' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="tel"
							onclick="location.href='Member?cmd=idsearch&idsea=tel';">&nbsp;&nbsp;&nbsp;&nbsp;The
							id find from your cell phone</td>
					</tr>
				</c:if>
				<c:if test="${idsea=='email' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="email"
							onclick="location.href='Member?cmd=idsearch&idsea=email';"
							checked>&nbsp;&nbsp;&nbsp;&nbsp;The id find from your
							email.</td>
					</tr>
					<tr>
						<td><input type="text" id="name" name="name"
							class="radi_text" placeholder="name" value=""></td>
					</tr>
					<tr>
						<td><input type="text" id="email" name="email"
							class="radi_text" placeholder="email" value=""> <input
							type="button" value="Next" onclick="javascript:esend()">
						</td>
					</tr>
				</c:if>
				<c:if test="${idsea!='email' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="email"
							onclick="location.href='Member?cmd=idsearch&idsea=email';">&nbsp;&nbsp;&nbsp;&nbsp;The
							id find from your email.</td>
					</tr>
				</c:if>
				<c:if test="${idsea=='publisher' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="publisher"
							onclick="location.href='Member?cmd=idsearch&idsea=publisher';"
							checked>&nbsp;&nbsp;&nbsp;&nbsp;Look for business id</td>
					</tr>
					<tr>
						<td><input type="text" id="bno" name="bno" class="radi_text"
							placeholder="corporate registration number" value=""></td>
					</tr>
					<tr>
						<td><input type="text" id="eorp" name="eorp"
							class="radi_text" placeholder="Email or Tel number" value="">
							<input type="button" value="Next" onclick="javascript:bsend()">
						</td>
					</tr>
				</c:if>
				<c:if test="${idsea!='publisher' }">
					<tr>
						<td class="raditd"><input type="radio" id="idsea"
							name="idsea" class="radi_s" value="publisher"
							onclick="location.href='Member?cmd=idsearch&idsea=publisher';">&nbsp;&nbsp;&nbsp;&nbsp;
							Look for business id</td>
					</tr>
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
	<jsp:include page="../include/footer.jsp" />
</body>
</html>