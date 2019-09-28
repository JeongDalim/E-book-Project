<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/nowviewstyle.css" rel="stylesheet">
</head>
<body>

	<div class="view_title">
		<h2>#The comment that posting now</h2>
	</div>
	<div class="view">
		<table class="view_main">
			<tr>
				<td ROWSPAN="7" style="width: 160px;"><a
					href="Book?cmd=view&idx=${nowReview.idx }"><img
						src="book/${nowReview.fileName }"></a></td>
				<!-- 	<td style="float: right; color: #808080;">2019-07-25</td> -->
			<tr>
			<tr>
				<td style="font-size: 20px;"><h2 style="margin: 0;">
						<a href="Book?cmd=view&idx=${nowReview.idx }">#${nowReview.bookName
							}</a>
					</h2></td>
			</tr>
			<tr>
				<td><p class="star_rating">
						<c:forEach var="i" begin="1" end="${score }" step="1">
							<p
								style="margin: 0; color: #f8cdd7; float: left; font-size: 30px;">★



							
						</c:forEach>
						<c:forEach var="i" begin="${score }" end="4" step="1">
							<p style="margin: 0; float: left; font-size: 30px;">☆
						</c:forEach>
					</p></td>
			</tr>
			<tr>
				<td style="font-size: 14px; color: #808080;"><B
					style="color: #000000; font-size: 16px;">${nowReview.writer
						}&nbsp;</B>
					저</td>
			</tr>
			<tr>
				<td style="font-size: 14px; color: #808080;"><B
					style="color: #000000; font-size: 16px;">${nowReview.company
						}&nbsp;</B>
					출판 | <font style="color: #000000; font-size: 16px;">${nowReview.pdate
						}</font></td>
			</tr>
			<tr>
				<td style="font-size: 14px; color: #808080;"><B
					style="color: #ff0000; font-size: 16px;">${nowReview.price
						}
						&nbsp;</B> 원</td>
			</tr>
		</table>
		<table class="cen">
			<tr>
				<td><img src="view/img/qu.png"
					style="width: 25px; height: 25px; padding-right: 5px;">${comments.contents }<img
					src="view/img/qu2.png"
					style="width: 25px; height: 25px; padding-left: 5px;"></td>
			</tr>
			<tr>
				<td>
					<h4>- ${comments.member_id.substring(0,4)}*** -</h4>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>