package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class GotoPwModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idsea = request.getParameter("idsea");
		String id = request.getParameter("id");
		request.setAttribute("idsea", idsea);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("member/Pwmodify.jsp");
		rd.forward(request, response);
	}

}
