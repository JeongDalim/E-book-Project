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
		<h2>#The book I’ m reading</h2>
	</div>
	<div class="view">
		<table class="view_main">
			<tr>
				<td ROWSPAN="7" style="width: 160px;"><a
					href="Book?cmd=bookview&idx=${nowRead.idx }"><img
						src="book/${nowRead.fileName
						}"></a></td>
			<tr>
			<tr>
				<td style="font-size: 20px;"><h2 style="margin: 0;">
						<a href="Book?cmd=bookview&idx=${nowRead.idx }">#${nowRead.bookName
							}</a>
					</h2></td>
			</tr>
		</table>
	</div>

</body>
</html>