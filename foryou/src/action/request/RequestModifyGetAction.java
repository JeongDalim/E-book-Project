package action.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;
import model.request.RequestVO;

public class RequestModifyGetAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nowpage = Integer.parseInt(request.getParameter("page"));

		request.setAttribute("nowpage", nowpage);
		int idx = Integer.parseInt(request.getParameter("idx"));

		RequestDAO dao = RequestDAO.getInstance();
		
		RequestVO vo = new RequestVO();
		vo = dao.requestView(idx);
		
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("request/request_modify.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
