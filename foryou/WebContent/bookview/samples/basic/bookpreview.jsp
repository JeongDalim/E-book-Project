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

	<div class="bookview_last"
		style="margin-top: 1%; float: left; margin-left: 2%;">
		<a href="Book?cmd=view&idx=${idx }"><input type="button"
			value="뒤로가기 :)" style="background: #93b9e6;"></a>
	</div>
	<div class="flipbook-viewport">
		<div class="container">
			<div class="flipbook">
				<div style="background-image: url(book/${filename})"></div>
				<div></div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents1.png)">

				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents2.png)"></div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents3.png)">

				</div>
				<div
					style="background-image: url(bookview/samples/basic/pages/contents4.png)"></div>

				<div
					style="background-image: url(bookview/samples/basic/pages/lastpage_preview.png)"></div>
				<div
					style="background-image: url(bookview/samples/basic/pages/lastpage_preview.png)"></div>
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


