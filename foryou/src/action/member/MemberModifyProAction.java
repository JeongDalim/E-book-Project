package action.member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;
import sun.misc.BASE64Encoder;

public class MemberModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String agree = request.getParameter("agree");
		String session = request.getParameter("session");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String[] genre = request.getParameterValues("genre");
		String genre2 = genre[0];
		for (int i = 1; i < genre.length; i++) {
			genre2 = genre2 + "," + genre[i];
		}
		MemberVO vo = new MemberVO();
		vo.setIdx(idx);
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setGenre(genre2);

		int row = dao.memberModify(vo);
		request.setAttribute("agree", agree);
		request.setAttribute("session", session);
		request.setAttribute("row", row);
		MemberVO vo2 = dao.memberView(id);
		request.setAttribute("vo", vo2);
		if (!vo2.getGubun().equals("cust")) {
			try {
				Calendar cal = Calendar.getInstance(); // 캘린더

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String subdate = vo2.getSubdate().substring(0, 10); // 구독 신청일

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

				// 구독 시작일
				request.setAttribute("subdate", subdate);
				request.setAttribute("exdate", exdate);
				request.setAttribute("diffday", diffday);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("member/Memberview.jsp");
		rd.forward(request, response);
	}
}