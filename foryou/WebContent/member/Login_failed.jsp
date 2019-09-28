member<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${row==-1 }">
		<script>
			alert("Password do not match.");
			location.href = "Member?cmd=login";
			member
		</script>
	</c:if>
	<c:if test="${row==0 }">
		<script>
			alert("No Id match the current search..");
			location.href = "Member?cmd=login";
		</script>
	</c:if>
	<c:if test="${row==1 }">
		<c:if test="${row2==1 }">
			<script>
				alert("Your account is Pending Approval. not yet available.");
				location.href = "Home?cmd=Home";
			</script>
		</c:if>
		<c:if test="${row2==3 }">
			<script>
				alert("is rejected approval. You not available.");
				location.href = "Home?cmd=Home";
			</script>
		</c:if>
	</c:if>
</body>
</html>