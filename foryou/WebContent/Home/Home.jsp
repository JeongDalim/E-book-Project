<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.book.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/mystyle.css" rel="stylesheet">
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link rel="stylesheet" title="Standard" href="Home/css/styles.css"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js">
	
</script>
<script type="text/javascript" src="Home/css/contentflow.js">
	
</script>
<script type="text/javascript">
	$(window).scroll(function() {
		var $el = $('.show-on-scroll');

		if ($(this).scrollTop() >= 1100)
			$el.addClass('shown');
		else
			$el.removeClass('shown');
	});

	var cf = new ContentFlow('contentFlow', {
		reflectionColor : "#000000"
	});

	$(function() {
		$('#show1').click(function() {
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden1').slideToggle("fast");
		});
		$('#show2').click(function() {
			$('.hidden1').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden2').slideToggle("fast");
		});
		$('#show3').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden4').hide();
			$('.hidden3').slideToggle("fast");
		});
		$('#show4').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').slideToggle("fast");
		});
		$('#show5').click(function() {
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden1').slideToggle("fast");
		});
		$('#show6').click(function() {
			$('.hidden1').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden2').slideToggle("fast");
		});
		$('#show7').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden4').hide();
			$('.hidden3').slideToggle("fast");
		});
		$('#show8').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').slideToggle("fast");
		});
		$('#show9').click(function() {
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden1').slideToggle("fast");
		});
		$('#show10').click(function() {
			$('.hidden1').hide();
			$('.hidden3').hide();
			$('.hidden4').hide();
			$('.hidden2').slideToggle("fast");
		});
		$('#show11').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden4').hide();
			$('.hidden3').slideToggle("fast");
		});
		$('#show12').click(function() {
			$('.hidden1').hide();
			$('.hidden2').hide();
			$('.hidden3').hide();
			$('.hidden4').slideToggle("fast");
		});
	});

	function pop(pop) {
		if (pop == "") {
			var url = "Home?cmd=pop";
			window.open(url, 'window팝업',
					'width=300, height=300, menubar=no, status=no, toolbar=no');
		}
	}
</script>
</head>
<body onload="pop('${pop}')">
	<c:if test="${row==1 && empty agree}">
		<%@ include file="../include/Remote.jsp"%>
	</c:if>
	<c:if test="${row==2 }">
		<%@ include file="../include/Remote3.jsp"%>
	</c:if>
	<%@ include file="../include/topmenu.jsp"%>
	<video class="home_viedo" width="100%" controls muted autoplay>
		<c:if test="${row==1 }">
			<source src="Home/img/main_vedio.mp4" type="video/mp4">
		</c:if>
		<c:if test="${row==2 }">
			<source src="Home/img/night.mp4" type="video/mp4">
		</c:if>
	</video>
	<c:if test="${not empty myRent }">
		<jsp:include page="nowread.jsp"></jsp:include>
	</c:if>
	<jsp:include page="nowreview.jsp"></jsp:include>
	<div id="div4"></div>
	<div class="index_about">
		<div class="index_about_contents">
			<h2 class="index_about_contents_title">
				ABOUT<br>
				<div class="index_about_contents_title_re">FOR YOU</div>
			</h2>
			<div class="index_about_contents_contents">
				ForYou Books 는 2019년 국내 최고 월정액 도서서비스, 국내 점유율 1위를 달성한 대한민국 대표 E-book
				플랫폼으로서 <br> 기존의 서재가 단순히 내가 읽었던 책을 볼 수 있는 공간이었다면, ForYou Books는
				바쁜 사회생활에 지친 현대인들들의 피로를<br> 잠시나마 놓게해줄 작은 쉼터입니다. 책을 보고, 책에 대한
				포스트를 쓰면 다른 사람이 와서 댓글을 달고 소통이 가능합니다.<br> ForYou Books 는 2019년에도
				멈추지 않고 다양한 IP를 보유한 글로벌 크리에이티브 스튜디오로 도약할 것입니다.
			</div>
		</div>
		<div class="index_about_viedo">
			<video controls width="700" height="400"
				poster="Home/pics/foryoulogo.png">
				<source src="Home/img/foryou.mp4" type="video/mp4">
			</video>

		</div>
	</div>
	<div id="div1"></div>
	<div class="home_today_title">TodayBook</div>
	<div class="home_today"
		<c:if test="${row==2 }">style="background-image: url(Home/pics/Nt.png);"</c:if>>

		<img src="book/${todaybook.fileName }" />
		<div class="home_today_sub">
			<a href="Book?cmd=view&idx=${todaybook.idx }">#${todaybook.bookName}
				&nbsp; #${todaybook.writer } &nbsp; #${todaybook.genre }</a>
		</div>
	</div>
	<div id="div2"></div>
	<div class="home_Best"
		<c:if test="${row==2 }">style="background-color: #0e2438;"</c:if>>
		<div class="home_Best_title">
			Bestseller
			<div id="contentFlow" class="ContentFlow">

				<div class="loadIndicator">
					<div class="indicator"></div>
				</div>
				<div class="flow">
					<c:forEach var="book" items="${bestseller }">
						<div class="item">
							<img class="content" src="book/${book.fileName }" /><a
								href="Book?cmd=view&idx=${book.idx }">${book.bookName }</a>
						</div>
					</c:forEach>

					<div class="globalCaption"></div>
					<div class="scrollbar">
						<div class="slider">
							<div class="position"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="home_icon">
			<table>
				<c:if test="${row==1 }">
					<tr>
						<td><a href="#go1" id="show1"><img src="Home/pics/BH.png" /></a></td>
						<td><a href="#go1" id="show2"><img src="Home/pics/BI.png" /></a></td>
						<td><a href="#go1" id="show3"><img src="Home/pics/BE.png" /></a></td>
						<td><a href="#go1" id="show4"><img src="Home/pics/BS.png" /></a></td>
					</tr>
				</c:if>
				<c:if test="${row==2 }">
					<tr>
						<td><a href="#go1" id="show1"><img src="Home/pics/H2.png" /></a></td>
						<td><a href="#go1" id="show2"><img src="Home/pics/I2.png" /></a></td>
						<td><a href="#go1" id="show3"><img src="Home/pics/E2.png" /></a></td>
						<td><a href="#go1" id="show4"><img src="Home/pics/S2.png" /></a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
	<div id="div3"></div>
	<div class="home_New"
		<c:if test="${row==2 }">style="color:#fff; background-image: url(Home/pics/nn.png);  background-repeat: no-repeat; background-position: center; background-position: top; background-color: #000000;"</c:if>>
		<div class="home_New_title"
			<c:if test="${row==2 }">style="color:#fff;"</c:if>>
			New
			<div id="contentFlow" class="ContentFlow">

				<div class="loadIndicator">
					<div class="indicator"></div>
				</div>
				<div class="flow">
					<c:forEach var="book" items="${newbook }">
						<div class="item">
							<img class="content" src="book/${book.fileName }" /> <a
								href="Book?cmd=view&idx=${book.idx }">${book.bookName }</a>
						</div>
					</c:forEach>
					<div class="globalCaption"></div>
					<div class="scrollbar">
						<div class="slider">
							<div class="position"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="home_icon">
			<table>
				<c:if test="${row==1 }">
					<tr>
						<td><a href="#go1" id="show5"><img src="Home/pics/NH.png" /></a></td>
						<td><a href="#go1" id="show6"><img src="Home/pics/NI.png" /></a></td>
						<td><a href="#go1" id="show7"><img src="Home/pics/NE.png" /></a></td>
						<td><a href="#go1" id="show8"><img src="Home/pics/NS.png" /></a></td>
					</tr>
				</c:if>
				<c:if test="${row==2 }">
					<tr>
						<td><a href="#go1" id="show5"><img
								src="Home/pics/NH2.png" /></a></td>
						<td><a href="#go1" id="show6"><img
								src="Home/pics/NI2.png" /></a></td>
						<td><a href="#go1" id="show7"><img
								src="Home/pics/NE2.png" /></a></td>
						<td><a href="#go1" id="show8"><img
								src="Home/pics/NS2.png" /></a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
	<c:if test="${!empty session }">
		<div id="div5"></div>
		<div class="index_about">
			<div class="index_about_contents">
				<h2 class="index_about_contents_title">
					오직 당신을 위한<br>
					<div class="index_about_contents_title_re">FOR YOU</div>
				</h2>
				<div class="index_about_contents_img">
					<table>
						<tr>
							<c:forEach var="book" items="${foryou }">
								<td><img src="book/${book.fileName }" /></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="book" items="${foryou }">
								<td><c:if test="${book.bookName.length()>7 }">
										<a href="Book?cmd=view&idx=${book.idx }"><span
											style="color: black;">${book.bookName.substring(0,6) }<br>${book.bookName.substring(6) }</span></a>
									</c:if> <c:if test="${book.bookName.length()<7 }">
										<a href="Book?cmd=view&idx=${book.idx }"><span
											style="color: black;">${book.bookName }</span></a>
									</c:if></td>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
			<div class="home_icon">
				<table>
					<tr>
						<td><a href="#go1" id="show9"><img src="Home/pics/H.png" /></a></td>
						<td><a href="#go1" id="show10"><img src="Home/pics/I.png" /></a></td>
						<td><a href="#go1" id="show11"><img src="Home/pics/E.png" /></a></td>
						<td><a href="#go1" id="show12"><img src="Home/pics/S.png" /></a></td>
					</tr>
				</table>
			</div>
		</div>
	</c:if>
	<div id="go1"></div>

	<div class="hidden1">
		<div class="home_icon">
			<table>
				<tr>
					<td class="heart_san"></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<table class="san2_table">
				<tr>
					<td colspan="3"><br> <br> <br></td>
				</tr>
				<tr>
					<td colspan="3">안녕 :)</td>
				</tr>
				<tr>
					<td colspan="3">나는 평범한 하루 중,</td>
				</tr>
				<tr>
					<td colspan="3">행복한 하루를 보내고 있는 중이에요.</td>
				</tr>
				<tr>
					<td class="san2_table_3" colspan="3">당신도 오늘 하루 행복한 하루가 되었기를
						바래요 :)</td>
				</tr>
				<tr class="san2_table_img">
					<c:set var="count" value="1" />
					<c:forEach var="book" items="${emoticonlist }">
						<c:if test="${count < 4 }">
							<c:if test="${book.genre.equals('romance') }">
								<td><a href="Book?cmd=view&idx=${book.idx }"> <img
										src="book/${book.fileName }"></a></td>
								<c:set var="count" value="${count+1 }" />
							</c:if>
						</c:if>
					</c:forEach>

				</tr>
				<tr>
					<td colspan="3" class="san2_table_4">책 그이상의 즐거움</td>
				</tr>
				<tr>
					<td colspan="3" class="san2_table_5">ForYou</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="hidden2">
		<div class="home_icon">
			<table>
				<tr>
					<td width="130px"></td>
					<td class="idea_san"></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<table class="san3_table">
				<tr>
					<td colspan="3"><br> <br> <br></td>
				</tr>
				<tr>
					<td colspan="3">남들처럼 혹은, 남들보다</td>
				</tr>
				<tr>
					<td colspan="3">열심히 살아왔을</td>
				</tr>
				<tr>
					<td colspan="3">오늘과 어제의 너에게.</td>
				</tr>
				<tr>
					<td colspan="3">아무도 너의 마음을 몰라주는것 같은</td>
				</tr>
				<tr>
					<td colspan="3">하루를 보내온 너에거.</td>
				</tr>
				<tr>
					<td colspan="3">넌 정말 잘하고 있고,</td>
				</tr>
				<tr>
					<td colspan="3">앞으로도 모든일이 잘 되거야</td>
				</tr>
				<tr>
					<td colspan="3"><br> <br></td>
				</tr>
				<tr>
					<td class="san2_table_3" colspan="3">수고했어 오늘도, 어제도</td>
				</tr>

				<tr class="san2_table_img">
					<c:set var="count" value="1" />

					<c:forEach var="book" items="${emoticonlist }">
						<c:if test="${count<4 }">
							<c:if test="${book.genre.equals('development') }">

								<td><a href="Book?cmd=view&idx=${book.idx }"><img
										src="book/${book.fileName }"></a></td>
								<c:set var="count" value="${count+1 }" />
							</c:if>
						</c:if>
					</c:forEach>

				</tr>
				<tr>
					<td colspan="3" class="san2_table_4" style="color: #000000;">책
						그이상의 즐거움</td>
				</tr>
				<tr>

					<td colspan="3" class="san2_table_5">ForYou</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="hidden3">
		<div class="home_icon">
			<table>
				<tr>
					<td></td>
					<td width="260px"></td>
					<td class="earth_san"></td>
					<td></td>
				</tr>
			</table>
			<table class="san4_table">
				<tr>
					<td colspan="3"><br> <br> <br></td>
				</tr>
				<tr>
					<td colspan="3">바쁜 일상에,</td>
				</tr>
				<tr>
					<td colspan="3">지친 나날들이</td>
				</tr>
				<tr>
					<td colspan="3">무색해질만큼,</td>
				</tr>
				<tr>
					<td colspan="3">널 위로해주고</td>
				</tr>
				<tr>
					<td colspan="3">안아주고싶어</td>
				</tr>
				<tr>
					<td colspan="3">모든걸 내려놓고</td>
				</tr>

				<tr>
					<td colspan="3"><br> <br></td>
				</tr>
				<tr>
					<td class="san2_table_3" colspan="3">어딘가로 훌쩍 떠나볼래?</td>
				</tr>

				<tr class="san2_table_img">
					<c:set var="count" value="1" />
					<c:forEach var="book" items="${emoticonlist }">
						<c:if test="${count<4 }">
							<c:if test="${book.genre.equals('travel') }">
								<td><a href="Book?cmd=view&idx=${book.idx }"><img
										src="book/${book.fileName }"></a></td>
								<c:set var="count" value="${count+1 }" />
							</c:if>
						</c:if>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="3" class="san2_table_4">책 그이상의 즐거움</td>
				</tr>
				<tr>

					<td colspan="3" class="san2_table_5">ForYou</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="hidden4">
		<div class="home_icon">
			<table>
				<tr>
					<td></td>
					<td></td>
					<td width="400px"></td>
					<td class="star_san"></td>
				</tr>
			</table>
			<table class="san5_table">
				<tr>
					<td colspan="3"><br> <br> <br></td>
				</tr>
				<tr>
					<td colspan="3">많이 힘들지?</td>
				</tr>
				<tr>
					<td colspan="3">다 이해해</td>
				</tr>
				<tr>
					<td colspan="3">정말 수고 많았어.</td>
				</tr>
				<tr>
					<td colspan="3">바쁜 일상 속 지쳐 있을 너에게</td>
				</tr>

				<tr>
					<td colspan="3"><br> <br></td>
				</tr>
				<tr>
					<td class="san2_table_3" colspan="3">수고했어 오늘도</td>
				</tr>

				<tr class="san2_table_img">
					<c:set var="count" value="1" />

					<c:forEach var="book" items="${emoticonlist }">
						<c:if test="${count<4 }">
							<c:if test="${book.genre.equals('novel') }">
								<td><a href="Book?cmd=view&idx=${book.idx }"><img
										src="book/${book.fileName }"></a></td>
								<c:set var="count" value="${count+1 }" />
							</c:if>
						</c:if>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="3" class="san2_table_4">책 그이상의 즐거움</td>
				</tr>
				<tr>

					<td colspan="3" class="san2_table_5">ForYou</td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>