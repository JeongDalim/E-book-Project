package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ReturnDate {
	public static String ReturnDate() {
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		cal.add(Calendar.DAY_OF_YEAR, 10); // 대여기간10일
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String returnDate = fm.format(cal.getTime());
		System.out.println(returnDate);
		return returnDate;
	}
}
