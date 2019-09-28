package action.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import util.PopTime;

public class PopNoSeeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(86400 - PopTime.popTime());
		session.setAttribute("pop", session);
		out.print("<script>window.close();</script>");
	}
}
