package model.bookcart;

public class BookCartVO {
	private String memberId;
	private String bookIdx;
	private String fileName;
	private String bookName;
	private int quantity;
	private int price;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookIdx() {
		return bookIdx;
	}

	public void setBookIdx(String bookIdx) {
		this.bookIdx = bookIdx;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
