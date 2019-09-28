package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class MemberInsert3Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String gudok = request.getParameter("gudok");
		String card = request.getParameter("card");
		String cvc = request.getParameter("cvc");
		String bank = request.getParameter("bank");
		String bankpw = request.getParameter("bankpw");
		if (!card.equals("") && !cvc.equals("")) {
			request.setAttribute("card", card);
			request.setAttribute("cvc", cvc);
		}
		if (!bank.equals("") && !bankpw.equals("")) {
			request.setAttribute("bank", bank);
			request.setAttribute("bankpw", bankpw);
		}
		if (gudok != null) {
			request.setAttribute("gudok", gudok);
		}

		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("tel", tel);

		RequestDispatcher rd = request.getRequestDispatcher("member/MemberInsert3.jsp");
		rd.forward(request, response);
	}

}
