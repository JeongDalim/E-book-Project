package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class BookPageProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=Integer.parseInt(request.getParameter("pagename"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		int bookmark=Integer.parseInt(request.getParameter("bookmark"));
		
		BookDAO dao = BookDAO.getInstance();
		BookVO vo = dao.book_view(idx);
		int contentssize = Integer.parseInt(request.getParameter("contentssize"));
		
		String filename = vo.getFileName();
		request.setAttribute("bookmark", bookmark);
		request.setAttribute("page", page);
		request.setAttribute("filename", filename);
		request.setAttribute("idx", idx);
		request.setAttribute("contentssize", contentssize);
		RequestDispatcher rd = request.getRequestDispatcher("bookview/samples/basic/bookview.jsp");
		rd.forward(request, response);
	}
}
