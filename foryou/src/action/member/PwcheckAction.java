package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;
import model.member.PublisherVO;

public class PwcheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String agree = request.getParameter("agree");
		String id = request.getParameter("id");
		String view = request.getParameter("view");
		if(agree.equals("")) {
			MemberVO vo = dao.memberView(id);
			request.setAttribute("view", view);
			request.setAttribute("vo", vo);
			request.setAttribute("pw", vo.getPw());
		}else {
			PublisherVO vo = dao.publisherView(id);
			request.setAttribute("view", view);
			request.setAttribute("vo", vo);
			request.setAttribute("pw", vo.getPw());
		}
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("member/Pwcheck.jsp");
		rd.forward(request, response);
		
	}
	
}
