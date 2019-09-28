<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width = 1050, user-scalable = no" />
<script type="text/javascript" src="bookview/extras/jquery.min.1.7.js"></script>
<script type="text/javascript"
	src="bookview/extras/modernizr.2.5.3.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.on {
	color: #ff0000;
}
</style>
<script>
	function bookmark(page, idx) {
		location.href = "Book?cmd=bookmark&idx=" + idx + "&bookmark=" + page;

	}
</script>
<script>
	function mo() {
		if (ff.pagename.value == "") {
			alert("이동할 페이지를 입력하세요.");
			return;
		}
		ff.submit();

	}

	function bookmark(page, idx) {
		location.href = "Rent?cmd=bookmark&page=" + page + "&idx=" + idx;

	}
</script>
<script>
	function click() {
		if ((event.button == 2) || (event.button == 3)) { //IE에서 금지합니다
			alert('마우스 오른쪽 버튼은 사용할 수 없습니다.');
		}
	}
	document.onmousedown = click
	if (navigator.appName == "Netscape") { //IE 이외에서도 금지합니다-Netscape
		document.captureEvents(Event.MOUSEDOWN)
		document.onmousedown = checkClick
		function checkClick(event) {
			if (event.which != 1) {
				alert('마우스 오른쪽 버튼은 사용할 수 없습니다.')
				return false
			}
		}
	}
</script>
<script>
	function ClipBoardClear() {
		if (window.clipboardData) {
			clipboardData.clearData();
		}
	}
	setInterval("ClipBoardClear();", 100);
</script>
</head>
<body style="background: url(bookview/samples/basic/bg.jpg) repeat"
	onload="ClipBoardClear()">
	<div class="select">
		<div class="bookview_last">
			*북마크를 원한다면 페이지 내 북마크 버튼을 눌러주세요 :) * <a href="Home?cmd=Home"><input
				type="button" value="홈으로  :)"></a>
		</div>
		<form name="ff" action="Book?cmd=bookpage_pro" method="post">
			<input type="text" id="id" name="pagename" accesskey="L"
				placeholder="마지막페이지는  ${contentssize }쪽 " class="int" maxlength="41"
				style="height: 50px; width: 150px; border: 3px solid #93b9e6; margin-left: 15px;">
			<input type="hidden" name="idx" value="${idx }"> <input
				type="hidden" name="bookmark" value="${bookmark }"> <input
				type="hidden" name="contentssize" value="${contentssize }">
			<input type="button" value="이동" onclick="mo()"
				style="height: 50px; width: 50px; background: #93b9e6; border: none; color: #fff;">

		</form>

		<ul>

			<c:if test="${!empty page}">
				<li><a href="#" class="${page}">이동 ${page}쪽</a></li>

			</c:if>
			<c:if test="${bookmark != 0}">
				<li><a href="#" class="${bookmark}">북마크 이동 ${bookmark}쪽</a></li>
		</ul>

		</c:if>

	</div>

	<div class="flipbook-viewport">
		<div class="container">
			<div class="flipbook">
				<div style="background-image: url(book/${filename})"></div>
				<div></div>
				<div id="1" class="bookview_bookmark"
					style="background-image: url(bookview/samples/basic/pages/contents1.png)">
					p.1 <input type="button" value="북마크" onclick="bookmark(1,'${idx}')">
				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents2.png)"></div>
				<div class="bookview_bookmark"
					style="background-image: url(bookview/samples/basic/pages/contents3.png)">
					p.2<input type="button" value="북마크" onclick="bookmark(2,'${idx}')">
				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents4.png)"></div>
				<div class="bookview_bookmark"
					style="background-image: url(bookview/samples/basic/pages/contents5.png)">
					p.3<input type="button" value="북마크" onclick="bookmark(3,'${idx}')">
				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents6.png)"></div>
				<div class="bookview_bookmark"
					style="background-image: url(bookview/samples/basic/pages/contents7.png)">
					p.4 <input type="button" value="북마크" onclick="bookmark(4,'${idx}')">
				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents8.png)"></div>
				<div class="bookview_bookmark"
					style="background-image: url(bookview/samples/basic/pages/lastpage.png)">
					p.5 <input type="button" value="북마크" onclick="bookmark(5,'${idx}')">
				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/lastpage.png)"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function loadApp() {

			// Create the flipbook

			$('.flipbook').turn({
				// Width

				width : 1650,

				// Height

				height : 800,

				// Elevation

				elevation : 50,

				// Enable gradients

				gradients : true,

				// Auto center this flipbook

				autoCenter : true

			});
		}

		yepnope({
			test : Modernizr.csstransforms,
			yep : [ 'bookview/lib/turn.js' ],
			nope : [ 'bookview/lib/turn.html4.min.js' ],
			both : [ 'bookview/samples/basic/css/basic.css' ],
			complete : loadApp
		});
	</script>

</body>
</html>
<script>
	$(document).ready(function() {
		$('.select ul li a').click(function() {
			$('.select ul li a').removeClass('on');
			$(this).addClass('on');
		});

		$('.1').click(function() {
			$(".flipbook").turn("page", 2);
		});
		$('.2').click(function() {
			$(".flipbook").turn("page", 4);
		});
		$('.3').click(function() {
			$(".flipbook").turn("page", 6);
		});
		$('.4').click(function() {
			$(".flipbook").turn("page", 8);
		});
		$('.5').click(function() {
			$(".flipbook").turn("page", 10);
		});
		$('.6').click(function() {
			$(".flipbook").turn("page", 12);
		});

		$(".flipbook").bind("turning", function(event, page, view) {
			if (page == 4 || page == 5) {
				$('.select ul li a').removeClass('on');
				$('.2').addClass('on');
			}
			if (page == 2 || page == 3) {
				$('.select ul li a').removeClass('on');
				$('.1').addClass('on');
			}
			if (page == 6 || page == 7) {
				$('.select ul li a').removeClass('on');
				$('.3').addClass('on');
			}
			if (page == 8 || page == 9) {
				$('.select ul li a').removeClass('on');
				$('.4').addClass('on');
			}
		});
	});
</script>

