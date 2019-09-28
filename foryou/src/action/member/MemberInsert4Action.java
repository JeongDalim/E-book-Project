package action.member;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;
import KISA.SHA256;
import sun.misc.BASE64Encoder;

public class MemberInsert4Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String[] genre = request.getParameterValues("genre");
		String genre2 = "";
		for (int i = 0; i < genre.length; i++) {
			genre2 = genre2 + genre[i] + "&&";
		}
		String gudok = request.getParameter("gudok");
		String card = request.getParameter("card");
		String cvc = request.getParameter("cvc");
		String bank = request.getParameter("bank");
		String bankpw = request.getParameter("bankpw");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setGenre(genre2);
		if (gudok != "") {
			vo.setSubdate("gudok");
		}
		if (card != "" && cvc != "") {
			vo.setCard(card);
			vo.setCvc(cvc);
		}
		if (bank != "" && bankpw != "") {
			vo.setBank(bank);
			vo.setBankpw(bankpw);
		}
		MemberDAO dao = MemberDAO.getInstance();
		int flag = dao.joinMember(vo);
		if (flag == 1) {
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("member/MemberInsert4.jsp");
			rd.forward(request, response);
		} else {

		}
	}

}