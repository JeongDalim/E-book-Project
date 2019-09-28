package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class RDMemberPayUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		request.setAttribute("idx", idx);
		String[] bookIdxs = request.getParameterValues("bookCart");
		request.setAttribute("bookCart", bookIdxs);
		String idxs = request.getParameter("idxs");
		request.setAttribute("idxs", idxs);
		RequestDispatcher rd = request.getRequestDispatcher("member/Pay2_u_rd.jsp");
		rd.forward(request, response);
	}

}
