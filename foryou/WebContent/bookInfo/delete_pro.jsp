<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result==true }">
		<script>
alert("data has been deleted.: Have nice day)  ForYou-");
location.href="Book?cmd=publisherList";
</script>
	</c:if>

</body>
</html>