<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/mystyle.css" rel="stylesheet">
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="bookInfo/css/style.css" rel="stylesheet" />
<link href="bookInfo/css/common.css" rel="stylesheet" />
<script>
	function modi(idx) {
		location.href = "Book?cmd=publishermodify&idx=" + idx;
	}
	function del(idx) {
		location.href = "Book?cmd=publisherdelete&idx=" + idx;
	}
</script>
</head>
<body>
	<%@ include file="../include/topmenu_genre.jsp"%>
	<form name="" method="post" action="">
		<table class="Login_tab_M">
			<tr>
				<td align="right" colspan="7">Total ${list.size() }</td>
			</tr>
			<tr>
				<td>No</td>
				<td>cover</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Publisher</td>
				<td>Date</td>
				<td>Administrator</td>
			</tr>
			<c:if test="${! empty list}">
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${count }</td>
						<td><img src="${vo.fileName }"></td>
						<td>${vo.bookName }</td>
						<td>${vo.writer }</td>
						<td>${vo.company }</td>
						<td>${vo.indate }</td>
						<td><input type="button" value="Modify"
							onclick="modi('${vo.idx}')">&nbsp; <input type="button"
							value="Delete" onclick="del('${vo.idx}')"></td>
					</tr>
					<c:set var="count" value="${count-1 }"></c:set>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">

				<tr>
					<td colspan="7">No Book were found registered</td>
				</tr>
			</c:if>
		</table>
	</form>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>