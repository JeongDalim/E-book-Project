package action.bookcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;
import model.bookcart.BookCartDAO;
import model.rent.RentDAO;
import model.sales.SalesDAO;
import model.sales.SalesVO;

public class BookRentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();
		String idxs = request.getParameter("idxs");
		int bookIdx = 0;
		if (request.getParameter("idx") != null) {
			bookIdx = Integer.parseInt(request.getParameter("idx"));
			BookCartDAO dao = BookCartDAO.getInstance();
			RentDAO dao2 = RentDAO.getInstance();
			BookDAO bookdao = BookDAO.getInstance();

			dao2.plusRentCnt(bookIdx); // �젋�듃移댁슫�듃 利앷� 硫붿냼�뱶
			BookVO bookvo = bookdao.book_view(bookIdx);
			String company = bookvo.getCompany(); // 媛� 異쒗뙋�궗蹂� 留ㅼ텧�븸�쓣 �쐞�븳 �옉�뾽
			int price = bookvo.getPrice();
			LocalDate date = LocalDate.now();
			int year = date.getYear();
			int month = date.getMonthValue();
			int day = date.getDayOfMonth();
			String name = bookvo.getBookName();
			if (session.getAttribute("gubun") == null) {// �씪諛섑쉶�썝
				SalesVO salesvo = new SalesVO();
				salesvo.setCompany("foryou");
				salesvo.setYear(year);
				salesvo.setMonth(month);
				salesvo.setDay(day);
				salesvo.setSales(price);
				salesvo.setName(name);
				SalesDAO salesdao = SalesDAO.getInstance();
				salesdao.salesinsert(salesvo); // 留ㅼ텧�븸 �벑濡�

				SalesVO salesvo2 = new SalesVO();
				salesvo2.setCompany(company);
				salesvo2.setYear(year);
				salesvo2.setMonth(month);
				salesvo2.setDay(day);
				salesvo2.setSales(price);
				salesvo2.setName(name);
				salesdao.salesinsert(salesvo2); // 留ㅼ텧�븸 �벑濡�

			} else {
				SalesVO salesvo = new SalesVO();
				salesvo.setCompany(company);
				salesvo.setYear(year);
				salesvo.setMonth(month);
				salesvo.setDay(day);
				salesvo.setSales(price);
				salesvo.setName(name);
				SalesDAO salesdao = SalesDAO.getInstance();
				salesdao.salesinsert(salesvo); // 留ㅼ텧�븸 �벑濡�

			}

			if (dao.delete(memberId, bookdao.book_view(bookIdx).getBookName()) != 0
					&& dao2.bookRent(memberId, bookIdx) != 0) {

				out.print("<script>alert('Successfully completed.'),location.href='BookCart?cmd=bookCart'</script>");
			}
		}
		if (request.getParameterValues("bookCart") != null) {
			String[] bookCart = request.getParameterValues("bookCart");

			for (int i = 0; i < bookCart.length; i++) {
				System.out.println(bookCart[i]);
			}

			System.out.println("test");
			// String[] bookIdxs = idxs.split(",");
			BookCartDAO dao = BookCartDAO.getInstance();
			RentDAO dao2 = RentDAO.getInstance();
			BookDAO bookdao = BookDAO.getInstance();

			/*
			 * for (int i = 0; i < bookIdxs.length; i++) {
			 * 
			 * System.out.println(bookIdxs[i]); int bookIdx2 =
			 * Integer.parseInt(bookIdxs[i]); String[] bookNames = new
			 * String[bookIdxs.length];
			 */
			String[] bookNames = new String[bookCart.length];
			for (int i = 0; i < bookCart.length; i++) {
				System.out.println(bookCart.length);
				int bookIdx2 = Integer.parseInt(bookCart[i]);
				System.out.println("bookidx2:" + bookIdx2);
				bookNames[i] = bookdao.book_view(bookIdx2).getBookName();
				System.out.println("bookname:" + bookNames[i]);

				dao2.plusRentCnt(bookIdx2); // �젋�듃移댁슫�듃 利앷� 硫붿냼�뱶
				BookVO bookvo = bookdao.book_view(bookIdx2);
				String company = bookvo.getCompany(); // 媛� 異쒗뙋�궗蹂� 留ㅼ텧�븸�쓣 �쐞�븳 �옉�뾽
				int price = bookvo.getPrice();
				LocalDate date = LocalDate.now();
				int year = date.getYear();
				int month = date.getMonthValue();
				int day = date.getDayOfMonth();
				String name = bookvo.getBookName();
				if (session.getAttribute("gubun") == null) {// �씪諛섑쉶�썝
					SalesVO salesvo = new SalesVO();
					salesvo.setCompany("foryou");
					salesvo.setYear(year);
					salesvo.setMonth(month);
					salesvo.setDay(day);
					salesvo.setSales(price);
					salesvo.setName(name);
					SalesDAO salesdao = SalesDAO.getInstance();
					salesdao.salesinsert(salesvo); // 留ㅼ텧�븸 �벑濡�

					SalesVO salesvo2 = new SalesVO();
					salesvo2.setCompany(company);
					salesvo2.setYear(year);
					salesvo2.setMonth(month);
					salesvo2.setDay(day);
					salesvo2.setSales(price);
					salesvo2.setName(name);
					salesdao.salesinsert(salesvo2); // 留ㅼ텧�븸 �벑濡�

				} else {
					SalesVO salesvo = new SalesVO();
					salesvo.setCompany(company);
					salesvo.setYear(year);
					salesvo.setMonth(month);
					salesvo.setDay(day);
					salesvo.setSales(price);
					salesvo.setName(name);
					SalesDAO salesdao = SalesDAO.getInstance();
					salesdao.salesinsert(salesvo); // 留ㅼ텧�븸 �벑濡�

				}
			}

			for (int i = 0; i < bookNames.length; i++) {
				System.out.println(bookNames[i]);
			}

			if (dao.delete(memberId, bookNames) != 0 && dao2.bookRent(memberId, bookCart) != 0) {

				out.print("<script>alert('Successfully completed.'),location.href='BookCart?cmd=bookCart'</script>");
			}
		}
	}
}
