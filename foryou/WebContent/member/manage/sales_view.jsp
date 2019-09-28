<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="manage/css/style.css" rel="stylesheet" />
<link href="manage/css/common.css" rel="stylesheet" />
<link href="Home/css/mystyle.css" rel="stylesheet" />
<link href="Home/css/common.css" rel="stylesheet" />
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
		var dataRow = [];
		<c:forEach var="vo" items="${list}">
		list.push("${vo.day}");
		list2.push("${vo.sales}");
		</c:forEach>

		data.addColumn('string', 'Day');
		data.addColumn('number', '일별 매출액');

		for (var i = 0; i < list.length; i++) {
			var day = " " + list[i];
			var sales = list2[i];
			dataRow = [ day, parseInt(sales) ];
			data.addRow(dataRow);

		}

		var options = {
			chart : {
				title : '${company}',
				subtitle : 'Show Sales and Expense of Company'
			},
			width : 900,
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
	<div
		style="text-align: center; margin: 0 auto; width: 100%; padding-left: 570px;">
		<div id="line_chart" style="width: 910px;"></div>
	</div>

	<table class="Login_tab_M" style="width: 40%;">
		<tr>
			<td align="right" colspan="3">총 ${list.size() } 건</td>
		</tr>

		<tr>
			<td>번호</td>
			<td>도서명</td>
			<td>총 매출</td>
		</tr>
		<c:forEach var="vo" items="${list2 }">
			<tr>
				<td>${cnt }</td>
				<td>${vo.name }</td>
				<td>${vo.sales }</td>
			</tr>
			<c:set var="cnt" value="${cnt+1 }" />
		</c:forEach>
	</table>


	<c:import url="../include/footer.jsp"></c:import>

</body>
</html>
