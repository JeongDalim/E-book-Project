<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function payopen() {
		window.open("Member?cmd=MemberSubscriptPayCheck", "PopupWin",
		"width=410 ,height=630");
	}
</script>
<div class="show-on-scroll">
	<div class="for_you_right">
		<ul style="color: #333;">
			<c:if test="${!empty session}">
				<li class="mar_bo"><a href="BookCart?cmd=bookCart">My Cart</a></li>
				<c:if test="${empty agree }">
					<li class="mar_bo"><a href="Rent?cmd=myRent">My library</a></li>
				</c:if>
			</c:if>
			<c:if test="${empty session}">
				<li><a href="#"
					onClick="javascript:alert('Sign in to use this feature'),location.href='Member?cmd=login'">Subscription</a></li>
			</c:if>
			<c:if test="${!empty session && empty gubun}">
				<li><a href="javascript:payopen()">Subscription</a></li>
			</c:if>
		</ul>
	</div>
</div>