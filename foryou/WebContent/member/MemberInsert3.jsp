<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script>
	function send() {
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
		form.action = "Member?cmd=insert4";
		form.submit();
	}
</script>
</head>
<%@ include file="../include/topmenu.jsp"%>
<body>
	<div class="login_logo">FOR YOU</div>
	<div class="login_img">
		<table>
			<tr>
				<td><img src="member/img/insert3.png" /></td>
			</tr>
		</table>
	</div>
	<form name="form" method="post">
		<table class="Login_tab_M-3">
			<tr>
				<td><img src="member/img/sf.jpg" /></td>
				<td><img src="member/img/af.jpg" /></td>
				<td><img src="member/img/humanities.jpg" /></td>
				<td><img src="member/img/economic.jpg" /></td>
				<td><img src="member/img/romance.jpg" /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="genre" value="sf">&nbsp;&nbsp;&nbsp;SF</td>
				<td><input type="checkbox" name="genre" value="af">&nbsp;&nbsp;&nbsp;Chivalry</td>
				<td><input type="checkbox" name="genre" value="humanities">&nbsp;&nbsp;&nbsp;Humanity</td>
				<td><input type="checkbox" name="genre" value="economic">&nbsp;&nbsp;&nbsp;Economic</td>
				<td><input type="checkbox" name="genre" value="romance">&nbsp;&nbsp;&nbsp;Romance</td>
			</tr>
			<tr>
				<td><img src="member/img/novel.jpg" /></td>
				<td><img src="member/img/development.jpg" /></td>
				<td><img src="member/img/health.jpg" /></td>
				<td><img src="member/img/finance.jpg" /></td>
				<td><img src="member/img/travel.jpg" /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="genre" value="novel">&nbsp;&nbsp;&nbsp;Novel</td>
				<td><input type="checkbox" name="genre" value="development">&nbsp;&nbsp;&nbsp;Self-improvement</td>
				<td><input type="checkbox" name="genre" value="health">&nbsp;&nbsp;&nbsp;Health
					and Life</td>
				<td><input type="checkbox" name="genre" value="finance">&nbsp;&nbsp;&nbsp;Finance</td>
				<td><input type="checkbox" name="genre" value="travel">&nbsp;&nbsp;&nbsp;Travel</td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${id }"> <input
			type="hidden" name="pw" value="${pw }"> <input type="hidden"
			name="name" value="${name }"> <input type="hidden"
			name="email" value="${email }"> <input type="hidden"
			name="tel" value="${tel }"> <input type="hidden" name="gudok"
			value="${gudok }"> <input type="hidden" name="card"
			value="${card }"> <input type="hidden" name="cvc"
			value="${cvc }"> <input type="hidden" name="bank"
			value="${bank }"> <input type="hidden" name="bankpw"
			value="${bankpw }">
	</form>
	<div class="Login_button2">
		<table>
			<tr>
				<td><input type="button" value="Next" onClick="send()"></td>
			</tr>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>