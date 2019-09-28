package action.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;

public class AdminRequestOKAction2 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		RequestDAO dao = RequestDAO.getInstance();
		
		int row = dao.gubunUpdate2(idx);

		PrintWriter out = response.getWriter();
		if(row==0) {
			out.println("<script>alert('승인취소에 실패하였습니다.');  location.href='Request?cmd=request_listGet';</script>");
			
		}else {
			
			out.println("<script>alert('승인 취소 되었습니다.');  location.href='Request?cmd=request_listGet';</script>");
			out.flush();
			
		}
		


	}


}
