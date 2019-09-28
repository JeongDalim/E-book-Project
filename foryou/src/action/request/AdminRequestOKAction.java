package action.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;


public class AdminRequestOKAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		System.out.println("愿�由ъ옄 �슂泥� 諛붽씀湲� ");
		
		//String gubun = request.getParameter("gubun");
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		RequestDAO dao = RequestDAO.getInstance();
		int row = dao.gubunUpdate(idx);

		PrintWriter out = response.getWriter();
		if(row==0) {
			out.println("<script>alert('Failed.');  location.href='Request?cmd=request_listGet';</script>");
			
		}else {
			
			out.println("<script>alert('successfully completed.');  location.href='Request?cmd=request_listGet';</script>");
			out.flush();
			
		}
		


	}

}
