package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class MemberSubscriptPayUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("member/subscriptPay_u.jsp");
		rd.forward(request, response);
	}

}
