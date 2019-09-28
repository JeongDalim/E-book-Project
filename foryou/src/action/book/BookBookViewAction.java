package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class BookBookViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BookDAO dao = BookDAO.getInstance();
		BookVO vo = dao.book_view(idx);
		String filename = vo.getFileName();
		String contents = vo.getContents();
		String idx2 = request.getParameter("idx");
		int contentssize = 6;
		HttpSession session = request.getSession();
		String member_id = session.getAttribute("session").toString();
		int bookmark = dao.bookmarksearch(member_id, idx2);
		request.setAttribute("bookmark", bookmark);
		request.setAttribute("idx", idx);
		request.setAttribute("filename", filename);
		request.setAttribute("contents", contents);
		request.setAttribute("contentssize", contentssize);

		RequestDispatcher rd = request.getRequestDispatcher("bookview/samples/basic/bookview.jsp");
		rd.forward(request, response);
	}
}
