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
<script>
	function mmodify() {
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
		if (form.agree.value == "") {
			var chk = document.getElementsByName("genre");
			var chk_num = 0;
			for (var i = 0; i < chk.length; i++) {
				if (chk[i].checked == true) {
					chk_num += 1;
				}
			}
			if (chk_num < 3) {
				alert("You must select at least three genres.");
				return;
			}
			form.action = "Member?cmd=membermodifypro";
			form.submit();
		} else {
			form.action = "Member?cmd=pmembermodifypro";
			form.submit();
		}
	}
	function modix() {
		form.action = "Member?cmd=memberview&session=${session }&agree=${agree}";
		form.submit();
	}
	function subcancel() {
		var yesno = confirm("Do you really want to cancel");
		if (yesno == true) {
			form.action = "Member?cmd=membersubcancel";
			form.submit();
		}
	}
	function subsub() {
		var win = window.open("Member?cmd=membersubpay", "PopupWin",
				"width=305 ,height=630");
	}
	function cansub() {
		form.action = "Member?cmd=membersubcancel";
		form.submit();
	}
	function hoem() {
		location.href = "start.jsp";
	}
</script>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<form name="form" method="post">
		<input type="hidden" name="idx" value="${vo.getIdx() }"> <input
			type="hidden" name="session" value="${session }"> <input
			type="hidden" name="agree" value="${agree }">
		<div class="login_logo" onclick="home()">FOR YOU</div>
		<div class="Insert5_check">
			<table>
				<tr>
					<td>modify my info</td>
				</tr>
			</table>
		</div>
		<table class="Login_tab_M">
			<tr class="Login_tab_sub">
				<td>Id</td>
				<td><input type="text" id="id" name="id" maxlength="41"
					value="${vo.getId() }" readonly></td>
			<tr class="Login_tab_sub">
				<td>Password</td>
				<td><input type="text" id="pw" name="pw" class="int"
					maxlength="41" value=""></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>Password check</td>
				<td><input type="text" id="pwcheck" name="pwcheck" class="int"
					maxlength="41" value=""></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>Name</td>
				<td><input type="text" id="name" name="name" class="int"
					maxlength="41" value="${vo.getName() }" readonly></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>Email</td>
				<td><input type="text" id="email" name="email" class="int"
					maxlength="41" value="${vo.getEmail() }"></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>Tel number</td>
				<td><input type="text" id="tel" name="tel" class="int"
					maxlength="41" value="${vo.getTel() }"></td>
			</tr>
			<c:if test="${empty agree}">
				<tr class="Login_tab_sub">
					<td>Genre</td>
					<td><input type="checkbox" name="genre" value="sf"
						<c:if test="${vo.getGenre().contains('sf') }">checked</c:if>>&nbsp;&nbsp;&nbsp;SF&nbsp;&nbsp;
						<input type="checkbox" name="genre" value="af"
						<c:if test="${vo.getGenre().contains('af') }">checked</c:if>>&nbsp;&nbsp;Chivalry&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="genre" value="humanities"
						<c:if test="${vo.getGenre().contains('humanities') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Humanity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="genre" value="economic"
						<c:if test="${vo.getGenre().contains('economic') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Economic&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="genre" value="romance"
						<c:if test="${vo.getGenre().contains('romance') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Romance<br>
						<input type="checkbox" name="genre" value="novel"
						<c:if test="${vo.getGenre().contains('novel') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Novel
						<input type="checkbox" name="genre" value="development"
						<c:if test="${vo.getGenre().contains('development') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Self-improvement
						<input type="checkbox" name="genre" value="health"
						<c:if test="${vo.getGenre().contains('health') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Health
						and Life <input type="checkbox" name="genre" value="finance"
						<c:if test="${vo.getGenre().contains('finance') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Finance&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="genre" value="travel"
						<c:if test="${vo.getGenre().contains('travel') }">checked</c:if>>&nbsp;&nbsp;&nbsp;Travel
					</td>
				</tr>

				<c:if test="${vo.getGubun() != 'cust' }">
					<tr class="Login_tab_sub">
						<td>subscribed date</td>
						<td><input type="text" id="tel" name="sub" class="int"
							maxlength="41" value="${vo.getSubdate().substring(0,10) }"
							readonly></td>
					</tr>
					<tr class="Login_tab_sub">
						<td>The number of days</td>
						<td><input type="text" id="tel" name="exday" class="int"
							maxlength="41" value="${diffday } 일" readonly></td>
					</tr>
				</c:if>
				<tr class="Login_tab_sub">
					<td>Subscribe state</td>
					<td><c:if test="${vo.getGubun() == 'subcust' }">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="Subscriber" readonly>
						</c:if> <c:if test="${vo.getGubun() == 'cust'}">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="Customer" readonly>
						</c:if> <c:if test="${vo.getGubun() == 'subcancel' }">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="unsubscribed state" readonly>
						</c:if> &nbsp; <c:if test="${vo.getGubun() == 'subcust'}">
							<input type="button" value="Cancle Subscriber"
								onclick="subcancel()">
						</c:if> <c:if test="${vo.getGubun() == 'cust'}">
							<input type="button" value="Subscribe" onclick="subsub()">
						</c:if> <c:if test="${vo.getGubun() == 'subcancel'}">
							<input type="button" value="Extend the Subscrbe date"
								onclick="cansub()">
						</c:if></td>
				</tr>
			</c:if>
		</table>
		<div class="Login_button2">
			<table>
				<tr>
					<td><input type="button" value="Modify" onclick="mmodify()"></td>
					<td class="Login_button3"><input type="button" value="cancle"
						onclick="modix()"></td>
				</tr>
			</table>
		</div>
	</form>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>