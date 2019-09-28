package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import action.Action;
import model.member.MemberDAO;
import sun.misc.BASE64Encoder;

public class PwModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String idsea = request.getParameter("idsea");
		System.out.println(idsea);
		String pw = request.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String id = request.getParameter("id");
		int row = 0;
		if (idsea.equals("publisher")) {
			row = dao.bpwModify(id, pw);
		} else {
			row = dao.pwModify(id, pw);
		}
		request.setAttribute("id", id);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("member/Pwmodify.jsp");
		rd.forward(request, response);
	}

}