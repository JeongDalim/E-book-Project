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
			$("#amazon_scroller1").amazon_scroller({
				scroller_title_show : 'enable',
				scroller_time_interval : '4000',
				scroller_window_background_color : "#fff",
				scroller_window_padding : '10',
				scroller_border_size : '0',
				scroller_border_color : '#000',
				scroller_images_width : '124',
				scroller_images_height : '160',
				scroller_title_size : '12',
				scroller_title_color : 'black',
				scroller_show_count : '5',
			});
		});
	</script>
	<div id="amazon_scroller1" class="amazon_scroller">
		<div class="amazon_scroller_mask">
			<ul>
				<c:forEach var="book" items="${genre_list_best }">
					<li><img src="book/${book.fileName }" width="124" height="160"
						alt="jQuery in Action, Second Edition" /> <a
						href="Book?cmd=view&idx=${book.idx }"><div
								class="amazon_scroller_title"></div>${book.bookName }</a></li>
				</c:forEach>
			</ul>
		</div>

		<ul class="amazon_scroller_nav">
			<li class="aa"></li>
			<li></li>
		</ul>
		<div style="clear: both"></div>
	</div>
</body>
</html>