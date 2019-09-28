<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script type="text/javascript">
	function payok(){
		form.action="Member?cmd=MemberSubscriptPayUpdatePro";
		form.submit();
		window.opener.location.href="Member?cmd=logout";
		self.close();
	}
	function payupdate() {
		form.action="Member?cmd=MemberSubscriptPayUpdate";
		form.submit();
	}
</script>
</head>
<body>
	<div class="login_logo_P">FOR YOU</div>
	<div class="pay_title">
		<h3>내 결제 정보</h3>
	</div>
	<div>
		<form name="form" method="post">
			<input type="hidden" name="idx" value="${idx }">
			<table class="Login_tab_P">
				<tr>
					<c:if test="${not vo.card.equals('0') }">
						<td>My card<br>
						<input type="text" id="cardnum" name="cardnum"
							placeholder="${card }" maxlength="20"></td>
					</c:if>
					<c:if test="${not vo.bank.equals('0') }">
						<td>My account<br>
						<input type="text" id="bank" name="bank" placeholder="${bank }"
							maxlength="20"></td>
					</c:if>
				</tr>
			</table>
		</form>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a href="#" onClick="payok()">Go payment</a></td>
				</tr>
			</table>
		</div>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a href="#" onClick="payupdate()">New enrollment</a></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="Login_B_P">
		<img src="Home/pics/foryoulogo.png" />
	</div>
</body>

</html>