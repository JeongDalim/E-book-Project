package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class IdSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idsea = request.getParameter("idsea");
		request.setAttribute("idsea", idsea);
		RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch.jsp");
		rd.forward(request, response);
	}

}