package model.member;

public class MemberVO {
	private int idx;// 회원번호(Not Null,Primary Key)
	private String id;// 아이디(Not Null)
	private String pw; // 비밀번호(Not Null)
	private String name;// 이름(Not Null)
	private String email;// 이메일(Not Null)
	private String tel;// 전화번호(Not Null)
	private String rentList;// 대여리스트
	private String genre;// 장르(Not Null)
	private String jangbaguni; // 장바구니
	private String subdate;// 구독신청일
	private String gubun; // 회원구분
	private String card; // 카드
	private String cvc; // cvc
	private String bank; // 은행
	private String bankpw; // 은행비번

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRentList() {
		return rentList;
	}

	public void setRentList(String rentList) {
		this.rentList = rentList;
	}

	public String getJangbaguni() {
		return jangbaguni;
	}

	public void setJangbaguni(String jangbaguni) {
		this.jangbaguni = jangbaguni;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSubdate() {
		return subdate;
	}

	public void setSubdate(String subdate) {
		this.subdate = subdate;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankpw() {
		return bankpw;
	}

	public void setBankpw(String bankpw) {
		this.bankpw = bankpw;
	}
}
