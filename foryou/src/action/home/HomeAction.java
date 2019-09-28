package action.home;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.Home.HomeDAO;
import model.book.BookDAO;
import model.book.BookVO;
import model.book.CommentsVO;
import model.member.MemberDAO;
import model.rent.RentDAO;

public class HomeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int now = Integer.parseInt(LocalTime.now().toString().substring(0, 2));
		int row = 0;
		if (now >= 6 && now <= 18) {
			row = 1;
		} else {
			row = 1;
		}
		request.setCharacterEncoding("utf-8");
		HomeDAO dao = HomeDAO.getInstance();
		MemberDAO dao2 = MemberDAO.getInstance();
		RentDAO dao3 = RentDAO.getInstance();
		BookDAO dao4 = BookDAO.getInstance();
		int max = dao.book_rownum_max(); // DB에 book테이블의 rownum값중 가장 높은 값
		Random random = new Random();
		int randomnum = random.nextInt(max) + 1; // 랜덤함수를 돌려서

		request.setAttribute("todaybook", dao.today_book(randomnum)); // 랜덤책 보여주기
		request.setAttribute("bestseller", dao.best_seller()); // 베스트셀러
		request.setAttribute("newbook", dao.new_book()); // 신작
		HttpSession session = request.getSession();
		if (session.getAttribute("session") != null) { // 로그인한사람만 foryou기능 뜨게
			if (session.getAttribute("agree") == null) {
				String id = session.getAttribute("session").toString();
				request.setAttribute("myRent", dao3.myRent(id));
				request.setAttribute("foryou", dao.foryou_book(id));
				request.setAttribute("member_info", dao2.memberInfo(id));// 회원정보
				request.setAttribute("nowRead", dao4.book_view(dao3.nowRead(id))); // 마지막으로 읽은 책
			}
		}
		
		int review = dao3.nowReview();
		BookVO book_view = dao4.book_view(review);
		List<CommentsVO> list = dao4.book_comments(book_view.getIdx(),"good");
		CommentsVO comments = list.get(0);
		
		request.setAttribute("nowReview", dao4.book_view(dao3.nowReview())); // 최근 댓글 달린 책
		request.setAttribute("comments", comments);
		
		float score = 0;
		float score2 = 0;
		
		for (int i = 0; i < list.size(); i++) {
			score += list.get(i).getScore();
			if (score != 0.0) {
				score2 = score / list.size();
			}

		}
		request.setAttribute("score", score2);

		request.setAttribute("emoticonlist", dao.list()); // 이모티콘 리스트
		request.setAttribute("row", row); // 지금시간 값

		RequestDispatcher rd = request.getRequestDispatcher("Home/Home.jsp");
		rd.forward(request, response);
	}
}
