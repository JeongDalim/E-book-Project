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
	function psend(){	
		if(form.id.value==""){
			alert("Please enter the password.");
			form.id.focus();
			return;
		}
		var radio = document.getElementsByName("business");
	      for(var i=0; i<radio.length; i++){
	         if(radio[i].checked == true){
	            var search = radio[i].value;
	         }
	      }
	      if(search == null){
	         alert("Please check the business or customer.");
	         return ;
	      }

		form.submit();
	}
</script>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<form name="form" method="post" action="Member?cmd=pwsearch1">
		<div class="login_logo">FOR YOU</div>
		<div class="Login_C">
			<a href="Member?cmd=pwsearch"><img src="member/img/pwsearch.JPG" /></a>
		</div>
		<table class="Login_tab_S">
			<tr>
				<td><input type="text" id="id" name="id" class="radi_text"
					placeholder="id" value=""></td>
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
					<td><input type="button" value="Next"
						onclick="javascript:psend()"></td>
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
	<%@ include file="../include/footer.jsp"%>
</body>
</html>