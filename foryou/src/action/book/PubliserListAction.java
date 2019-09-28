package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class PubliserListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("session").toString();
		BookDAO dao = BookDAO.getInstance();
		String company = dao.campanysearch(id);
		List<BookVO> list = dao.my_insert_list(company);
		int count = list.size();
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("bookInfo/list.jsp");
		rd.forward(request, response);

	}

}
