<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@ include file="../include/topmenu_genre.jsp"%>
	<div class="">
		<div class="" style="padding-top: 80px; width: 70%; margin: 0 auto;">
			<form name="ff" method="post" action="Book?cmd=bookinsert_pro"
				enctype="multipart/form-data">
				<input type="hidden" name="published" value="yes">
				<table class="Login_tab_M">
					<tr>
						<td colspan="3"><input type="text" name="bookname"
							placeholder="title" maxlength="20" value=""></td>

					</tr>
					<tr>
						<td colspan="3"><input type="text" name="writer"
							placeholder="writer" maxlength="20" value=""></td>
					</tr>
					<tr>
						<td colspan="3"><input type="text" name="company"
							placeholder="publisher" maxlength="20" value="${company }"
							readonly></td>
					</tr>
					<tr>
						<td colspan="3"><input type="text" name="pdate"
							placeholder="published date" maxlength="20" value=""></td>
					</tr>
					<tr>
						<td colspan="3"><input type="text" name="price"
							placeholder="price" maxlength="20" value=""></td>
					</tr>
					<tr>
						<td colspan="3"><input type="text" name="intro"
							placeholder="intro" value=""></td>
					</tr>
					<tr>
						<td>Genre</td>
						<td colspan="2"><input type="checkbox" name="genre"
							value="af">Chivalry <input type="checkbox" name="genre"
							value="development">Self-improvement <input
							type="checkbox" name="genre" value="economic">Economic <input
							type="checkbox" name="genre" value="finance">Finance <input
							type="checkbox" name="genre" value="health">Health and
							Life <input type="checkbox" name="genre" value="humanities">Humanity<br>
							<input type="checkbox" name="genre" value="novel">Novel<input
							type="checkbox" name="genre" value="romance">Romance <input
							type="checkbox" name="genre" value="sf">SF <input
							type="checkbox" name="genre" value="travel">Travel</td>
					</tr>
					<tr>
						<td width="70px">Introduction</td>
						<td colspan="2"><textarea name="bookplot" rows="10"
								wrap="soft"></textarea></td>
					</tr>
					<tr>
						<td>Cover</td>
						<td colspan="2"><input type="file" name="filename" value=""></td>
					</tr>
					<tr>
						<td>Contents</td>
						<td colspan="2"><input type="file" name="contents" value=""></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="Login_button2">
			<table>
				<tr>
					<td><a href="#" onclick="ck()"><input type="button"
							value="send"></a></td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>