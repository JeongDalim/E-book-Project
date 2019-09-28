package action.rent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.rent.RentDAO;

public class RentBookMarkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idx = request.getParameter("idx");
		int page = Integer.parseInt(request.getParameter("page"));
		RentDAO dao = RentDAO.getInstance();
		int row = dao.bookMark(page, idx);
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("bookview/samples/basic/bookmark_pro.jsp");
		rd.forward(request, response);

	}
}
