package action.genre;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class GenreListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genre = request.getParameter("genre");
		BookDAO dao = BookDAO.getInstance();
		// request.setAttribute("genre_list", dao.genre_list(genre));

		String url = "Genre?cmd=list";
		String addtag = "&genre=" + URLEncoder.encode(genre, "utf-8");

		// 검색조건 처리방법
		int nowpage = 1;
		int maxlist = 8; // 웹페이지당 글 수
		int totpage = 1;
		int totcount = dao.bookCount(genre); // 총 글 수

		// 총페이지수 계산
		if (totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1; // 나우어 떨어지지 않을떄
		}
		if (totpage == 0) // 나눈게 0일떄 부족할떄 예) 9/10
			totpage = 1;

		if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage > totpage) { //
			nowpage = totpage;
		}

		int pagestart = (nowpage - 1) * maxlist;// 페이지 시작번호(0,10)
		int endpage = nowpage * maxlist;// 페이지 끝번호(10,20)
		int listcount = totcount - ((nowpage - 1) * maxlist) + 1;

		List<BookVO> list = dao.pagingList(pagestart, endpage, genre);

		request.setAttribute("totcount", totcount);
		request.setAttribute("addtag", addtag);
		request.setAttribute("url", url);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		// 페이지 스킵 처리
		String pageSkip = util.PageIndex.pageList(nowpage, totpage, url, addtag);
		request.setAttribute("pageSkip", pageSkip);

		RequestDispatcher rd = request.getRequestDispatcher("genre/g_list.jsp");
		rd.forward(request, response);
	}
}
