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

public class BookCartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();
		int bookIdx = 0;
		if (request.getParameter("idx") != null) {
			bookIdx = Integer.parseInt(request.getParameter("idx"));
			BookCartDAO dao = BookCartDAO.getInstance();
			BookDAO dao2 = BookDAO.getInstance();
			if (dao.delete(memberId, dao2.book_view(bookIdx).getBookName()) != 0) {
				out.print("<script>alert('Successfully completed.');</script>");
				response.sendRedirect("BookCart?cmd=bookCart");
			}
		}
		if (request.getParameterValues("bookCart") != null) {
			String[] bookIdxs = request.getParameterValues("bookCart");
			BookCartDAO dao = BookCartDAO.getInstance();
			dao.delete(memberId, bookIdxs);
			response.sendRedirect("BookCart?cmd=bookCart");
		}

	}

}
