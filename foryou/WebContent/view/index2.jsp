<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="view/css/amazon_scroller.css" rel="stylesheet"
	type="text/css"></link>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="view/js/amazon_scroller.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script language="javascript" type="text/javascript">
		$(function() {
			$("#amazon_scroller3").amazon_scroller({
				scroller_title_show : 'enable',
				scroller_time_interval : '3000',
				scroller_window_background_color : "none",
				scroller_window_padding : '10',
				scroller_border_size : '0',
				scroller_border_color : '#9C6',
				scroller_images_width : '124',
				scroller_images_height : '160',
				scroller_title_size : '11',
				scroller_title_color : 'black',
				scroller_show_count : '5',
				directory : 'images'
			});
		});
	</script>
	<div id="amazon_scroller3" class="amazon_scroller">
		<div class="amazon_scroller_mask">
			<ul>
				<c:forEach var="book" items="${writer_list }">
					<li><a href="Book?cmd=view&idx=${book.idx }"><img
							src="book/${book.fileName }" width="124" height="160"
							alt="jQuery in Action, Second Edition" />${book.bookName }</a></li>

				</c:forEach>
				<li><a href="Book?cmd=view&idx=60"><img
						src="book/행복한꿀잠.JPG" width="124" height="160"
						alt="jQuery in Action, Second Edition" />행복한꿀잠</a></li>
				<li><a href="Book?cmd=view&idx=7"><img src="book/플립.JPG"
						width="124" height="160" alt="jQuery in Action, Second Edition" />플립</a></li>
				<li><a href="Book?cmd=view&idx=28"><img
						src="book/형사의눈빛.JPG" width="124" height="160"
						alt="jQuery in Action, Second Edition" />형사의눈빛</a></li>
				<li><a href="Book?cmd=view&idx=34"><img src="book/하얀국화.JPG"
						width="124" height="160" alt="jQuery in Action, Second Edition" />하얀국화</a></li>

			</ul>
		</div>
		<ul class="amazon_scroller_nav">
			<li></li>
			<li></li>
		</ul>
		<div style="clear: both"></div>
	</div>
</body>
</html>