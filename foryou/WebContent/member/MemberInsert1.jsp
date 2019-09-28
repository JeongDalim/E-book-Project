
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="Home/css/mystyle2.css" rel="stylesheet" />
<link href="member/css/Mem_style.css" rel="stylesheet" />
<script>
	function send() {
		var chk = document.getElementsByName("box");
		var chk_num = 0;
		for (var i = 0; i < chk.length; i++) {
			if (chk[i].checked == true) {
				chk_num += 1;
			}
		}
		if (chk_num != 2) {
			alert(" You should all agree on an agreement with information.");
			return;
		}
		form.action = "Member?cmd=insert2";
		form.submit();
	}
	function bsend() {
		var chk = document.getElementsByName("box");
		var chk_num = 0;
		for (var i = 0; i < chk.length; i++) {
			if (chk[i].checked == true) {
				chk_num += 1;
			}
		}
		if (chk_num != 2) {
			alert("You must accept the Terms and Conditions before creating an account.");
			return;
		}
		form.action = "Member?cmd=insert_B";
		form.submit();
	}
</script>
</head>
<body>
	<%@ include file="../include/topmenu.jsp"%>
	<div class="login_logo">FOR YOU</div>
	<div class="login_img">
		<table>
			<tr>
				<td><img src="member/img/insert1.png" /></td>
			</tr>
		</table>
	</div>
	<form name="form" method="post">
		<table class="Insert1_title">
			<tr>
				<td>
					<h2>Membership terms(Korea Version)</h2>
				</td>
			</tr>

			<tr>
				<td>Welcome to ForYou</td>
			</tr>
			<tr>
				<td>All of these services are available to our guests at a
					nominal information</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><h2>Terms and Conditions agreement(essential)</h2></td>
			</tr>
		</table>

		<table class="Login_tab_M2">
			<tr>
				<td><textarea>ForYou's Genereal Terms and Conditions and policy contains the following policy.

 

제 1장 총칙

제 2장 서비스 이용계약

제 3장 계약 당사자의 의무

제 4장 서비스 이용

제 5장 계약 해지 및 이용제한

제 6장 쇼핑몰 이용

제 7장 손해배상 및 기타 사항

 

제 1장 총칙

제 1 조 (목적)

본 약관은 서비스 이용자가 ㈜서울문화사(이하 “회사”라 한다)가 운영하는 인터넷 서비스 (이하 “서비스”라 한다)를 이용함에 있어 포유 ('http://www.foryou.co.kr/'이하 '포유') 및 포유 관련 제반 서비스(허스토어, 서울문화사 운영 쇼핑몰, 모바일 웹/앱포함) 이용에 하나의 아이디 및 비밀번호로 동시에 가입하여 이용함에 있어 회사와 회원과의 권리•의무 및 책임사항, 서비스 이용조건과 절차사항, 기타 필요한 사항을 규정함을 목적으로 합니다.

 

※ 「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다」

㈜ 서울문화사가 제공하는 온라인 서비스 

기타 회사가 자체 개발하거나 다른 회사와의 협력 계약 등을 통해 제공하는 일체의 서비스

</textarea></td>
			</tr>
		</table>
		<table class="Login_tab_M3">
			<tr>
				<td><input type="checkbox" name="box" value="">&nbsp;&nbsp;&nbsp;I
					agree to the Terms and Conditions.</td>
			</tr>
		</table>
		<h2 class="Insert1_title"></h2>
		<br>
		<table class="Login_tab_M2">
			<tr>
				<td><textarea>ForYou는 이용자의 개인정보를 중요시하며, “정보통신망 이용촉진 및 정보보호 등에 관한 법률”, “개인정보보호법” 등 개인 정보와 관련된 법령 상의 개인정보보호규정 및 방송통신위원회가 제정한 “개인정보보호지침”을 준수하고 있습니다.

본 개인정보취급방침은 회사가 제공하는 포유('http://www.foryou.co.kr/​'이하 '포유') 및 포유 관련 제반 서비스(허스토어, 모바일 웹/앱포함) 이용에 적용되며 개인정보 취급방침을 통하여 이용자가 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 적극적으로 보호하기 위해 항상 노력하고 있음에 대해 알려드립니다.

1. 수집 및 이용하는 개인정보 항목

포유는 회원가입, 원활한 고객상담, 각종 서비스 등 기본적인 서비스 제공을 위한 필수정보와 고객 맞춤 서비스 제공을 위한 선택정보로 구분하여 아래와 같은 개인정보를 수집하고 있습니다. 선택정보를 입력하지 않은 경우에도 서비스 이용 제한은 없으며 이용자의 기본적 인권 침해의 우려가 있는 민감한 개인 정보(인종, 사상 및 신조, 정치적 성향 이나 범죄기록, 의료정보 등)는 수집하지 않습니다.

1) 수집항목

① 회원 가입 및 서비스 이용

가. 회원 가입 및 서비스 이용 시

필수정보 : 이메일(아이디), 비밀번호, 별명
선택정보 : 연령대, 관심분야, 관심 매체 등 이용자 선호 정보 (콘텐츠 맞춤 제공 서비스 이용 시)

나. 외부 플랫폼 이용한 가입 시 (페이스북, 네이버 로그인)

필수정보 : 이메일(아이디), 비밀번호, 별명 (아이디로 사용되는 이메일 주소는 외부 플랫폼에서 제공받습니다.)
선택정보 : 연령대, 관심분야, 관심 매체 등 이용자 선호 정보 (콘텐츠 맞춤 제공 서비스 이용 시)

다. 기존 회원 전환 시

필수정보 : 기존 아이디(회원 확인용), 이메일(아이디), 비밀번호, 별명, 아이핀(본인인증), 휴대전화인증(본인인증)
선택정보 : 연령대, 관심분야, 관심 매체 등 이용자 선호 정보 (콘텐츠 맞춤 제공 서비스 이용 시)

라. 체험단, 이벤트, 설문조사 등 참여형 서비스 이용 시 : 이메일(아이디), 비밀번호, 별명, 이름, 성별, 나이 등 서비스 이용과 관련한 기타 정보

② 상품 구매 시

가. 상품배송을 위한 정보 : 이메일(아이디), 비밀번호, 이름, 전화번호, 휴대전화번호, 주소, 생년월일
나. 결제를 위한 정보 : 신용카드 정보, 은행계좌 정보, 결제 기록, 거래자 성명 등의 정보
다. 구독 목적 확인을 위한 정보

③ 기타
</textarea></td>
			</tr>
		</table>
		<table class="Login_tab_M3">
			<tr>
				<td><input type="checkbox" name="box" value="">&nbsp;&nbsp;&nbsp;I
					agree to the use of and collected private information</td>
			</tr>
		</table>
		<div class="Login_button2">
			<table>
				<tr>
					<c:if test="${who=='customer' }">
						<td><a href="#" onClick="send()"><input type="button"
								value="Check"></a></td>
					</c:if>
					<c:if test="${who=='business'}">
						<td><a href="#" onClick="bsend()"><input type="button"
								value="Check"></a></td>
					</c:if>
					<td class="Login_button3"><input type="button"
						value="I don't agree to it"></td>
				</tr>
			</table>
	</form>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>