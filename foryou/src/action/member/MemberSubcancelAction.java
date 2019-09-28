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

import action.Action;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberSubcancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int row = 0;
		System.out.println("aaaa");
		String id = request.getParameter("id");
		String gubun = request.getParameter("gubun");
		MemberDAO dao = MemberDAO.getInstance();
		if(gubun.equals("구독회원")) {
			row = dao.subCancel(id); //구독회원이 구독취소.
		}
		if(gubun.equals("구독취소상태")) {
			row = dao.cancelsub(id);
		}
		MemberVO vo = dao.memberView(id);
		request.setAttribute("vo", vo); 
		try {
			Calendar cal = Calendar.getInstance(); //캘린더
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String subdate = vo.getSubdate().substring(0,10); //구독 신청일
			Date subdate2 = formatter.parse(subdate);
			
			//구독 시작일 +1달
			Date subday = formatter.parse(subdate);
			cal.setTime(subday);
			cal.add(Calendar.MONTH, 1); //한달 더하기(만료일 )
			String exdate = formatter.format(cal.getTime());
			
			//현재 날짜
			LocalDate date = LocalDate.now();
			String date2 = date.toString();
			Date nowdate = formatter.parse(date2);
			
			//현재남은일수 계산
			long diff = cal.getTime().getTime() - nowdate.getTime();
			long diffday = diff / (24 * 60 * 60 * 1000);
			
			//구독 시작일
			request.setAttribute("subdate", subdate);
			request.setAttribute("exdate", exdate);
			request.setAttribute("diffday", diffday);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (row == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("member/Membermodify.jsp");
			rd.forward(request, response);
		}
	}

}
