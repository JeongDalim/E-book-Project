package model.sales;

public class SalesVO {
	private String company;// 출판사 이름
	private int year;// 년도별
	private int month; // 월별
	private int day; // 일별
	private int sales; // 매출액
	private String name;// 책 이름

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}