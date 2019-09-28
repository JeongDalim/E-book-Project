package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;

public class RDMemberPayCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("session");
		String idx = "";
		if (request.getParameter("idx") != null) {
			idx = request.getParameter("idx");// book_idx
			System.out.println("우선 여기는 왔지?" + idx);
			request.setAttribute("idx", idx);

		}
		if (request.getParameterValues("bookCart") != null) {
			String[] bookIdxs = request.getParameterValues("bookCart");
			request.setAttribute("bookCart", bookIdxs);
			String idxs = bookIdxs[0];
			for (int i = 1; i < bookIdxs.length; i++) {
				idxs = idxs + "," + bookIdxs[i];
			}
			System.out.println("이건왔어?" + idxs);
			request.setAttribute("idxs", idxs);
		}

		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.memberView(id);
		request.setAttribute("vo", vo);

		if (!vo.getCard().equals("0")) {
			String[] cards = vo.getCard().split("-");
	        String card = cards[0]+"-****-****-"+cards[3];
	        request.setAttribute("card", card);
			RequestDispatcher rd = request.getRequestDispatcher("member/Pay3_rd.jsp");// pay3은 계좌나 카드가 등록되 있는 회원의
																						// pay창(기존거 선택하든지 새로운거 등록하든지),
																						// 처음 등록하고 나서도 이 창으로 오게 함
			rd.forward(request, response);
		} else if (!vo.getBank().equals("0")) {
			String[] banks = vo.getBank().split("-");
	        String bank = banks[0]+"-"+banks[1]+"-*****";
	        request.setAttribute("bank", bank);
			RequestDispatcher rd = request.getRequestDispatcher("member/Pay3_rd.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("member/Pay2_rd.jsp");// pay 둘다 없어서 새로 등록
			rd.forward(request, response);
		}

	}

}
