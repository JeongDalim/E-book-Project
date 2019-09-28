package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class PwSearchProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pw인증할 화면");
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String idsea = request.getParameter("idsea");
		if (idsea != null) {
			if (idsea.equals("publisher")) {
				String eorp = request.getParameter("eorp");
				String bno = request.getParameter("bno");
				String gubun = "";
				if (eorp.contains("@")) {
					gubun = "email";
					System.out.println("1*");
					// 사업자번호와 이메일이 들어온것.
					// memberDAO에 사업자 테이블에서 id검색하는 메소드 bIdsearch(gubun,bno,eorp)
				} else {
					System.out.println("2");
					gubun = "tel";
					// 사업자번호와 전화번호가 들어온것.
				}
				int row = dao.bid_pSearch(gubun, id, bno, eorp);
				if (row == 0) {
					System.out.println("3");
					request.setAttribute("id", id);
					request.setAttribute("name", bno);
					request.setAttribute("key", eorp);
					RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch_failed.jsp");
					rd.forward(request, response);
				} else {
					System.out.println("4");
					request.setAttribute("idsea", idsea);
					request.setAttribute("id", id);
					request.setAttribute("name", bno);
					request.setAttribute("key", eorp);

					if (gubun.equals("tel")) {// 전화번호에 인증번호 보내주기
						System.out.println("5");
						request.setCharacterEncoding("utf-8");
						action.sms.test sms = new action.sms.test();
						String randomStr = sms.testSMS(eorp, request, response);
						// String randomStr = "1234";
						request.setAttribute("randomStr", randomStr);
						request.setAttribute("row", row);
						// System.out.println("여기여기");

						RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1_p.jsp");
						rd.forward(request, response);
					} else {// 메일일때
						System.out.println("6");
						//System.out.println("여기면 안되는데..");

					      String key =request.getParameter("key");
		                  request.setAttribute("id", id);
		                  request.setAttribute("name", bno);
		                  request.setAttribute("key", key);
		                  request.setAttribute("idsea", idsea);
		                  System.out.println(eorp +"eorp");
		                  
		                  
		                  String email = eorp;
		                  request.setAttribute("email", email);

		                  // System.out.println("pro email:" + email); 나옴

		                  
		                  RequestDispatcher rd = request.getRequestDispatcher("member/pw_sendEmail.jsp?email=" + email);
		                  rd.forward(request, response);
		               
					
					}
					// RequestDispatcher rd = request.getRequestDispatcher("member/Pwmodify.jsp");
					// rd.forward(request, response);
				}
			} else {
				String name = request.getParameter("name");
				String key = ""; // 입력받은 전화번호나 이메일
				String gubun = "";// where절에 email을 넣을지 tel을 넣을지
				if (idsea.equals("tel")) {
					gubun = "tel";
					key = request.getParameter("tel");
				} else {
					gubun = "email";
					key = request.getParameter("email");
				}
				// memberDAO에 회원 테이블에서 id검색하는 메소드 Idsearch(gubun,name,key)
				int row = dao.id_pSearch(gubun, id, name, key);
				if (row == 0) {
					request.setAttribute("name", name);
					request.setAttribute("key", key);
					request.setAttribute("id", id);
					// request.setAttribute("1", 1);
					// RequestDispatcher rd = request.getRequestDispatcher("Member/idsearch.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch_failed.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("idsea", idsea);
					request.setAttribute("id", id);
					request.setAttribute("name", name);
					request.setAttribute("key", key);
					if (idsea.equals("tel")) {// 전화번호에 인증번호 보내주기
						request.setCharacterEncoding("utf-8");
						action.sms.test sms = new action.sms.test();
						String randomStr = sms.testSMS(key, request, response);
						request.setAttribute("randomStr", randomStr);
						request.setAttribute("row", row);
						RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1.jsp");
						rd.forward(request, response);
					} else {// 메일일때
						request.setAttribute("id", id);
						request.setAttribute("name", name);
						request.setAttribute("key", key);
						String email = request.getParameter("email");
						request.setAttribute("email", email);

						// System.out.println("pro email:" + email); 나옴
						RequestDispatcher rd = request.getRequestDispatcher("member/pw_sendEmail.jsp");
						rd.forward(request, response);
						
					}
					// RequestDispatcher rd = request.getRequestDispatcher("member/Pwsearch1.jsp");
					// rd.forward(request, response);
				}
			}
		}
	}
}
