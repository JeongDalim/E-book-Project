package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("session");
		//System.out.println(id);
		String agree = request.getParameter("agree");
		int row = 0;
		if(agree.equals("")) {//회원탈퇴
			row=dao.memberDelete(id);
		}else {//출판사탈퇴
			row=dao.publisherDelete(id);
		}
		request.setAttribute("row", row);
		//System.out.println(row);
		if(row!=0) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("start.jsp");
		rd.forward(request, response);
	}
}
