package action.sms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberVO;

public class testAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = "";
		if(request.getParameter("userid")!=null) {
			id = request.getParameter("userid");
		}
		String pw = "";
		if(request.getParameter("pw")!=null) {
			pw = request.getParameter("pw");
		}
		String name = "";
		if(request.getParameter("name")!=null) {
			name = request.getParameter("name");
		}
		String email = "";
		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		String subdate = "";
		if(request.getParameter("subdate")!=null) {
			subdate = request.getParameter("subdate");
		}
		String pw2 = "";
		if(request.getParameter("pw2")!=null) {
			pw2 = request.getParameter("pw2");
		}
		String tel = request.getParameter("tel");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setSubdate(subdate);
		action.sms.test sms = new action.sms.test();
		
		String randomStr = sms.testSMS(tel, request, response);
		//String randomStr = "11111";
		request.setAttribute("randomStr", randomStr);
		request.setAttribute("vo", vo);
		request.setAttribute("pw2", pw2);
		RequestDispatcher rd = request.getRequestDispatcher("member/MemberInsert2.jsp");
		rd.forward(request, response);
	}

}
