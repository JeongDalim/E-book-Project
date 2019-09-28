package action.member;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KISA.SHA256;
import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;
import sun.misc.BASE64Encoder;

public class LoginCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String business = request.getParameter("business");
		MemberDAO dao = MemberDAO.getInstance();
		int row = 2;
		int row2 = 0;
		if (business.equals("no")) { // 일반
			row = dao.midcheck(id, pw);
			if (row == 1) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1800);
				session.setAttribute("session", id);
				if (dao.memberInfo(id).getGubun().equals("subcust")) { // 구독회원이라면
					session.setAttribute("gubun", dao.memberInfo(id).getGubun()); // 구독세션
				}
				MemberVO vo = null;
				vo = dao.subcancelsea(id);
				if (vo.getSubdate() != null) {
					try {
						Calendar cal = Calendar.getInstance(); // 캘린더

						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String subdate = vo.getSubdate().substring(0, 10); // 구독 신청일
						// 구독 시작일 +1달
						Date subday = formatter.parse(subdate);
						cal.setTime(subday);
						cal.add(Calendar.MONTH, 1); // 한달 더하기(만료일 )
						String exdate = formatter.format(cal.getTime());
						// 현재 날짜
						LocalDate date = LocalDate.now();
						String date2 = date.toString();
						Date nowdate = formatter.parse(date2);

						// 현재남은일수 계산
						long diff = cal.getTime().getTime() - nowdate.getTime();
						long diffday = diff / (24 * 60 * 60 * 1000);

						if (vo.getGubun().equals("subcancel") && diffday < 0) {
							dao.subtocust(id); // 남은 일수가 0보다 작으면 일반유저로 강등(구독취소신청한 회원에 한해서).
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("member/Login_ok.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("row", row);
				RequestDispatcher rd = request.getRequestDispatcher("member/Login_failed.jsp");
				rd.forward(request, response);
			}
		} else { // 출판사
			row = dao.pidcheck(id, pw);
			if (row == 1) {
				row2 = dao.agreeCheck(id);
				if (row2 != 2) {// 2:승인o, 1:대기, 3:거절
					request.setAttribute("row", row);
					request.setAttribute("row2", row2);
					RequestDispatcher rd = request.getRequestDispatcher("member/Login_failed.jsp");
					rd.forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(1800);
					session.setAttribute("session", id);
					session.setAttribute("agree", id);
					RequestDispatcher rd = request.getRequestDispatcher("member/Login_ok.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("row", row);
				RequestDispatcher rd = request.getRequestDispatcher("member/Login_failed.jsp");
				rd.forward(request, response);
			}
		}
	}
}