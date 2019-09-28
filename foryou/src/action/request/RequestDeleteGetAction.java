package action.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;

public class RequestDeleteGetAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		try {

			int nowpage = Integer.parseInt(request.getParameter("page"));
			request.setAttribute("nowpage", nowpage);

			int idx = Integer.parseInt(request.getParameter("idx"));
			RequestDAO dao = RequestDAO.getInstance();

			int row = dao.requestDelete(idx);

			PrintWriter out = response.getWriter();

			if (row == 0) {
				out.println("<script>alert('failed');  location.href='Request?cmd=request_listGet';</script>");
				return;

			} else {
				out.println("<script>alert('successfully completed.');  location.href='Request?cmd=request_listGet';</script>");
				out.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
