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
   function mmodify(){
	   var win = window.open("Member?cmd=pwcheck&id=${vo.getId()}&view=modi&agree=${agree}", "PopupWin",
		"width=450 ,height=350");
   }
   function mdelete(){
	   var win = window.open("Member?cmd=pwcheck&id=${vo.getId()}&view=del&agree=${agree}", "PopupWin",
		"width=450 ,height=350");
   }
   function home(){
	   location.href="start.jsp";
   }
</script>
<body>
	<form name="form" method="post">
		<input type="hidden" name="idx" value="${vo.getIdx() }">
		<div class="login_logo" onclick="home()">FOR YOU</div>
		<div class="Insert5_check">
			<table>
				<tr>
					<td>나의 정보</td>
				</tr>
			</table>
		</div>
		<table class="Login_tab_M">
			<tr class="Login_tab_sub">
				<td>아이디</td>
				<td><input type="text" id="id" name="id" maxlength="41"
					value="${vo.getId() }" readonly></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>이름</td>
				<td><input type="text" id="name" name="name" class="int"
					maxlength="41" value="${vo.getName() }" readonly></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>이메일</td>
				<td><input type="text" id="email" name="email" class="int"
					maxlength="41" value="${vo.getEmail() }" readonly></td>
			</tr>
			<tr class="Login_tab_sub">
				<td>전화번호</td>
				<td><input type="text" id="tel" name="tel" class="int"
					maxlength="41" value="${vo.getTel() }" readonly></td>
			</tr>
			<c:if test="${empty agree}">
				<tr class="Login_tab_sub">
					<td>관심장르</td>
					<td><input type="text" id="tel" name="genre" class="int"
						maxlength="41" value="${vo.getGenre() }" readonly></td>
				</tr>
				<c:if test="${vo.getGubun()!='cust' }">
					<tr class="Login_tab_sub">
						<td>구독신청일</td>
						<td><input type="text" id="tel" name="sub" class="int"
							maxlength="41" value="${vo.getSubdate().substring(0,10) }"
							readonly></td>
					</tr>
					<tr class="Login_tab_sub">
						<td>구독잔여일</td>
						<td><input type="text" id="tel" name="exday" class="int"
							maxlength="41" value="${diffday } 일" readonly></td>
					</tr>
				</c:if>
				<tr class="Login_tab_sub">
					<td>구독상태</td>
					<td><c:if test="${vo.getGubun() == 'subcust' }">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="Subscriber" readonly>
						</c:if> <c:if test="${vo.getGubun() == 'cust'}">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="Customer" readonly>
						</c:if> <c:if test="${vo.getGubun() == 'subcancel' }">
							<input type="text" id="name" name="gubun" class="int"
								maxlength="41" value="unsubscribed state" readonly>
						</c:if>
				</tr>
			</c:if>
			<c:if test="${not empty agree }">
				<tr class="Login_tab_sub">
					<td>sorting</td>
					<td><input type="text" id="name" name="gudok" class="int"
						maxlength="41" value="business" readonly></td>
				</tr>
			</c:if>
		</table>
		<div class="Login_button2">
			<table>
				<tr>
					<td><input type="button" value="modify" onclick="mmodify()"></td>
					<td class="Login_button3"><input type="button"
						value="membership withdrawal" onclick="mdelete()"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>