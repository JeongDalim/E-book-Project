package model.rent;

public class RentVO {
	private int custNo;// 회원번호(Not Null)
	private int bookNo;// 책번호(Not Null)
	private String outdate; // 잔여일(Not Null)
	private String indate; // 대여일(Not Null/Default Sysdate)

	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

}
