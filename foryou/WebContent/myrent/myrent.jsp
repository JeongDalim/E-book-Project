<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>3D Restaurant Menu Concept</title>
<meta name="description"
	content="A responsive folded flyer-like restaurant menu with some 3D" />
<meta name="keywords"
	content="css3, perspective, 3d, jquery, transform3d, responsive, template, restaurant, menu, leaflet, folded, flyer, concept" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="myrent/css/style.css" />


<link
	href='http://fonts.googleapis.com/css?family=Raleway:300,500|Arvo:700'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="myrent/css/modernizr.custom.79639.js"></script>

<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-7243260-2' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
<title>My Book</title>
</head>
<body>
	<div class="container">
		<div class="codrops-top"></div>
		<!--/ Codrops top bar -->
		<header> </header>
		<section class="main">
			<div id="rm-container" class="rm-container">
				<div class="rm-wrapper">
					<div class="rm-cover">
						<div class="rm-front">
							<div class="rm-content">
								<a href="Home?cmd=Home"><div class="rm-logo"></div></a>
								<h2>For You</h2>
								<h3>This is for you</h3>
								<a href="#" class="rm-button-open">View the myBook</a>
								<div class="rm-info">
									<p>
										<strong>The book is to entertain and to inform.</strong><br>
										For You<br>
									<div class="rm-logo_img">
										<a href="Home?cmd=Home"><img
											src="myrent/img/foryoulogo.png"></a>
									</div>
								</div>
							</div>
							<!-- /rm-content -->
						</div>
						<!-- /rm-front -->
						<div class="rm-back">
							<div class="rm-content">
								<dl>
									<dt style="font-size: 30px;">support Your everyday Life</dt>
									<dd
										style="font-size: 35px; color: #93b9e6; padding-top: 200px; padding-bottom: 200px;">For
										You</dd>
									<dt style="font-size: 20px; padding-bottom: 10px;">of You
										by You for You</dt>
									<dt style="font-size: 30px;">
										the pleasure <br>of a book
									</dt>
								</dl>
							</div>
							<!-- /rm-content -->
							<div class="rm-overlay"></div>
						</div>
						<!-- /rm-back -->
					</div>
					<!-- /rm-cover -->
					<c:if test="${empty myRent }">
						<div class="rm-middle">
							<div class="rm-inner">
								<div class="rm-content">
									<h4>My Book</h4>
									The specified listing does not exist.
								</div>
								<!-- /rm-content -->
								<div class="rm-overlay"></div>
							</div>
							<!-- /rm-inner -->
						</div>
						<!-- /rm-middle -->

						<div class="rm-right">
							<div class="rm-front"></div>
							<div class="rm-back">
								<span class="rm-close">Close</span>
								<div class="rm-content">
									<div class="aaa" style="height: 520px;"></div>
									<div class="rm-order">
										<p>
											<strong>The book is to entertain and to inform.</strong> <br>
											<strong style="color: #93b9e6;">For You</strong>
										</p>
									</div>
								</div>
							</div>
							<!-- /rm-content -->
						</div>
					</c:if>

					<c:if test="${!empty myRent }">
						<div class="rm-middle">
							<div class="rm-inner">
								<div class="rm-content">
									<h4>My Book</h4>
									<c:forEach var="book" items="${myRent }">
										<dt>
											<a href="Book?cmd=bookview&idx=${book.idx }"
												class="rm-viewdetails" data-thumb="book/${book.fileName }">${book.bookName }</a>
										</dt>
										<dd>${book.bookPlot }</dd>
										<br>
										<br>
										<br>
									</c:forEach>


								</div>
								<!-- /rm-content -->
								<div class="rm-overlay"></div>
							</div>
							<!-- /rm-inner -->
						</div>
						<!-- /rm-middle -->

						<div class="rm-right">
							<div class="rm-front"></div>
							<div class="rm-back">
								<span class="rm-close">Close</span>
								<div class="rm-content">
									<div class="aaa" style="height: 520px;"></div>
									<div class="rm-order">
										<p>
											<strong>The book is to entertain and to inform.</strong> <br>
											<strong style="color: #93b9e6;">For You</strong>
										</p>
									</div>
								</div>
							</div>
							<!-- /rm-content -->
						</div>
					</c:if>

					<c:if test="${!empty myRent1 && !empty myRent2}">
						<div class="rm-middle">
							<div class="rm-inner">
								<div class="rm-content">
									<h4>My Book</h4>
									<c:forEach var="book" items="${myRent1 }">
										<dt>
											<a href="Book?cmd=bookview&idx=${book.idx }"
												class="rm-viewdetails" data-thumb="book/${book.fileName }">${book.bookName }</a>
										</dt>
										<dd>${book.bookPlot }</dd>
										<br>
										<br>
										<br>
									</c:forEach>
								</div>
								<!-- /rm-content -->
								<div class="rm-overlay"></div>
							</div>
							<!-- /rm-inner -->
						</div>
						<!-- /rm-middle -->

						<div class="rm-right">
							<div class="rm-front"></div>
							<div class="rm-back">
								<span class="rm-close">Close</span>
								<div class="rm-content">
									<c:forEach var="book" items="${myRent2 }">
										<dt>
											<a href="Book?cmd=bookview&idx=${book.idx }"
												class="rm-viewdetails" data-thumb="book/${book.fileName }">${book.bookName }</a>
										</dt>
										<dd>${book.bookPlot }</dd>
										<br>
										<br>
										<br>
									</c:forEach>
									<div class="aaa" style="height: 520px;"></div>
									<div class="rm-order">
										<p>
											<strong>The book is to entertain and to informs</strong> <br>
											<strong style="color: #93b9e6;">For You</strong>
										</p>
									</div>
								</div>
							</div>
							<!-- /rm-content -->
						</div>
					</c:if>


					<!-- /rm-back -->
				</div>
				<!-- /rm-right -->
			</div>
			<!-- /rm-wrapper -->
	</div>
	<!-- /rm-container -->
	</section>
	</div>
	<!-- jQuery if needed -->
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="myrent/css/menu.js"></script>
	<script type="text/javascript">
		$(function() {
			Menu.init();
		});
	</script>
</body>
</html>