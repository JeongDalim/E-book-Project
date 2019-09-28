package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import action.Action;
import model.member.MemberDAO;
import model.member.PublisherVO;
import sun.misc.BASE64Encoder;

public class PmemberModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String agree = request.getParameter("agree");
		String session = request.getParameter("session");

		int idx = Integer.parseInt(request.getParameter("idx"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");

		PublisherVO vo = new PublisherVO();
		vo.setIdx(idx);
		vo.setId(id);
		vo.setPw(pw);
		vo.setEmail(email);
		vo.setTel(tel);

		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.PmemberModify(vo);
		request.setAttribute("agree", agree);
		request.setAttribute("session", session);
		request.setAttribute("row", row);
		PublisherVO vo2 = dao.publisherView(id);
		request.setAttribute("vo", vo2);
		RequestDispatcher rd = request.getRequestDispatcher("member/Memberview.jsp");
		rd.forward(request, response);

	}

}