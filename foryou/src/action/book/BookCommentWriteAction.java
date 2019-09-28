package action.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.book.CommentsVO;

public class BookCommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String member_id = session.getAttribute("session").toString();
		int book_idx = Integer.parseInt(request.getParameter("idx"));
		int score = Integer.parseInt(request.getParameter("test-2-rating-5"));
		System.out.println(score);
		String contents = request.getParameter("contents");

		CommentsVO vo = new CommentsVO();
		vo.setBook_idx(book_idx);
		vo.setMember_id(member_id);
		vo.setScore(score);
		vo.setContents(contents);

		BookDAO dao = BookDAO.getInstance();
		if (dao.write_Comments(vo) == true) {
			out.print("Successfully completed");
			response.sendRedirect("Book?cmd=view&idx=" + book_idx);
		} else {
			out.print("Failed");
			response.sendRedirect("Book?cmd=view&idx=" + book_idx);
		}
	}

}
