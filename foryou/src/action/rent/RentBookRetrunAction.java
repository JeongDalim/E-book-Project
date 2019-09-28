package action.rent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.rent.RentDAO;

public class RentBookRetrunAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberId = session.getAttribute("session").toString();
		int bookIdx = Integer.parseInt(request.getParameter("idx"));
		RentDAO dao = RentDAO.getInstance();
		if (dao.bookReturn(memberId, bookIdx) != 0) {
			out.print("<script>alert('successfully completed.');</script>");
			response.sendRedirect("Book?cmd=view&idx=" + bookIdx);
		}
	}
}
