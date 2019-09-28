package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class PubliserModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BookDAO dao = BookDAO.getInstance();
		BookVO vo = dao.book_view(idx);

		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("bookInfo/modify.jsp");
		rd.forward(request, response);
	}
}
