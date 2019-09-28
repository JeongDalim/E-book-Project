<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="genre/css/mosaic.css" rel="stylesheet" />
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="genre/css/comm	on.css" rel="stylesheet">
<link href="genre/css/style.css" rel="stylesheet">
</head>
<%@ include file="../include/topmenu_genre.jsp"%>
<body>
	<div class="genretitle">
		<h1>Genre</h1>
	</div>
	<table class="imgtab">
		<tr>
			<td><a href="Genre?cmd=list&genre=af"><figure
						class="snip1382">
						<img src="genre/img/af.jpg" alt="무협" />
						<figcaption>
							<h2>Chivalry</h2>
							<p>Asian Fantasy.</p>
						</figcaption>
					</figure> </a></td>
			<td><a href="Genre?cmd=list&genre=development"><figure
						class="snip1382">
						<img src="genre/img/development.jpg" alt="자기계발" />
						<figcaption>
							<h2>Self-improvement</h2>
							<p>Developments.</p>
						</figcaption>
					</figure></a></td>
			<td><a href="Genre?cmd=list&genre=economic">
					<figure class="snip1382">
						<img src="genre/img/economic.jpg" alt="경제" />
						<figcaption>
							<h2>Economic</h2>
							<p>Economic.</p>
						</figcaption>
					</figure></td>
			<td><a href="Genre?cmd=list&genre=finance">
					<figure class="snip1382">
						<img src="genre/img/finance.jpg" alt="금융" />
						<figcaption>
							<h2>Finance</h2>
							<p>Finance.</p>
						</figcaption>
					</figure></td>
			<td><a href="Genre?cmd=list&genre=health">
					<figure class="snip1382">
						<img src="genre/img/health.jpg" alt="건강" />
						<figcaption>
							<h2>Health and Life</h2>
							<p>Health.</p>
						</figcaption>
					</figure></td>
		</tr>
		<tr>
			<td><a href="Genre?cmd=list&genre=humanities">
					<figure class="snip1382">
						<img src="genre/img/humanities.jpg" alt="인문학" />
						<figcaption>
							<h2>Humanity</h2>
							<p>Health.</p>
						</figcaption>
					</figure></td>
			<td><a href="Genre?cmd=list&genre=novel">
					<figure class="snip1382">
						<img src="genre/img/novel.jpg" alt="소설" />
						<figcaption>
							<h2>novel</h2>
							<p>Novel.</p>
						</figcaption>
					</figure>
			</a></td>
			<td><a href="Genre?cmd=list&genre=romance">
					<figure class="snip1382">
						<img src="genre/img/romance.jpg" alt="로맨스" />
						<figcaption>
							<h2>Romance</h2>
							<p>Romance.</p>
						</figcaption>
					</figure>
			</a></td>
			<td><a href="Genre?cmd=list&genre=sf">
					<figure class="snip1382">
						<img src="genre/img/sf.jpg" alt="공상과학" />
						<figcaption>
							<h2>S&nbsp;&nbsp;F</h2>
							<p>Science Fiction.</p>
						</figcaption>
					</figure>
			</a></td>
			<td><a href="Genre?cmd=list&genre=travel">
					<figure class="snip1382">
						<img src="genre/img/travel.jpg" alt="여행" />
						<figcaption>
							<h2>travel"</h2>
							<p>Travel.</p>
						</figcaption>
					</figure>
			</a></td>
		</tr>
	</table>
</body>
<%@ include file="../include/footer.jsp"%>
</html>