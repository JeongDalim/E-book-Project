package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class PwSearch1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idsea = request.getParameter("idsea");
		request.setAttribute("idsea", idsea);
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		String business = request.getParameter("business");
		request.setAttribute("business", business);
		System.out.println(business);
		System.out.println(id);
		MemberDAO dao = MemberDAO.getInstance();
		int row = 0;
		int row2 = 2;
		if (business == null) {
			RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1.jsp");
			rd.forward(request, response);
		} else {
			if (business.equals("no")) {
				row = dao.mIdExit(id);
			} else {
				row = dao.bIdExit(id);
				row2 = dao.agreeCheck(id);
			}
			System.out.println(row);
			request.setAttribute("id", id);
			if (row == 0) {
				request.setAttribute("row", row);
				RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch_idfail.jsp");
				rd.forward(request, response);
			} else {
				if (row2 != 2) {// 2:승인o, 1:대기, 3:거절
					request.setAttribute("row", row);
					request.setAttribute("row2", row2);
					RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch_idfail.jsp");
					rd.forward(request, response);
				} else {
					if (business.equals("no")) {
						request.setAttribute("row", row);
						RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1.jsp");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1_p.jsp");
						rd.forward(request, response);
					}

				}
			}
		}
	}

}
