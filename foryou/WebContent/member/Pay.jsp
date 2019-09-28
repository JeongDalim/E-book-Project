<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
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
	/* function okey() {
		//구독값이 1일경우 무통장입금 - 무통장입금 따로 대기해야함..
		var gudok = document.getElementById('gudok').value;
		window.opener.document.getElementById('gudok').value = gudok;
		alert("결제가 완료 되었습니다. '다음'버튼을 눌러주세요.");
		self.close();
	} */
	function cardsend() {
		if (card.cardnum.value == "") {
			alert("Please enter the card number.");
			return;
		}
		if (card.cvc.value == "") {
			alert("Please enter the CVC number");
			return;
		}

		var cardgudok = document.getElementById('cardgudok').value;
		window.opener.document.getElementById('gudok').value = cardgudok;
		
		var cardnum = document.getElementById('cardnum').value;
		window.opener.document.getElementById('card').value = cardnum;
		
		var cvc = document.getElementById('cvc').value;
		window.opener.document.getElementById('cvc').value = cvc;
		
		alert("Payment information has been registered.");
		self.close();
	}
	function banksend() {
		if (form.bank.value == "") {
			alert("Please enter your account number.");
			return;
		}
		if (form.bankpw.value == "") {
			alert("Please enter your password");
			return;
		}
		var bankgudok = document.getElementById('bankgudok').value;
		window.opener.document.getElementById('gudok').value = bankgudok;
		
		var bank = document.getElementById('bank').value;
		window.opener.document.getElementById('bank').value = bank;
		
		var bankpw = document.getElementById('bankpw').value;
		window.opener.document.getElementById('bankpw').value = bankpw;
		
		alert("Payment information has been registered.");
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
				the Card <input type="radio" name="subdate" id="subdate2" value="2"
				onClick="onoff()">register the Account
			</td>
	</table>
	<br>
	<br>


	<div id="1" style="display: none">
		<form name="card" method="post">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="cardnum" name="cardnum"
						placeholder="please enter your card number." maxlength="20"></td>
				</tr>
				<tr>
					<td><input type="text" id="cvc" name="cvc"
						placeholder="Please enter your CVC number." class="int"
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