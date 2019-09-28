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

public class MemberSubscriptPayCheckAction implements Action{
	//구독결제하는곳
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session");
		String idx = request.getParameter("idx");//book_idx
		System.out.println(idx);
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.memberView(id);
		request.setAttribute("vo", vo);
		request.setAttribute("idx", idx);
		if(!vo.getCard().equals("0")) {
			String[] cards = vo.getCard().split("-");
	        String card = cards[0]+"-****-****-"+cards[3];
	        request.setAttribute("card", card);
			RequestDispatcher rd = request.getRequestDispatcher("member/subscriptPay2.jsp");// pay2은 계좌나 카드가 등록되 있는 회원의 pay창(기존거 선택하든지 새로운거 등록하든지), 처음 등록하고 나서도 이 창으로 오게 함
			rd.forward(request, response);
		}else if(!vo.getBank().equals("0")){
			String[] banks = vo.getBank().split("-");
	        String bank = banks[0]+"-"+banks[1]+"-*****";
	        request.setAttribute("bank", bank);
			RequestDispatcher rd = request.getRequestDispatcher("member/subscriptPay2.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("member/subscriptPay.jsp");//pay 둘다 없어서 새로 등록
			rd.forward(request, response);
		}
		
	}

}
