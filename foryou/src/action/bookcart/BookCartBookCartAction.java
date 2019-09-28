package action.bookcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.bookcart.BookCartDAO;

public class BookCartBookCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookCartDAO dao = BookCartDAO.getInstance();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();
		request.setAttribute("myBookCart", dao.myBookCart(memberId));
		RequestDispatcher rd = request.getRequestDispatcher("bookcart/bookcart.jsp");
		rd.forward(request, response);

	}

}
