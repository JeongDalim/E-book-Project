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
		if (ff.year.value=="") {
			alert("Please enter your search year.");
			return;
		} else if (ff.month.value=="") {
			alert("Please enter your search month.");
			return;
		} else {
			ff.action="Sales?cmd=saleslist_pro"
			ff.submit();
		}
	}
	function sendsales(){
		ff.action="Excel?cmd=saleslistexcel";
		ff.submit();
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
		data.addColumn('number', 'Total Sales');
		data.addColumn('number', 'deduct fee');

		for (var i = 0; i < list.length; i++) {
			var day = " " + list[i];
			var sales = list2[i];
			var sales2 = list4[i];
			
			dataRow = [ day, parseInt(sales),parseInt(sales2) ];
			data.addRow(dataRow);

		}

		var options = {
			chart : {
				title : 'ForYou',
				subtitle : 'Show Sales and Expense of Company'
			},
			width : 750,
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
						<li><a href="Member?cmd=login">Login</a></li>
						<li><a href="Member?cmd=insert">Join US</a></li>
					</c:if>
					<c:if test="${!empty session }">
						<li><a href="Member?cmd=logout">Logout</a></li>
						<li><a
							href="Member?cmd=memberview&session=${session }&agree=${agree}">My
								info</a></li>
						<li><a href="Request?cmd=request_listGet">Request the
								Book</a></li>
						<li><a href="Admin?cmd=agreelist">Admin</a></li>
						<li><a href="Sales?cmd=saleslist">accounts management</a></li>

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
	<c:if test="${!empty list2}">
		<div
			style="text-align: center; margin: 0 auto; width: 100%; padding-left: 550px;">
			<div id="line_chart" style="width: 760px;"></div>
		</div>

		<div style="text-align: center; padding-top: 60px; font-size: 19px;">
			total subscribers${r } <br>
			<br> profit of Subscribing: ${foryousales }<br>
			<br> general payment: ${foryouusersales } <br>
			<br>publisher commission=${sales2 } <br>
			<br> total sales = general payment + profit of Subscribing
			-publisher commission 20% <br>
			<br>
			<h2 style="font-size: 36px;">total sales =${total }</h2>
		</div>
	</c:if>
	<form name="ff" method="post">
		<table class="Login_tab_M">
			<tr>
				<td align="right" colspan="3">총 ${list.size() }</td>
			</tr>
			<tr>
				<td><input type="text" name="year" placeholder="year-ex)2019"
					maxlength="20" value="${year }"></td>
				<td><input type="text" name="month" placeholder="month-ex)7"
					maxlength="20" value="${month }"></td>
				<td><input type="button" value="Search" onClick="ck()"></td>

			</tr>
			<tr>
				<td>No</td>
				<td>Publisher</td>
				<td>Total sales</td>
			</tr>
			<c:if test="${!empty list}">
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${count }</td>
						<td><a
							href="Sales?cmd=salesview&company=${vo.company }&year=${year}&month=${month}">${vo.company }</a></td>
						<td>${vo.sales }</td>
					</tr>
					<c:set var="count" value="${count+1 }"></c:set>
				</c:forEach>
				<tr>
					<td colspan="9"><input type="button" value="excel"
						onclick="sendsales()"></td>
				</tr>
			</c:if>

			<c:if test="${empty list  }">
				<tr>
					<td colspan="3">No search results are currently selected.</td>
				</tr>
			</c:if>
		</table>
	</form>
	<c:import url="../include/footer.jsp"></c:import>
</body>
</html>