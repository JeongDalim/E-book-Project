package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import action.Action;
import sun.misc.BASE64Encoder;

public class PwcheckPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pw = request.getParameter("pw");
		String pass = request.getParameter("pass");
		String view = request.getParameter("view");
		String agree = request.getParameter("agree");
		String session = request.getParameter("session");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());

		if (pw.equals(pass)) {
			request.setAttribute("alert", "1");
		} else {
			request.setAttribute("alert", "-1");
		}
		request.setAttribute("view", view);
		RequestDispatcher rd = request.getRequestDispatcher("member/Pwcheck.jsp");
		rd.forward(request, response);

	}

}