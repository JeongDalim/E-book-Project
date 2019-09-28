<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function popNoSee() {
		location.href = "Home?cmd=popNoSee";
	}
	function popClose() {
		window.close();
	}
	function go(idx) {
		opener.document.location.href = "Book?cmd=view&idx=" + idx;
		self.close();
	}
</script>
</head>
<body>
	<a href="#" onClick="go('${book.idx }')"><img alt="출판예정책"
		src="book/${book.fileName }" style="width: 330px; height: 350px;"></a>
	<form name="pop_form">
		<input type="button" value="X" onClick="popNoSee()"> I want
		not see this day <input type="button" value="X" onClick="popClose()">
		Close
	</form>
</body>
</html>