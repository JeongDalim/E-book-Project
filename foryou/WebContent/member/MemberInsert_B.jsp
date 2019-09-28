<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 회원 등록</title>
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script type="text/javascript">
   var xhr;
   function createXhr() {
      if (window.ActiveXObject) {
         xhr = new ActiveXObject("Microsoft.XMLHTTP");
      } else {
         xhr = new XMLHttpRequest();
      }
   }

   function idcheck() {
      var userid = document.getElementById("userid").value;
      var regType1 = /^[A-Za-z0-9+]*$/;
      if (userid.length < 6) {

         document.getElementById("idcheckLayer").innerHTML = "<font color=red> The id should have minimum 6 characters.</font>";
         return false;
      } else if (!regType1.test(userid)) {
         document.getElementById("idcheckLayer").innerHTML = "<font color=red>The id should have alphanumeric characters</font>";
         return false;

      } else {
         var queryString = "cmd=Pid_check&userid=" + userid;

         createXhr();
         xhr.onreadystatechange = callback;
         xhr.open("POST", "Member", true);
         xhr.setRequestHeader("Content-Type",
               "application/x-www-form-urlencoded");
         xhr.send(queryString);
      }

   }

   function callback() {
      if (xhr.readyState == 4) {
         if (xhr.status == 200) {
            var resTxt = xhr.responseText;
            document.getElementById("idcheckLayer").innerHTML = resTxt;
         } else {
            alert("Fail.\n" + xhr.status);
         }
      }
   }
</script>

<!--  패스워드 처리  -->
<script type="text/javascript">
   function checkPassword(pw, userid) {

      if (!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(pw)) {
         document.getElementById("pw1checkLayer").innerHTML = "<font color=red>A password must contain a combination of numbers, characters, and special characters.</font>";
         form.pw.focus();
         return false;
      }

      var checkNumber = pw.search(/[0-9]/g);
      var checkEnglish = pw.search(/[a-z]/ig);
      if (checkNumber < 0 || checkEnglish < 0) {
         document.getElementById("pw1checkLayer").innerHTML = "<font color=red>The passowrd should have alphanumeric characters.</font>";
         form.pw.focus();
         return false;
      }
      if (/(\w)\1\1\1/.test(pw)) {
         document.getElementById("pw1checkLayer").innerHTML = "<font color=red>Can not be used more than 4 times the same character.</font>";
         form.pw.focus();
         return false;
      }

      if (pw.search(userid) > -1) {
         document.getElementById("pw1checkLayer").innerHTML = "<font color=red>Password includes your id. do not use it</font>";
         form.pw.focus();
         return false;
      }

      document.getElementById("pw1checkLayer").innerHTML = "You can use it.";

      return true;
   }

   function checkPwd() {

      var pw = document.getElementById("pw").value;
      var pw2 = document.getElementById("pw2").value;
      if (pw != pw2) {
         document.getElementById("pwcheckLayer").innerHTML = "<font color=red>Password do not macth.</font>";
      } else {
         document.getElementById("pwcheckLayer").innerHTML = "You can use it.";
      }
   }

   function chkValidEmail() {

      var email = document.getElementById("email").value;

      var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
      if (exptext.test(email) == false) {

         document.getElementById("EmailcheckLayer").innerHTML = "<font color=red>The email address is formatted incorrectly.</font>";
         document.form.email.focus();
         return false;
      } else {
         document.getElementById("EmailcheckLayer").innerHTML = "You can use it.";
         checkEmail();

      }
   }

   function checkEmail() {

      var email = document.getElementById("email").value;

      var queryString = "cmd=Pemail_check&email=" + email;

      createXhr();
      xhr.onreadystatechange = callback2;
      xhr.open("POST", "Member", true);
      xhr.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded");
      xhr.send(queryString);

   }

   function callback2() {
      if (xhr.readyState == 4) {
         if (xhr.status == 200) {
            var resTxt = xhr.responseText;

            document.getElementById("EmailcheckLayer").innerHTML = resTxt;
         } else {
            alert("Failed \n" + xhr.status);
         }
      }
   }

   function CheckName() {

      var name = document.getElementById("name").value;

      if (name.length < 2) {
         document.getElementById("NamecheckLayer").innerHTML = "<font color=red>The name should have minimum 2 characters.</font>";
         document.form.name.focus();
         return false;

      } else {
         document.getElementById("NamecheckLayer").innerHTML = "You can use it.";

      }
   }

   function CheckTel() {

      var tel = document.getElementById("tel").value;

      if (!isCellPhone(tel)) {
         document.getElementById("TelcheckLayer").innerHTML = "<font color=red>The tel number address is formatted incorrectly.</font>";
         return false;
      } else {
         document.getElementById("TelcheckLayer").innerHTML = "You can use it.";
         return true;
      }

   }

   function isCellPhone(p) {

      p = p.split('-').join('');

      var regPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;

      return regPhone.test(p);

   }
</script>

<script>
   function send() {
      if (form.userid.value == "") {
         alert("Please enter the id.");
         form.userid.focus();
         return;
      }
      if (form.pw.value == "") {
         alert("Please enter the password.");
         form.pw.focus();
         return;
      }
      if (form.pw2.value == "") {
         alert("Please enter the password check.");
         form.pw2.focus();
         return;
      }
      if (form.pw.value != form.pw2.value) {
         alert("Password do not match.");
         form.pw.focus();
         return;
      }
      if (form.name.value == "") {
         alert("Please enter the name.");
         form.name.focus();
         return;
      }
      if (form.email.value == "") {
         alert("Please enter the email.");
         form.email.focus();
         return;
      }
      if (form.tel.value == "") {
         alert("Please enter the tel number.");
         form.tel.focus();
         return;
      }
      if (form.telcheck.value == "") {
         alert("Please enter the authorization.");
         return;
      } else if (form.telcheck.value != form.randomStr.value) {
         alert("authorization do not match.");
         return;
      }
      if (form.bno.value == "") {
         alert("Please enter corporate registration number.");
         form.bno.focus();
         return;
      }
      if (form.bfile.value == "") {
         alert("Pleas upload corporate registration number.");
         return;
      }
      form.action = "Member?cmd=insert3_B";
      form.target = "_self";
      form.submit();
   }
   function telchecksend() {
      var win = window.open("about:blank", "PopupWin", "width=1 ,height=1");
      form.action = 'Sms?cmd=ptest';
      form.target = "PopupWin";
      form.method = "post";
      form.submit();
   }
</script>
</head>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<div class="login_logo">FOR YOU</div>
	<div class="login_img">
		<table>
			<tr>
				<td><img src="member/img/insert2.png" /></td>
			</tr>
		</table>
	</div>
	<form name="form" method="post" enctype="multipart/form-data">
		<input type="hidden" name="randomStr" value="">
		<table class="Login_tab_M">
			<tr>
				<td><input type="text" id="userid" name="userid" accesskey="L"
					placeholder="id" class="int" maxlength="41" value=""
					onkeyup="idcheck()"> <span id="idcheckLayer"></span></td>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="password" id="pw" name="pw"
					accesskey="L" placeholder="Password" class="int" maxlength="41"
					value="" onkeyup="checkPassword(form.pw.value,form.userid.value)">
					<span id="pw1checkLayer"></span></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="password" id="pw2" name="pw2"
					accesskey="L" placeholder="Password Check" class="int"
					maxlength="41" value="" onkeyup="checkPwd()"><span
					id="pwcheckLayer"></span></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="text" id="name" name="name"
					accesskey="L" placeholder="Name" class="int" maxlength="41"
					value="" onkeyup="CheckName()"> <span id="NamecheckLayer"></span></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="text" id="email" name="email"
					accesskey="L" placeholder="Email" class="int" maxlength="41"
					value="" onkeyup="chkValidEmail()"> <span
					id="EmailcheckLayer"></span></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="text" id="tel" name="tel"
					accesskey="L" placeholder="Tel number" class="int" maxlength="41"
					value="" onkeyup="CheckTel()"><span id="TelcheckLayer"></span></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="text" id="id" name="telcheck"
					accesskey="L" placeholder="authorization" class="int"
					maxlength="41" value=""></td>
			</tr>
			<tr>
				<td><input type="button" value="Send authorization"
					onclick="telchecksend()"></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="text" id="id" name="bno"
					accesskey="L"
					placeholder="corporate registration number)000-00-00000"
					class="int" maxlength="41" value=""></td>
			</tr>
			<tr class="Login_tab_M_con">
				<td colspan="2"><input type="file" height="300px" name="bfile"></td>
			</tr>
		</table>
	</form>
	<div class="Login_button2">
		<table>
			<tr>
				<td><input type="button" value="Next" onclick="send()"></td>
			</tr>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>