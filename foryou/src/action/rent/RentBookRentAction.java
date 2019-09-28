package action.rent;

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
import model.member.MemberDAO;
import model.rent.RentDAO;
import model.sales.SalesDAO;
import model.sales.SalesVO;

public class RentBookRentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();

		int bookIdx = Integer.parseInt(request.getParameter("idx"));
		RentDAO dao = RentDAO.getInstance();
		BookDAO bookdao = BookDAO.getInstance();
		dao.plusRentCnt(bookIdx); // �젋�듃移댁슫�듃 利앷� 硫붿냼�뱶
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
			if (dao.bookRent(memberId, bookIdx) != 0) {
			out.print("<script>alert('successfully completed.'),location.href='Book?cmd=view&idx=" + bookIdx + "'</script>");
		}
	}
}
