<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<div class="contain">
	<br> <br> <br> <br> <br> <br>
	<div class="sub-topcontent">
		<h2 class="sub-title">Write your Request</h2>
	</div>

	<div class="write-form">
		<table summery="질문답변 글쓰기 테이블 입니다">
			<caption class="readonly"></caption>
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
				<form name="my" method="post"
					action="Request?cmd=request_modifyPost&page=${nowpage}&idx=${vo.idx}"
					onsubmit="return formcheck();">
					<tr>
						<th>subtitle</th>
						<td><input type="text" name="subject"
							placeholder="Please Enter the subtitle" value="${vo.subject}"></td>
					</tr>
					<tr>
						<th>Writer</th>
						<td><input type="text" name="userid" value="${vo.userid}"
							readonly></td>
					</tr>
					<tr>
						<th>contents</th>
						<td><textarea name="contents">${vo.contents}</textarea></td>
					</tr>


					<tr>
						<td colspan="2"><input type="submit" value="send"
							class="btn-write" onclick="javascript:my.submit()"> <input
							type="button" value="back" class="btn-reset"
							onclick="javascript:location.href='Request?cmd=request_listGet'">
						</td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>

</div>

<script>
	function formcheck() {
		if(my.title.value=="") {
			alert("Please enter your search information");
			my.title.focus();
			return false;
		}
		if(my.content.value=="") {
			alert("Please enter your search information");
			my.contnet.focus();
			return false;
		}
		return true;
	}
</script>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>


















