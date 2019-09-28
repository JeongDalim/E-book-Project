<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="bookcart/css/font-awesome.min.css" rel="stylesheet">
<link href="bookcart/css/mystyle.css" rel="stylesheet">
<link href="bookcart/css/common.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check_all() {
		if (typeof (my_form.bookCart.length) == 'undefined') {
			my_form.bookCart.checked = true;
		} else {
			for (i = 0; i < my_form.bookCart.length; i++) {
				my_form.bookCart[i].checked = true;
			}
		}
	}
	function uncheck_all() {
		if (typeof (my_form.bookCart.length) == 'undefined') {
			my_form.bookCart.checked = false;
		} else {
			for (i = 0; i < my_form.bookCart.length; i++) {
				my_form.bookCart[i].checked = false;
			}
		}
	}

	function select_delete() {
		var sw = false;
		for (i = 0; i < my_form.bookCart.length; i++) {
			if (my_form.bookCart[i].checked) {
				sw = true;
			}
		}
		if (typeof (my_form.bookCart.length) == 'undefined') {
			my_form.bookCart.checked = true;
		}

		if (!sw) {
			alert("Please select at least one book");
			return;
		}
		if (confirm("Are you sure you want to delete seleted books")) {
			my_form.cmd.value = "delete";
			my_form.action = "BookCart";
			my_form.submit();
		}
	
	function select_rent() {
		var sw = false;
		for (i = 0; i < my_form.bookCart.length; i++) {
			if (my_form.bookCart[i].checked) {
				sw = true;
			}
		}
		if (typeof (my_form.bookCart.length) == 'undefined') {
			if (my_form.bookCart.checked) {
				sw = true;
			}
		}
		if (!sw) {
			alert("Please select at least one book.");
			return;
		}
		if (confirm("Are you sure you want to lent seleted books?")) {
			my_form.cmd.value = "rentDelete";
			my_form.action = "BookCart";
			my_form.submit();
		}
	}
	function select_rent_2() {
		var sw = false;
		for (i = 0; i < my_form.bookCart.length; i++) {
			if (my_form.bookCart[i].checked) {
				sw = true;
			}
		}
		if (!sw) {
			alert("Please select at least one book.");
			return;
		}
		if (confirm("Are you sure you want to lent seleted books?")) {
			var gsWin = window.open('about:blank', 'payviewer',
					'width=500,height=500');
			var frm = document.my_form;
			frm.cmd.value = "RDMemberPayCheck";
			frm.action = "Member";
			frm.target = "payviewer";
			frm.submit();
		}
		/* if (confirm("선택한 도서를 대여하시겠습니까?")) {
			my_form.cmd.value = "rentDelete";
			my_form.action = "BookCart";
			my_form.submit();
		} */
	}
	function delete_check(idx) {
		if (confirm("Are you sure you want to delete seleted books?")) {
			location.href = "BookCart?cmd=delete&idx=" + idx;
		}
	}
	function rent(idx) {
		if (confirm("Are you sure you want to lent seleted books?")) {
			location.href = "BookCart?cmd=rentDelete&idx=" + idx;
		}
	}
	function rent_2(idx) {
		if (confirm("Are you sure you want to lent seleted books?")) {
			window.open('Member?cmd=RDMemberPayCheck&idx=' + idx, 'PopupWin',
					'width=500 ,height=630');
		}
	}
</script>
</head>
<body>
	<jsp:include page="../include/topmenu_genre.jsp"></jsp:include>

	<span class="fa fa-cart-arrow-down fa-4x"
		style="color: gray; margin-left: 300px;"> Your Cart </span>
	<hr class="cart_line">
	<br>

	<div id="cart">
		<table class="basic" style="margin-left: 300px;">
			<tr bgcolor="#C8E3FF">

				<th scope="col">Cover</th>
				<th scope="col">Product-name</th>
				<th scope="col">Lent-cost</th>
				<th scope="col">&nbsp;</th>
			</tr>
			<c:if test="${empty myBookCart }">
				<tr align="center" class="good1">
					<td colspan="4"><h2 style="margin-top: 30px;">There are
							no book!</h2></td>
				</tr>
			</c:if>
			<c:set var="bookcnt" value="0" />
			<c:set var="bookprice" value="0" />
			<c:if test="${!empty myBookCart }">
				<form name="my_form" method="post">
					<input type="hidden" name="cmd" value="">
					<c:forEach var="book" items="${myBookCart}">
						<tr align="center" class="good1">
							<td><label class="check"><input type="checkbox"
									name="bookCart" value="${book.idx}"> <span
									class="checkmark"></span> </label><a href="#"> <img
									src="book/${book.fileName }" width="75" height="75" /></a></td>
							<td>${book.bookName }</td>
							<td>${book.price }won(korean)</td>
							<td><button type="button" title="삭제" class="btn_del"
									onClick="delete_check('${book.idx}')">Delete</button> <c:if
									test="${not empty gubun }">
									<button type="button" title="삭제" class="btn_del"
										onClick="rent('${book.idx}')">Lent</button>
								</c:if> <c:if test="${empty gubun }">
									<button type="button" title="삭제" class="btn_del"
										onClick="rent_2('${book.idx}')">Payment</button>
								</c:if></td>
						</tr>
						<c:set var="bookcnt" value="${bookcnt+1 }" />
						<c:set var="bookprice" value="${bookprice+book.price }" />
					</c:forEach>
				</form>
				<tr style="background-color: #fff;">
					<td></td>
					<td style="float: right;">
						<button type="button" class="btn_modify" onClick="select_delete()"
							style="background-color: #f8cdd7;">Delete that selected
							book</button>
					</td>
					<td style="float: right;"><button type="button"
							class="btn_modify" onClick="uncheck_all()"
							style="background-color: #f8cdd7;">Cancel that selected</button></td>

					<td style="float: right;"><button type="button"
							class="btn_modify" onClick="check_all()"
							style="background-color: #f8cdd7;">All select</button></td>
				</tr>
			</c:if>
		</table>

		<div class="cart_box">
			<table class="cart_table">

				<tr class="write_table_1">

					<td>&nbsp;<span class="fa fa-shopping-bag fa-1x"
						style="color: gray"> </span> &nbsp;<b>Total : ${bookcnt }개</b> <br>&nbsp;
						<br>&nbsp; <br>&nbsp;<font color="red"> Cost
							:${bookprice }</font></b> <br>&nbsp;
					</td>
				</tr>

				<tr class="write_table_2">
					<c:if test="${not empty gubun }">
						<td align="center"><button type="button" title="변경"
								class="btn_guip" onClick="select_rent()">Lent</button></td>
					</c:if>
					<c:if test="${empty gubun }">
						<td align="center"><button type="button" title="변경"
								class="btn_guip" onClick="select_rent_2()">Payment</button></td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="ad">
		<table>
			<tr>
				<td><img src="view/img/ad.png"
					onclick="javascript:window.open('Member?cmd=MemberSubscriptPayCheck', 'PopupWin',
					'width=410 ,height=630')"></td>
		</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>