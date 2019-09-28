package model.member;

public class PublisherVO {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	private String rentlist;
	private String genre;
	private String subdate;
	private String bno;
	private String bfile;
	private int agree;

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

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public int getAgree() {
		return agree;
	}

	public void setAgree(int agree) {
		this.agree = agree;
	}

	public String getRentlist() {
		return rentlist;
	}

	public void setRentlist(String rentlist) {
		this.rentlist = rentlist;
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

}
