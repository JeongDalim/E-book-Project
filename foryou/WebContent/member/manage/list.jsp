<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="manage/css/style.css" rel="stylesheet" />
<link href="manage/css/common.css" rel="stylesheet" />
<link href="Home/css/mystyle.css" rel="stylesheet" />
<link href="Home/css/common.css" rel="stylesheet" />

</head>
<script>
	function ck() {
		if (ff.year.value == "") {
			alert("년도를 입력해주세요.");
			return;
		} else if (ff.month.value == "") {
			alert("달을 입력해주세요.");
			return;
		} else {
			ff.submit();
		}
	}
</script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'line' ]
	});

	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = new google.visualization.DataTable();
		// Add legends with data type
		var list = new Array();
		var list2 = new Array();
		var list3 = new Array();
		var list4 = new Array();

		var dataRow = [];
		<c:forEach var="vo" items="${list2}">
		list.push("${vo.day}");
		list2.push("${vo.sales}");
		</c:forEach>

		<c:forEach var="vo" items="${list3}">
		list3.push("${vo.day}");
		list4.push("${vo.sales}");
		</c:forEach>

		data.addColumn('string', 'Day');
		data.addColumn('number', '총 매출액');
		data.addColumn('number', '수수료 차감 매출액');

		for (var i = 0; i < list.length; i++) {
			var day = " " + list[i];
			var sales = list2[i];
			var sales2 = list4[i];

			dataRow = [ day, parseInt(sales), parseInt(sales2) ];
			data.addRow(dataRow);

		}

		var options = {
			chart : {
				title : 'ForYou',
				subtitle : 'Show Sales and Expense of Company'
			},
			width : 1100,
			height : 400,
			axes : {
				x : {
					0 : {
						side : 'bottom'
					}
				}
			}
		};
		var chart = new google.charts.Line(document
				.getElementById('line_chart'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div class="header_3">
		<header>
			<div class="header_top">
				<ul>
					<c:if test="${empty session }">
						<li><a href="Member?cmd=login">로그인</a></li>
						<li><a href="Member?cmd=insert">회원가입</a></li>
					</c:if>
					<c:if test="${!empty session }">
						<li><a href="Member?cmd=logout">로그아웃</a></li>
						<li><a
							href="Member?cmd=memberview&session=${session }&agree=${agree}">내정보</a></li>

						<li><a href="Admin?cmd=agreelist">관리자</a></li>
						<li><a href="Sales?cmd=saleslist">매출 관리</a></li>

					</c:if>
				</ul>
			</div>
			<div class="header_left">
				<h1 class="logo">
					<a href="Home?cmd=Home">FOR YOU<br></a>
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

			<div class="menuline" style="margin-top: 150px;"></div>
		</header>
	</div>
	<c:if test="${!empty list}">
		<div
			style="text-align: center; margin: 0 auto; width: 100%; padding-left: 500px;">
			<div id="line_chart" style="width: 1110px;"></div>
		</div>
		<br>
		<div style="float: right; padding-right: 500px;">총 구독자수:${r }
			구독자로인한 이익: ${foryousales }</div>
	</c:if>
	<table class="Login_tab_M" style="clear: both;">
		<tr>
			<td align="right" colspan="3">총 ${list.size() } 건</td>
		</tr>
		<tr>
			<form name="ff" method="post" action="Sales?cmd=saleslist_pro">
				<td><input type="text" name="year" placeholder="년도-ex)2019"
					maxlength="20"></td>
				<td><input type="text" name="month" placeholder="달-ex)7"
					maxlength="20" value=""></td>
				<td><input type="button" value="검색" onClick="ck()"></td>
			</form>
		</tr>
		<tr>
			<td>번호</td>
			<td>출판사</td>
			<td>총매출액</td>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${count }</td>
					<td><a
						href="Sales?cmd=salesview&company=${vo.company }&year=${year}&month=${month}">${vo.company }</a></td>
					<td>${vo.sales }</td>
				</tr>
				<c:set var="count" value="${count-1 }"></c:set>
			</c:forEach>
		</c:if>

		<c:if test="${empty list  }">
			<tr>
				<td colspan="3">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
	</table>
	</form>
	<c:import url="../include/footer.jsp"></c:import>
</body>
</html>