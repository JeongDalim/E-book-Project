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
<link href="admin/css/style.css" rel="stylesheet" />
<link href="admin/css/common.css" rel="stylesheet" />
</head>
<script>
	function agreechange(idx, agree) {
		location.href = "Admin?cmd=agreechange&idx=" + idx + "&agree=" + agree;
	}
</script>
<body>
	<%@ include file="../include/topmenu_genre.jsp"%>
	<h1 style="text-align: center; color: #93b9e6">출판사 승인</h1>
	<form name="form" method="post">
		<table class="Login_tab_M">
			<tr>
				<td align="right" colspan="9">총 ${list.size() } 건</td>
			</tr>
			<tr>
				<td>No</td>
				<td>Id</td>
				<td>Name</td>
				<td>corporate registration number</td>
				<td>Email</td>
				<td>Tel number</td>
				<td>corporate registration number File</td>
				<td></td>
				<td>state</td>
			</tr>
			<c:if test="${not empty list }">
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${count }</td>
						<td>${vo.id}</td>
						<td>${vo.name }</td>
						<td>${vo.bno }</td>
						<td>${vo.email }</td>
						<td>${vo.tel }</td>
						<td><img src="bfile/사업자증명서.jpg"
							style="width: 100px; height: 50px;"></td>
						<td><c:if test="${vo.agree==1 }">대기</c:if> <c:if
								test="${vo.agree==2 }">승인</c:if> <c:if test="${vo.agree==3 }">거절</c:if>
						</td>
						<td><c:if test="${vo.agree==1 }">
								<input type="button" value="approve"
									onclick="agreechange('${vo.idx }',2)">
								<input type="button" value="reject"
									onclick="agreechange('${vo.idx }',3)">
								<input type="button" value="delete"
									onclick="agreechange('${vo.idx }',4)">
							</c:if> <c:if test="${vo.agree==2 }">
								<input type="button" value="reject"
									onclick="agreechange('${vo.idx }',3)">
								<input type="button" value="Pending Approval"
									onclick="agreechange('${vo.idx }',1)">
								<input type="button" value="delete"
									onclick="agreechange('${vo.idx }',4)">
							</c:if> <c:if test="${vo.agree==3 }">
								<input type="button" value="approve"
									onclick="agreechange('${vo.idx }',2)">
								<input type="button" value="Pending Approval"
									onclick="agreechange('${vo.idx }',1)">
								<input type="button" value="delete"
									onclick="agreechange('${vo.idx }',4)">
							</c:if></td>
					</tr>
					<c:set var="count" value="${count-1 }"></c:set>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="9">No publisher were found registered.</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="9"><input type="button" name="excel" value="excel"
					onclick="location.href='Excel?cmd=plistexcel'"></td>
			</tr>
		</table>
	</form>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>