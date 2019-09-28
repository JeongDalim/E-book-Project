<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="bookInfo/css/style.css" rel="stylesheet" />
<script type="text/javascript">
	function ck() {
		if (ff.bookname.value == "") {
			alert("Please enter the bookname.");
			ff.bookname.focus();
			return;
		} else if (ff.writer.value == "") {
			alert("Please enter the writer.");
			ff.writer.focus();
			return;
		} else if (ff.price.value == "") {
			alert("Please enter the price .");
			ff.price.focus();
			return;
		} else if (ff.intro.value == "") {
			alert("Please enter the intro.");
			ff.intro.focus();
			return;
		} else if (ff.bookplot.value == "") {
			alert("Please enter the  introduction.");
			ff.bookplot.focus();
			return;
		} else if (ff.filename.value == "") {
			alert("Please upload the Cover.");
			ff.filename.focus();
			return;
		} else if (ff.contents.value == "") {
			alert("Please uploade Contents.");
			ff.contents.focus();
			return;
		} else {
			ff.submit();
		}
	}
</script>
</head>
<body>
	<div class="">
		<div class="">
			<form name="ff" method="post"
				action="Book?cmd=bookmodify_pro&idx=${vo.idx }"
				enctype="multipart/form-data">
				<table class="Login_tab_M">

					<tr>
						<td width="200px">Title</td>
						<td colspan="2"><input type="text" name="bookname"
							maxlength="20" value="${vo.bookName }"></td>

					</tr>
					<tr>
						<td>Writer</td>
						<td colspan="2"><input type="text" name="writer"
							maxlength="20" value="${vo.writer }"></td>
					</tr>
					<tr>
						<td>Publisher</td>
						<td colspan="2"><input type="text" name="company"
							maxlength="20" value="${vo.company }" readonly></td>
					</tr>
					<tr>
						<td>Published date</td>
						<td colspan="2"><input type="text" name="pdate"
							maxlength="20" value="${vo.pdate }"></td>
					</tr>
					<tr>
						<td>Price</td>
						<td colspan="2"><input type="text" name="price"
							maxlength="20" value="${vo.price }"></td>
					</tr>
					<tr>
						<td>Intro</td>
						<td colspan="2"><input type="text" name="intro"
							value="${vo.intro }"></td>
					</tr>
					<tr>
						<td>Genre</td>
						<td colspan="2"><input type="checkbox" name="genre"
							value="af"
							<c:if test="${vo.genre.contains('af') }"> checked </c:if>>Chivalry
							<input type="checkbox" name="genre" value="development"
							<c:if test="${vo.genre.contains('development') }"> checked </c:if>>Self-improvement
							<input type="checkbox" name="genre" value="economic"
							<c:if test="${vo.genre.contains('economic') }"> checked </c:if>>Economic
							<input type="checkbox" name="genre" value="finance"
							<c:if test="${vo.genre.contains('finance') }"> checked </c:if>>Finance
							<input type="checkbox" name="genre" value="health"
							<c:if test="${vo.genre.contains('health') }"> checked </c:if>>Health
							and Life <input type="checkbox" name="genre" value="humanities"
							<c:if test="${vo.genre.contains('humanities') }"> checked </c:if>>Humanity<br>
							<input type="checkbox" name="genre" value="novel"
							<c:if test="${vo.genre.contains('novel') }"> checked </c:if>>Novel
							<input type="checkbox" name="genre" value="romance"
							<c:if test="${vo.genre.contains('romance') }"> checked </c:if>>Romance
							<input type="checkbox" name="genre" value="sf"
							<c:if test="${vo.genre.contains('sf') }"> checked </c:if>>SF
							<input type="checkbox" name="genre" value="travel"
							<c:if test="${vo.genre.contains('travel') }"> checked </c:if>>Travel</td>
					</tr>
					<tr>
						<td>introduction</td>
						<td colspan="2"><textarea name="bookplot" rows="10"
								wrap="soft">${vo.bookPlot } </textarea></td>
					</tr>
					<tr>
						<td>Cover</td>
						<td><input type="file" name="filename" value=""></td>
						<td>*If you not Upload<br>,your information Don't
							changed*
						</td>
					</tr>
					<tr>
						<td>Contents</td>
						<td><input type="file" name="contents" value=""></td>
						<td>*If you not Upload<br>,your information Don't
							changed.*
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="Login_button2">
			<table>
				<tr>
					<td><input type="button" value="수정" onclick="ck()"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>