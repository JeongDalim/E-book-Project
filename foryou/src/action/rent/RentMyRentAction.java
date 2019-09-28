package action.rent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookVO;
import model.rent.RentDAO;

public class RentMyRentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentDAO dao = RentDAO.getInstance();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();

		System.out.println(dao.myRent(memberId).size());
		if (dao.myRent(memberId).size() > 5) {
			List<BookVO> myRent1 = new ArrayList<BookVO>();
			List<BookVO> myRent2 = new ArrayList<BookVO>();
			for (int i = 0; i < 5; i++) {
				myRent1.add(dao.myRent(memberId).get(i));
			}

			for (int i = 5; i < dao.myRent(memberId).size(); i++) {
				myRent2.add(dao.myRent(memberId).get(i));
			}

			request.setAttribute("myRent1", myRent1);
			request.setAttribute("myRent2", myRent2);
		} else {
			request.setAttribute("myRent", dao.myRent(memberId));
		}
		RequestDispatcher rd = request.getRequestDispatcher("myrent/myrent.jsp");
		rd.forward(request, response);

	}

}
