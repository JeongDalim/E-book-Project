<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Line Friends</title>
<link href="Home/css/font-awesome.min.css" rel="stylesheet">
<link href="Home/css/common.css" rel="stylesheet">
<link href="Home/css/mystyle.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!--jquery.min.js 먼저 선언이 되어야지만 jquery를 사용할 수 있다  -->
<!--javascript로 만들어진 언어 라이브러리  -->
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<!--  -->
<script>
	$(function() {//$(document).ready jquery언어를 시작하는 선언구
		$('.h_slider').bxSlider({//'.slider'(선택자)를 실행하라. 함수를 
			mode : 'fade',//사진이 넘어가는 스타일 정하기 옆으로 휙휙
			captions : true,
			auto : true
		});
		$('.index_gallery_contents_contents').bxSlider({//'.slider'(선택자)를 실행하라. 함수를 
			mode : 'fade',//사진이 넘어가는 스타일 정하기 옆으로 휙휙
			captions : true,
			auto : true
		});
		$(".sitemap").click(function() {//$(클래스 명을) 클릭하면 함수를 실행하시오.
			$(".sitewrap").slideDown();//.sitewrap이라는 그룹을 보여줘라 ex)hide숨겨라
		})
		$("#close").click(function() {
			$(".sitewrap").slideUp();//slideDown 스르륵 아래로 스스륵 위로
		})
		$(".nav > nav > .navi > li").hover(function() {
			$(this).children(".navi2").stop().slideDown();//.stop()애니매이션이 정지 한 후 실행하라
		}, function() {//,를 붙이면 (그렇지 않으면 )
			$(this).children(".navi2").stop().slideUp();
		});
	});

	function search_check() {
		if (my.keyword.value == "") {
			alert("Please enter your search information");
			my.keyword.focus();
			return;
		}
		my.submit();
	}
</script>
</head>
<body>
	<div class="header_3">
		<header>
			<div class="header_top">
				<ul>
					<c:if test="${empty session }">
						<li><a href="Member?cmd=login">Login</a></li>
						<li><a href="Member?cmd=insert">Join US</a></li>
					</c:if>
					<c:if test="${!empty session }">
						<li><a href="Member?cmd=logout">Logout</a></li>
						<li><a
							href="Member?cmd=memberview&session=${session }&agree=${agree}">My
								Info</a></li>
						<li><a href="Request?cmd=request_listGet">Request the
								Book</a></li>
						<c:if test="${session=='admin' }">
							<li><a href="Admin?cmd=agreelist">Admin</a></li>
							<li><a href="Sales?cmd=saleslist">accounts management</a></li>
						</c:if>
						<c:if test="${!empty agree }">
							<li><a href="Book?cmd=publisherList">Book List</a></li>
							<li><a href="Book?cmd=publisherInsert">Book enrollment</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
			<div class="header_left">
				<h1 class="logo">
					<a href="Home?cmd=Home"><img src="include/logo.png" alt=""
						style="width: 100px; height: 100px;"><br></a>
				</h1>
				<div class="nav">
					<nav>
						<ul class="navi">
							<li><a href="Home?cmd=Home#div4">ABOUT</a></li>
							<li><a href="Home?cmd=Home#div1">TODAY</a></li>
							<li><a href="Home?cmd=Home#div2">BEST</a></li>
							<li><a href="Home?cmd=Home#div3">NEW</a></li>
							<li><a href="Genre?cmd=search">GENRE</a></li>
							<c:if test="${!empty session }">
								<li><a href="Home?cmd=Home#div5">FORYOU</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="search">
				<form name="my" method="get" action="Book">
					<input type="hidden" name="cmd" value="search">
					<table>
						<tr>
							<td><select style="height: 100%; width: 70px;" name="search">
									<option value="all">Integrated search</option>
									<option value="bookName">Title</option>
									<option value="writer">Writer</option>
									<option value="company">Publisher</option>
							</select></td>
							<td class="Login_tab_M_con"><input type="text" id="id"
								name="keyword" accesskey="L" placeholder="Search" class="int"
								maxlength="41">
							<td class="img_Back"><a href="#" onClick="search_check()"><img
									src="Home/img/loupe.png"></a></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="menuline"></div>
		</header>
	</div>
</body>
</html>