<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script type="text/javascript">
	function onoff(){
		var chk = document.getElementsByName("subdate");
		for(var i=0; i<chk.length; i++){
			var dis = document.getElementById([i+1]);
			if(chk[i].checked == true){
				dis.style.display = "block"; 
			} else {
				chk[i].checked = false;
				dis.style.display = "none";
			}
		}
	}
	function okey(){
		var id = window.opener.document.getElementById("id").value;
 		location.href="Member?cmd=membersubpaypro&id="+id;
 		alert("One payment was for the card.");
 		self.close();
	}
	function send(){
		if(card.card.value == ""){
			alert("please enter the card number.");
			return ;
		}
		if(card.cvc.value == ""){
			alert("please enter the cvc number.");
			return ;
		}
		
		var id = window.opener.document.getElementById("id").value;
		location.href="Member?cmd=membersubpaypro&id="+id;
		alert("One payment was for the card.");
		self.close();
	}
</script>
</head>
<body>
	<div class="login_logo_P">FOR YOU</div>
	<div class="Login_button_P">
		<table>
			<tr>
				<td>Payment</td>
			</tr>
		</table>
	</div>
	<table class="Login_tab_P">
		<tr>
			<td class="Login_tab_sub">&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;Subscription
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
				name="subdate" id="subdate1" value="1" onClick="onoff()">deposit
				without a bankbook<!-- 무통장입금 선택하면 밑에 입금안내가 뜨고 버튼 확인버튼 --> <input
				type="radio" name="subdate" id="subdate2" value="2"
				onClick="onoff()">Payment for Card<!-- 이거선택하면 카드번호입력칸 두개 결제하기버튼 -->
			</td>
	</table>
	<div id="1" style="display: none">
		<form name="card" method="post">
			<table class="Login_tab_P">
				<tr>
					<td><input type="text" id="id" name="card" accesskey="L"
						placeholder="Enter the card number" class="int" maxlength="41"
						value=""></td>
				</tr>
				<tr>
					<td><input type="text" id="id" name="cvc" accesskey="L"
						placeholder="Enther the cvc number." class="int" maxlength="41"
						value=""></td>
				</tr>
			</table>
			<input type="hidden" id="card" name="card" value="2">
		</form>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a onClick="send()">Go payment</a></td>
				</tr>
			</table>
		</div>
	</div>

	<div id="2" style="display: none">
		<form name="form" method="post">
			<table class="Login_tab_P">
				<tr>
					<td>deposit without a bankbook</td>
				</tr>
				<tr>
					<td>(주)ForYou NH 643078-52-055391<br></td>
				</tr>
				<tr>
					<td>Please deposit until 2019-10-03</td>
				</tr>
			</table>
			<input type="hidden" id="gudok" name="gudok" value="1">
		</form>
		<div class="Login_button_P2">
			<table>
				<tr>
					<td><a onClick="okey()">send</a></td>
				</tr>
			</table>
		</div>
	</div>



	<div class="Login_B_P">
		<img src="Home/pics/foryoulogo.png" />
	</div>
</body>

</html>