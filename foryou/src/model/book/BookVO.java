package model.book;

public class BookVO {
	private int idx;// 책고유번호(Not Null,Primary Key)
	private String writer;// 작가(Not Null)
	private String bookName;// 책이름(Not Null)
	private String genre;// 장르(Not Null)
	private String contents;// 내용(Not Null)
	private String intro; // 인트로(Not Null)
	private int price; // 가격(Not Null)
	private int rentcnt; // 대여수(Default 0)
	private String company; // 출판사
	private String pdate;// 출판일
	private String fileName; // 도서표지(Not Null)
	private String indate;// 등록일(Default Sysdate)
	private String bookPlot;// 간단한소개(Not Null)
	private String published; // 출판여부

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRentcnt() {
		return rentcnt;
	}

	public void setRentcnt(int rentcnt) {
		this.rentcnt = rentcnt;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getBookPlot() {
		return bookPlot;
	}

	public void setBookPlot(String bookPlot) {
		this.bookPlot = bookPlot;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}
}
