<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,model.book.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script>
	$(".hover").mouseleave(function() {
		$(this).removeClass("hover");
	});
</script>
<link href="genre/css/common.css" rel="stylesheet">
<link href="genre/css/style.css" rel="stylesheet">
<link href="genre/css/fadein.css" rel="stylesheet">
<link href="Home/css/mystyle2.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../include/topmenu_genre.jsp"></jsp:include>
	<%
		List<BookVO> list = (List<BookVO>) request.getAttribute("list");
		String genre = null;
	%>
	<div class="contain">
		<div class="list-title">
			<h2>
				<%
					if (list.size() != 0) {
						genre = list.get(0).getGenre();
				%>
				${keyword} Search Result [${nowpage }/${totpage }]
				<%
					}
				%>
			</h2>
			<!-- 수정 -->
		</div>
		<div class="list-contents"
			style="margin: 0 auto; text-align: center; width: 100%; margin-bottom: 150px;">
			<table class="list-table"
				style="margin: 0 auto; text-align: center; width: 90%;">
				<tr>
					<%
						if (list.size() != 0) {
							for (int i = 0; i < list.size(); i++) {
								if (i % 4 == 0) {
					%>
				</tr>
				<tr>
					<%
						}
					%>
					<td><a
						href="Book?cmd=view&genre=<%=list.get(i).getGenre()%>&idx=<%=list.get(i).getIdx()%>">
							<figure class="snip1384">
								<img src="book/<%=list.get(i).getFileName()%>" alt="사진" />
								<figcaption>
									<h3>
										<%=list.get(i).getBookName()%>
									</h3>
									<br>
									<p><%=list.get(i).getWriter()%>&nbsp;|&nbsp;<%=list.get(i).getCompany()%>
									</p>
									<p><%=list.get(i).getPrice()%>
									</p>
									<p>
										【<%=list.get(i).getBookPlot()%>】
									</p>
									<i class="ion-ios-arrow-right"></i>
								</figcaption>
							</figure>
					</a></td>
					<%
						}
						} else {
					%>
					<td>
						<figure>
							<figcaption>
								<h3>No search results are currently selected.</h3>
							</figcaption>
						</figure>
					</td>
					<%
						}
					%>
				</tr>
			</table>
		</div>
		${pageSkip}
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>