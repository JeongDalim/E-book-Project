<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title">${vo.subject}</h2>
		<p class="sub-view-wd">${vo.userid}| ${vo.indate}</p>
	</div>
	<div class="sub-view-contnet">${vo.contents}</div>






	<div class="sub-view-bottom">

		<!-- <a href="qareply.do" class="btn-modify">승인 - 관리자 </a>&nbsp;&nbsp; -->

		<a href="#" class="btn-delete" onclick="avent2();">modify</a>&nbsp;&nbsp;

		<a href="#" class="btn-delete" onclick="avent();">delete</a>&nbsp;&nbsp;

		<a href="Request?cmd=request_listGet&page=${nowpage}" class="btn-list">list</a>&nbsp;&nbsp;
	</div>
	<form name="form" action="#">
		<input type="hidden" name="userid" value="${vo.userid}"> <input
			type="hidden" name="session" value="${session}"> <input
			type="hidden" name="nowpage" value="${nowpage}"> <input
			type="hidden" name="idx" value="${vo.idx}">
	</form>


</div>
<script>
function avent(){
	if(confirm("Are you sure you want to delete this post") == true) {
		if(form.userid.value == form.session.value || form.session.value=="admin" ){
	location.href="Request?cmd=request_deleteGet&page=${nowpage}&idx=${vo.idx}";
		
	}else {
		alert("You don't have access rights.");
		return;
	
	}
		return;
	}
}

function avent2(){
	if(confirm("Are you sure you want to modify this post?") == true) {
		if(form.userid.value == form.session.value || form.session.value=="admin" ){
		location.href="Request?cmd=request_modifyGet&page=${nowpage}&idx=${vo.idx}";
	
		}else{
			alert("You don't have access rights.");
			return;	
		}
	}else {
		return;
	}
	
	
}

</script>

<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>















