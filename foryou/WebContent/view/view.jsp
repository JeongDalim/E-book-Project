<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="Home/css/mystyle.css" rel="stylesheet">
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="view/css/viewstyle.css" rel="stylesheet">
<script src='view/star/jquery.js' type="text/javascript"></script>
<script src='view/star/jquery.MetaData.js' type="text/javascript"
	language="javascript"></script>
<script src='view/star/jquery.rating.js' type="text/javascript"
	language="javascript"></script>
<link href='view/star/jquery.rating.css' type="text/css"
	rel="stylesheet" />
<link type="text/css" href="/@/js/jquery/ui/jquery.ui.css"
	rel="stylesheet" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Typ0e" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(".star_rating a").click(function() {
		$(this).parent().children("a").removeClass("on");
		$(this).addClass("on").prevAll("a").addClass("on");
		return false;
	});

	$(".star_rating_a a").click(function() {
		$(this).parent().children("a").removeClass("on");
		$(this).addClass("on").prevAll("a").addClass("on");
		return false;
	});
</script>
<script type="text/javascript" language="javascript">
	$(function() {
		$('#form2 :radio.star').rating({
			cancel : 'Cancel',
			cancelValue : '0'
		});
	});
</script>
<script>
	$(function() {
		$('#tab-Testing form').submit(
				function() {
					$('.test', this).html('');
					$('input', this).each(
							function() {
								if (this.checked)
									$('.test', this.form).append(
											'' + this.name + ': ' + this.value
													+ '<br/>');
							});
					return false;
				});
	});
</script>
<script>
	$(function() {
		$('.hover-star').rating({
			focus : function(value, link) {
				// 'this' is the hidden form element holding the current value
				// 'value' is the value selected
				// 'element' points to the link element that received the click.
				var tip = $('#hover-test');
				tip[0].data = tip[0].data || tip.html();
				tip.html(link.title || 'value: ' + value);
			},
			blur : function(value, link) {
				var tip = $('#hover-test');
				$('#hover-test').html(tip[0].data || '');
			}
		});
	});
</script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		var ex_show = $('.ex_show');
		var ex_hide = $('.ex_hide');
		var ex_box = $('.ex_box');
		ex_show.click(function() {
			ex_box.slideDown();
		});
		ex_hide.click(function() {
			ex_box.slideUp();
		});
	});

	function bad_check() { // 욕 필터링 , 스크립트 아이프레임도 필터링
		if (my2.contents.value == "") {
			alert("Please post Reiview. Thank you:) -ForYou-");
			my2.contents.focus();
			return;
		}
		var YokList = new Array('개새끼', '개색기', '개색끼', '개자식', '개년', '시발', '씨발',
				'씨팔', '씨부랄', '씨바랄', '씹창', '씹탱', '씨방세', '씨방새', '씨펄', '시펄', '십탱',
				'씨박', '썅', '쌍놈', '쌍넘', '싸가지', '쓰벌', '씁얼', '상넘이', '상놈의', '상놈이',
				'상놈을', '존나게', '존만한', '같은년', '넣을년', '버릴년', '바랄년', '미친년', '니기미',
				'니미씹', '니미씨', '니미럴', '니미랄', '호로', '후레아들', '호로새끼', '후레자식',
				'후래자식', '후라들년', '후라들넘', '병신');
		var Tmp;
		for (i = 0; i < YokList.length; i++) {
			Tmp = my2.contents.value.toLowerCase().indexOf(YokList[i]);
			if (Tmp >= 0) {
				alert('Please do not abuse and advertise this place');
				my2.contents.focus();
				return;
			}
		}
		my2.submit();
	}

	function payopen() {
		window.open('Member?cmd=MemberSubscriptPayCheck', 'PopupWin',
		'width=410 ,height=630');
	}
</script>
<script>
	function gotosort(csort) {
		form.action = "Book?cmd=view&idx=${book.idx}&csort=" + csort;
		form.submit();
	}

	function goodCheck(session) {
		if (session != "") {
			window
					.open(
							'Book?cmd=goodup&idx=${comments.idx}&member_id=${comments.member_id }',
							'PopupWin', 'width=100 ,height=100');
		}
	}

	function badCheck(session) {
		if (session != "") {
			window
					.open(

							'Book?cmd=goodup&idx=${comments.idx}&member_id=${comments.member_id }',
							'PopupWin', 'width=100 ,height=100');
		}
	}
</script>
<style type="text/css">
.ex_show {
	float: left;
	margin-right: 20px;
	cursor: pointer
}

.ex_hide {
	float: left;
	cursor: pointer
}

.ex_box {
	clear: both;
	float: left;
	width: 100px;
	height: 50px;
	background-color: yellow;
	border: 1px solid skyblue;
	border-radius: 10px;
}
</style>
</head>
<body>
	<c:if test="${empty agree }">
		<%@ include file="../include/Remote2.jsp"%>
	</c:if>
	<%@ include file="../include/topmenu_genre.jsp"%>
	<div class="view" style="margin-top: 80px;">
		<table class="view_main">
			<tr>
				<td></td>
				<td style="float: right; color: #808080;">${book.indate }</td>
			<tr>
			<tr>

				<td ROWSPAN="7"><img style="margin-right: 70px;"
					src="book/${book.fileName }"></td>
			</tr>
			<tr>
				<td style="font-size: 20px;"><h3>${book.bookName }</h3></td>
			</tr>

			<tr>
				<td><img src="view/img/qu.png"
					style="width: 25px; height: 25px; padding-right: 5px;">${book.bookPlot }<img
					src="view/img/qu2.png"
					style="width: 25px; height: 25px; padding-left: 5px;"></td>
			</tr>
			<tr>
				<td><p class="star_rating">

						<c:forEach var="i" begin="1" end="${book_score}" step="1">
							<p style="color: #f8cdd7; float: left; font-size: 30px;">★
						</c:forEach>
						<c:forEach var="i" begin="${book_score}" end="4" step="1">
							<p style="float: left; font-size: 30px;">☆
						</c:forEach>
					</p></td>
			</tr>
			<tr>
				<td style="font-size: 15px; color: #808080;"><B
					style="color: #000000; font-size: 18px;">${book.writer }&nbsp;</B>
					저</td>
			</tr>
			<tr>
				<td style="font-size: 15px; color: #808080;"><B
					style="color: #000000; font-size: 18px;">${book.company }&nbsp;</B>
					출판 | <B style="color: #000000; font-size: 18px;">${book.pdate }</B></td>
			</tr>
			<tr>
				<td style="font-size: 15px; color: #808080;"><B
					style="color: #ff0000; font-size: 18px;">${book.price } &nbsp;</B>
					원</td>
			</tr>
			<tr>
				<!-- 회원이 아닐 때 -->
				<c:if test="${empty session }">
					<td><a href="Book?cmd=preview&idx=${book.idx }"><input
							type="button" value="preView"></a></td>
					<td class="view_main_button"><input type="button" value="대여하기"
						onClick="javascript:alert('Please Login.'),location.href='Member?cmd=login'"></td>
				</c:if>
				<!-- 회원이고,내서재에 그 책이 없고 구독회원이 아닐 때 -->
				<c:if test="${!empty session }">
					<c:if test="${!fn:contains(myRent,book.idx) }">
						<c:if test="${empty gubun}">
							<td><a href="Book?cmd=preview&idx=${book.idx }"><input
									type="button" value="Preview"></a></td>
							<td class="view_main_button"><a href="#"
								onclick="javascript:window.open('Member?cmd=MemberPayCheck&idx=${book.idx}', 'PopupWin', 'width=500 ,height=630');">
									<input type="button" value="Lent">
							</a></td>
							<td class="view_main_button"><a href="javascript:payopen()"><input
									type="button" value="Subscribe"></a></td>
							<c:if test="${!fn:contains(bookCart,book.idx) }">
								<td class="view_main_button"><a
									href="BookCart?cmd=insert&idx=${book.idx }"><input
										type="button" value="go to Cart"></a></td>
							</c:if>
						</c:if>
					</c:if>
				</c:if>
				<!-- 회원이고, 내 서재에 그 책이 있고,구독회원이 아닐때-->
				<c:if test="${!empty session }">
					<c:if test="${fn:contains(myRent,book.idx) }">
						<c:if test="${empty gubun}">
							<td><a href="Book?cmd=bookview&idx=${book.idx }"><input
									type="button" value="Go read"></a></td>
							<td><a href="Rent?cmd=bookReturn&idx=${book.idx }"><input
									type="button" value="Return the book"></a></td>
						</c:if>
					</c:if>
				</c:if>

				<!-- 구독회원일 때 -->
				<c:if test="${!empty session }">
					<c:if test="${!empty gubun}">
						<c:if test="${fn:contains(myRent,book.idx) }">
							<td><a href="Book?cmd=bookview&idx=${book.idx }"><input
									type="button" value="Go read"></a></td>
						</c:if>
						<c:if test="${!fn:contains(myRent,book.idx) }">
							<td><a href="Book?cmd=preview&idx=${book.idx }"><input
									type="button" value="PreView"></a></td>
							<td><a href="Rent?cmd=bookRent&idx=${book.idx }"><input
									type="button" value="Add in library"></a></td>
							<c:if test="${!fn:contains(bookCart,book.idx) }">
								<td class="view_main_button"><a
									href="BookCart?cmd=insert&idx=${book.idx }"><input
										type="button" value="Go to Cart"></a></td>
							</c:if>
						</c:if>
					</c:if>
				</c:if>
			</tr>
		</table>
		<div class="menuline_V"></div>
		<div class="ad">
			<table>
				<tr>
					<td><img src="view/img/ad.png"
						onclick="javascript:window.open('Member?cmd=MemberSubscriptPayCheck', 'PopupWin',
						'width=410 ,height=630')"></td>
			</table>
		</div>
		<div class="view_name_b">
			<table>
				<tr>
					<td>Book introduction</td>
				</tr>
				<tr class="view_name_bp">
					<td>${book.intro }</td>
				</tr>
			</table>
		</div>
		<div class="view_name">Most Popular book in this genre</div>
		<%@ include file="index.jsp"%>
		<div class="view_name" style="padding-top: 40px;">Interest books
			by author</div>
		<%@ include file="index2.jsp"%>

		<div class="review">
			<table class="view_name_r">
				<tr>
					<td colspan="2">Review</td>
				</tr>
			</table>
			<form name="my2" method="post" id="form2"
				action="Book?cmd=commentWrite&idx=${book.idx }">
				<input type="hidden" name="score" value="3">
				<table class="view_name_r2">
					<tr class="view_name_r2_a">
						<td>Evaluation of the buyer</td>
						<td class="view_name_r2_b">Please evaluate this book!</td>
					</tr>
					<%-- <c:if test="${!empty session }"> --%>
					<c:if test="${fn:contains(myRent,book.idx) }">
						<tr>
							<td class="view_name_r2_c">${book_score2}</td>
							<td class="view_name_r2_d">

								<div class="Clear">
									<input class="star required" type="radio"
										name="test-2-rating-5" value="1" /> <input class="star"
										type="radio" name="test-2-rating-5" value="2" /> <input
										class="star" type="radio" name="test-2-rating-5" value="3"
										checked="checked" /> <input class="star" type="radio"
										name="test-2-rating-5" value="4" /> <input class="star"
										type="radio" name="test-2-rating-5" value="5" />
								</div>

							</td>
						</tr>
						<tr>
							<td class="view_name_r2_e"><p class="star_rating_a"></p></td>

							<td class="view_name_r2_f"><input name="contents"
								type="text" accesskey="L"
								placeholder="If you abused ant advertised this place, it may be deleted"
								class="int" maxlength="41" value=""></td>
						</tr>
						<tr class="view_name_r2_g">
							<td colspan="2"><input type="button" value="post Coment"
								onClick="bad_check()"></td>
						</tr>
					</c:if>
				</table>
			</form>
			<table class="view_name_r3">
				<c:if test="${empty book_comments }">
					<tr>
						<td width="20%"><p class="star_rating_a"></td>
						<td rowspan="3">There are not comment.</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td class="view_date"></td>
					</tr>
				</c:if>
				<c:if test="${!empty book_comments }">
					<c:forEach var="comments" items="${book_comments }">
						<tr>
							<td><p class="star_rating">
									<c:forEach var="i" begin="1" end="${comments.score}" step="1">
										<p style="color: #f8cdd7; float: left; font-size: 15px;">
											★
									</c:forEach>
									<c:forEach var="i" begin="${comments.score}" end="4" step="1">
										<p style="float: left; font-size: 15px;">☆
									</c:forEach>
								</p></td>
							<td rowspan="3">${comments.contents }</td>
						</tr>
						<tr>
							<td class="view_date" style="float: left;">${comments.regdate }</td>

						</tr>
						<tr>

							<td style="float: left;">${comments.member_id }</td>

						</tr>
						<tr>
							<td></td>
							<td style="float: right; margin-right: 10px;"><i
								class="fa fa-thumbs-o-up" aria-hidden="true"
								style="cursor: pointer;"
								onMouseOver="this.style.color='#93b9e6';"
								onMouseOut="this.style.color='black';"
								onclick="javascript:if(${not empty session }){window.open('Book?cmd=goodup&idx=${comments.idx}&member_id=${comments.member_id }','PopupWin',
						'width=455 ,height=120')}else{alert('Please Login.')}"></i>&nbsp;&nbsp;&nbsp;<span
								id="good">${comments.good }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<i class="fa fa-thumbs-o-down fa-flip-horizontal"
								aria-hidden="true" style="cursor: pointer;"
								onMouseOver="this.style.color='#93b9e6';"
								onMouseOut="this.style.color='black';"
								onclick="javascript:if(${not empty session }){window.open('Book?cmd=badup&idx=${comments.idx}&member_id=${comments.member_id }','PopupWin',
						'width=455 ,height=120')}else{alert('Please Login.')}">
							</i>&nbsp;&nbsp;&nbsp;<span>${comments.bad }</span></td>
						</tr>

					</c:forEach>
				</c:if>
			</table>
			<table style="height: 30px;"></table>
		</div>
	</div>
	<c:import url="../include/footer.jsp"></c:import>
</body>
</html>