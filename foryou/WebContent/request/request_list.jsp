<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="request/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link href="request/css/common.css" rel="stylesheet">
<link href="request/css/mystyle.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="js/jquery.fitvids.js"></script>


<jsp:include page="../include/topmenu_genre.jsp"></jsp:include>
</head>
<body>
	<div class="contain">
		<div class="sub-topcontent">
			<h2 class="sub-title">Your_Request</h2>
			<div class="sub-search">



				<form name="my" method="post" action="Request?cmd=request_listPost"
					onsubmit="return check()">
					<input type="hidden" name="page" value="${nowpage}"> <select
						name="search" class="sel">
						<option value="subject">subtitle</option>
						<option value="contents">contents</option>
					</select> <input type="text" name="key" class="text"> <input
						type="submit" value="Search" class="btn">
				</form>

			</div>
		</div>

		<div class="content-body">
			<table class="qatable">
				<caption class="readonly">질문답변 표</caption>
				<colgroup>
					<col width="6%">
					<col width="48%">
					<col width="10%">
					<col width="15%">
					<col width="11%">
					<col width="10%">
				</colgroup>
				<tbody>
					<tr>
						<th>PostNo</th>
						<th>Subtitle</th>
						<th>Writer</th>
						<th>ApprovalState</th>
						<th>Date</th>
						<th>View count</th>
					</tr>

					<c:if test="${!empty list}">
						<c:forEach var="request" items="${list}">
							<tr>
								<td>${listcount}</td>
								<td class="tleft"><a
									href="Request?cmd=requestView&page=${nowpage}&idx=${request.idx}">${request.subject}</a></td>
								<td>${request.userid}</td>


								<c:if test="${session != 'admin'}">
									<c:if test="${request.gubun=='0'}">
										<td><span class="gray">PendingApproval</span></td>
									</c:if>
								</c:if>

								<c:if test="${session == 'admin'}">
									<c:if test="${request.gubun=='0'}">
										<td><a
											href="Request?cmd=AdminRequestOK&page=${nowpage}&gubun=${request.gubun}&idx=${request.idx}">
												<span class="gray">PendingApproval</span>
										</a></td>
									</c:if>
								</c:if>


								<c:if test="${session != 'admin'}">
									<c:if test="${request.gubun!='0'}">
										<td><span class="red">finish approval</span></td>
									</c:if>
								</c:if>

								<c:if test="${session == 'admin'}">
									<c:if test="${request.gubun!='0'}">
										<td><a
											href="Request?cmd=AdminRequestOK2&page=${nowpage}&gubun=${request.gubun}&idx=${request.idx}">
												<span class="red">finish approval</span>
										</a></td>
									</c:if>
								</c:if>





								<td>${request.indate.substring(0,11)}</td>
								<td>${request.readcnt}</td>
							</tr>
							<c:set var="listcount" value="${listcount-1}" />
						</c:forEach>
					</c:if>

					<c:if test="${empty list}">
						<tr>
							<td></td>
							<td class="tleft">Post does not exist.</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:if>



				</tbody>
			</table>
		</div>



		<div class="paging">
			<table width="700" border="0" cellspacing="0" cellpadding="5"
				align="center">

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td colspan="5">
						<div align="center">${pageSkip}</div>
					</td>
					<td><a href="Request?cmd=request_writeGet&page=${nowpage}"
						class="btn-write">Write</a></td>
				</tr>
			</table>
		</div>



		<script>
			function check() {
				if (my.cont.value == "") {
					alert("Please enter your search information");
					my.cont.focus;
					return false;
				}
				return true;
			}
		</script>

	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
</html>
















