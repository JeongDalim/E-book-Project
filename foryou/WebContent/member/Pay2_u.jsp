<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script type="text/javascript">
	function onoff() {
		var chk = document.getElementsByName("subdate");
		for (var i = 0; i < chk.length; i++) {
			var dis = document.getElementById([ i + 1 ]);
			if (chk[i].checked == true) {
				dis.style.display = "block";
			} else {
				chk[i].checked = false;
				dis.style.display = "none";
			}
		}
	}
	function cardsend() {
		if (card.cardnum.value == "") {
			alert("Please enter the card number.");
			return;
		}
		if (card.cvc.value == "") {
			alert("Please enter the CVC number.");
			return;
		}
		card.action="Member?cmd=MemberPayUpdatePro";
		card.submit();
		alert("Payment information has been registered.");
		card.action="Rent?cmd=bookRent&idx=${idx}";
		card.submit();
		opener.window.location.reload();
		self.close();
	}
	function banksend() {
		if (form.bank.value == "") {
			alert("Please enter your account number.");
			return;
		}
		if (form.bankpw.value == "") {
			alert("Please enter your password.");
			return;
		}
		form.action="Member?cmd=MemberPayUpdatePro";
		form.submit();
		alert("Payment information has been registered.");
		form.action="Rent?cmd=bookRent&idx=${idx}";
		form.submit();
		opener.window.location.reload();
		self.close();
	}
</script>
</head>
<body>
	<div class="login_logo_P">FOR YOU</div>
	<div class="pay_title">
		<h3>Payment Page</h3>
	</div>
	<table class="Login_tab_P">
		<tr>
			<td class="Login_tab_sub">&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;Subscribe
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
				name="subdate" id="subdate1" value="1" onClick="onoff()">register
				the Card<input type="radio" name="subdate" id="subdate2" value="2"
				onClick="onoff()">register the Account
			</td>
	</table>
	<br>
	<br>


	<div id="1" style="display: none">
		<form name="card" method="post">
			<input type="hidden" name="pay" value="card">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="cardnum" name="cardnum"
						placeholder="Please enter your card number." maxlength="20"></td>
				</tr>
				<tr>
					<td><input type="text" id="cvc" name="cvc"
						placeholder="Please enter your CVC number" class="int"
						maxlength="41"></td>
				</tr>
			</table>
			<input type="hidden" id="cardgudok" name="cardgudok" value="2">
		</form>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a href="#" onClick="cardsend()">register the Card</a></td>
				</tr>
			</table>
		</div>
	</div>


	<div id="2" style="display: none">
		<form name="form" method="post">
			<input type="hidden" name="pay" value="bank">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="bank" name="bank"
						placeholder="Please enter your account number." maxlength="20"></td>
				</tr>
				<tr>
					<td><input type="text" name="bankpw" id="bankpw"
						placeholder="please two-letter enter the front of your password."
						maxlength="2"></td>
				</tr>
			</table>
			<input type="hidden" id="bankgudok" name="bankgudok" value="1">
		</form>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a href="#" onClick="banksend()">register the account</a></td>
				</tr>
			</table>
		</div>
	</div>



	<div class="Login_B_P">
		<img src="Home/pics/foryoulogo.png" />
	</div>
</body>

</html>