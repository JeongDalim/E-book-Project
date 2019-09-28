<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구독결제</title>
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
		//alert("ddd");
		if (card.cardnum.value == "") {
			alert("please enter the card number.");
			return;
		}
		if (card.cvc.value == "") {
			alert("please enter the cvc number.");
			return;
		}
		card.action="Member?cmd=MemberSubscriptPayInsert";
		card.submit();
		alert("You have subscribed to the payment information.");
		window.opener.location.href="Member?cmd=logout";
		self.close();
	}
	function banksend() {
		if (form.bank.value == "") {
			alert("Please enter the account number.");
			return;
		}
		if (form.bankpw.value == "") {
			alert("please enter the password.");
			return;
		}
		form.action="Member?cmd=MemberSubscriptPayInsert";
		form.submit();
		alert("You have subscribed to the payment information.");
		window.opener.location.href="Member?cmd=logout";
		self.close();
	}
</script>
</head>
<body>
	<div class="login_logo_P">FOR YOU</div>
	<div class="pay_title">
		<h3>Payment</h3>
	</div>
	<table class="Login_tab_P">
		<tr>
			<td class="Login_tab_sub">&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;Subscription
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
				name="subdate" id="subdate1" value="1" onClick="onoff()">register
				the Card <input type="radio" name="subdate" id="subdate2" value="2"
				onClick="onoff()">register the account
			</td>
	</table>
	<br>
	<br>


	<div id="1" style="display: none">
		<form name="card" method="post">
			<input type="hidden" name="pay" value="card"> <input
				type="hidden" name="idx" value="${idx }">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="cardnum" name="cardnum"
						placeholder="Please enter your card number." maxlength="20"></td>
				</tr>
				<tr>
					<td><input type="text" id="cvc" name="cvc"
						placeholder="Please enter your cvc number." class="int"
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
		<form name="form" method="post"
			action="Member?cmd=MemberPayInsert&pay=bank">
			<input type="hidden" name="pay" value="bank"> <input
				type="hidden" name="idx" value="${idx }">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="bank" name="bank"
						placeholder="Please enter your account number.." maxlength="20"></td>
				</tr>
				<tr>
					<td><input type="text" name="bankpw" id="bankpw"
						placeholder="please two-letter enter the front of your passwords."
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