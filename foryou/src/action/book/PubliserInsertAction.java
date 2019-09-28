package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;

public class PubliserInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("session").toString();
		BookDAO dao = BookDAO.getInstance();
		String company = dao.campanysearch(id);
		request.setAttribute("company", company);
		RequestDispatcher rd = request.getRequestDispatcher("bookInfo/insert.jsp");
		rd.forward(request, response);

	}

}
