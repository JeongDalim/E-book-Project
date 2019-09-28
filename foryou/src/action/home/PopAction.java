package action.home;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;

public class PopAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getInstance();
		Random random = new Random();
		int r = random.nextInt(dao.noPublishedBook().size());
		request.setAttribute("book", dao.noPublishedBook().get(r)); // 출판예정책 랜덤
		RequestDispatcher rd = request.getRequestDispatcher("Home/pop.jsp");
		rd.forward(request, response);
	}
}
