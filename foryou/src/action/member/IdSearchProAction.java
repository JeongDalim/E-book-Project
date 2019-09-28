package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class IdSearchProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String idsea = request.getParameter("idsea");
		if (idsea != null) {
			if (idsea.equals("publisher")) {
				String eorp = request.getParameter("eorp");
				String bno = request.getParameter("bno");
				String gubun = "";
				if (eorp.contains("@")) {
					gubun = "email";
					// 사업자번호와 이메일이 들어온것.
					// memberDAO에 사업자 테이블에서 id검색하는 메소드 bIdsearch(gubun,bno,eorp)
					String id = dao.bidSearch(gubun, bno, eorp);

					String email = eorp;

					request.setAttribute("name", bno);
					String key = request.getParameter("key");

					// System.out.println("email" + email);

					request.setAttribute("email", email); // 안보내져서 쿼리스트링으로도 보냄
					request.setAttribute("id", id);

					RequestDispatcher rd = request.getRequestDispatcher("member/id_sendEmail.jsp?email=" + email);
					rd.forward(request, response);

				} else {
					gubun = "tel";
					// 사업자번호와 전화번호가 들어온것.
				}
				System.out.println(eorp + "," + bno + "," + gubun);
				String id = dao.bidSearch(gubun, bno, eorp);
				if (id.equals("notexit")) {
					request.setAttribute("name", bno);
					request.setAttribute("key", eorp);
					RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch_failed.jsp");
					rd.forward(request, response);
				} else {
					int row = dao.agreeCheck(id);
					if (row == 2) {
						request.setAttribute("id", id);
						request.setAttribute("name", bno);
						request.setAttribute("key", eorp);
						RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch_ok.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("row", row);
						request.setAttribute("id", id);
						request.setAttribute("name", bno);
						request.setAttribute("key", eorp);
						RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch_failed.jsp");
						rd.forward(request, response);
					}
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
				String id = dao.idSearch(gubun, name, key);
				System.out.println(id);
				if (id.equals("notexit")) {
					request.setAttribute("name", name);
					request.setAttribute("key", key);
					request.setAttribute("1", 1);
					// RequestDispatcher rd = request.getRequestDispatcher("Member/idsearch.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch_failed.jsp");
					rd.forward(request, response);
				} else {
					// 이메일 처리하는 부분
					request.setAttribute("id", id);
					request.setAttribute("name", name);
					request.setAttribute("key", key);
					String email = request.getParameter("email");
					request.setAttribute("email", email);

					if(idsea.equals("tel")) {
		                  RequestDispatcher rd = request.getRequestDispatcher("member/Idsearch_ok.jsp");
		                  rd.forward(request, response);
		               }else {
		                  RequestDispatcher rd = request.getRequestDispatcher("member/id_sendEmail.jsp");
		                  rd.forward(request, response);
		               }
				}
			}
		}
	}
}
