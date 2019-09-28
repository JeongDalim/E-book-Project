package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class MemberInsert1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String who = request.getParameter("who");
		if (who.equals("customer")) {
			request.setAttribute("who", who);
		} else if (who.equals("business")) {
			request.setAttribute("who", who);
		}
		RequestDispatcher rd = request.getRequestDispatcher("member/MemberInsert1.jsp");
		rd.forward(request, response);
	}

}
