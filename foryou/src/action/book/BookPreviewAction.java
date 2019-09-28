package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class BookPreviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BookDAO dao = BookDAO.getInstance();
		BookVO vo = dao.book_view(idx);
		String filename = vo.getFileName();
		request.setAttribute("filename", filename);
		request.setAttribute("idx", idx);

		RequestDispatcher rd = request.getRequestDispatcher("bookview/samples/basic/bookpreview.jsp");
		rd.forward(request, response);
	}

}
