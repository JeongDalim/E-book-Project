package action.bookcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.bookcart.BookCartDAO;

public class BookCartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();
		int bookIdx = Integer.parseInt(request.getParameter("idx"));
		BookCartDAO dao = BookCartDAO.getInstance();
		BookDAO dao2 = BookDAO.getInstance();

		String fileName = dao2.book_view(bookIdx).getFileName();
		String bookName = dao2.book_view(bookIdx).getBookName();
		int price = dao2.book_view(bookIdx).getPrice();

		if (dao.insert(memberId, bookIdx, fileName, bookName, price) != 0) {
			out.print("<script>alert('Successfully completed.'),location.href='Book?cmd=view&idx=" + bookIdx + "'</script>");
		}
	}
}
