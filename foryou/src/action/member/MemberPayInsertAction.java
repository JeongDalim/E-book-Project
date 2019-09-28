package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;

public class MemberPayInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pay = request.getParameter("pay");
		MemberDAO dao = MemberDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session");
		int row = 0;
		if(pay.equals("card")) {
			String card = request.getParameter("cardnum");
			String cvc = request.getParameter("cvc");
			row = dao.memberCardInsert(card, cvc, id);
			System.out.println(row);
		}else {
			String bank = request.getParameter("bank");
			String bankpw = request.getParameter("bankpw");
			row = dao.memberBankInsert(bank, bankpw, id);
			System.out.println(row);
		}		
		RequestDispatcher rd = request.getRequestDispatcher("Member?cmd=MemberPayCheck");
		rd.forward(request, response);
	}
}
