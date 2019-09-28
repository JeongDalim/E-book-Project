package action.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class RequestWriteGetAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int nowpage = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("nowpage", nowpage);
		
		RequestDispatcher rd  = request.getRequestDispatcher("request/request_write.jsp");
		rd.forward(request, response);

		
	}

}
