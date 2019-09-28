package action.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;
import model.book.CommentsVO;
import model.bookcart.BookCartDAO;
import model.rent.RentDAO;

public class BookViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getInstance();
		BookCartDAO dao2 = BookCartDAO.getInstance();
		RentDAO dao3 = RentDAO.getInstance();
		HttpSession session = request.getSession();
		if (session.getAttribute("session") != null) {
			String memberId = session.getAttribute("session").toString();
			if (session.getAttribute("agree") == null) {
				if (dao3.myRent(memberId).size() > 0) {
					String myRent = dao3.myRent(memberId).get(0).getIdx() + "";
					if (dao3.myRent(memberId).size() > 1) {
						for (int i = 1; i < dao3.myRent(memberId).size(); i++) {
							myRent += "&" + dao3.myRent(memberId).get(i).getIdx();
						}
					}
					request.setAttribute("myRent", myRent);// 내 서고에 있는 책들
				}
				if (dao2.myBookCart(memberId) != null) {
					if (dao2.myBookCart(memberId).size() > 0) {
						String bookCart = dao2.myBookCart(memberId).get(0).getIdx() + "";
						if (dao2.myBookCart(memberId).size() > 1) {
							for (int i = 1; i < dao2.myBookCart(memberId).size(); i++) {
								bookCart += "&" + dao2.myBookCart(memberId).get(i).getIdx();
							}
						}
						request.setAttribute("bookCart", bookCart);// 내 장바구니에 있는 책들
					}
				}
			}
		}
		int idx = Integer.parseInt(request.getParameter("idx"));
		float score = 0;
		float score2 = 0;

		// 이수정 인기순 업로드순 comments띄우기로 수정
		String csort = "";
		if (request.getParameter("csort") != null) {
			csort = request.getParameter("csort");
		}
		List<CommentsVO> list = null;
		if (request.getParameter("csort") != null) {
			list = dao.book_comments(idx, csort);
		} else {// 맨처음 책 뷰로 갈 때 등록순으로
			list = dao.book_comments(idx, "good");
		}

		for (int i = 0; i < list.size(); i++) {
			score += list.get(i).getScore();
			if (score != 0.0) {
				score2 = score / list.size();
			}
		}

		BookVO vo = dao.book_view(idx);
		request.setAttribute("book", vo); // 책 정보
		request.setAttribute("book_score2", String.format("%.1f", score2));
		request.setAttribute("book_score", score2); // 책의 평균 점수
		request.setAttribute("book_comments", list); // 코멘트 리스트
		request.setAttribute("genre_list_best", dao.genre_list_best(dao.book_view(idx).getGenre())); // 이 분야의 인기 도서
		request.setAttribute("writer_list", dao.writer_list(dao.book_view(idx).getWriter())); // 저자별 도서
		request.setAttribute("csort", csort);// comments 정렬 조건

		RequestDispatcher rd = request.getRequestDispatcher("view/view.jsp");
		rd.forward(request, response);
	}
}
