package action.request;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;
import model.request.RequestVO;
import util.PageIndex;

public class RequestListActionPost implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			RequestDAO dao = RequestDAO.getInstance();
			
			String search = request.getParameter("search");
			String key = request.getParameter("key");

			// String query="select * from boar where rownum<10 and " + search + " like '%"
			// + key + "%'";

			String url = "Request?cmd=request_listPost";
			String addtag = "", s_query = "";
			s_query = search + " like '%" + key + "%'";
			addtag = "&search=" + search + "&key=" + URLEncoder.encode(key, "utf-8");
			// 검색 조건

			int nowpage = 1;
			int maxlist = 10; // 페이지당 글 수0.
			int totpage = 1;

			int totcount = dao.requestCount();
			// int totcount = dao.boardCount(s_query);// 총 글 수

			// 총 페이지수 계산
			if (totcount % maxlist == 0) {
				totpage = totcount / maxlist;
			} else {
				totpage = totcount / maxlist + 1;
			}

			if (totpage == 0)
				totpage = 1;

			if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
				nowpage = Integer.parseInt(request.getParameter("page"));
			}

			if (nowpage > totpage) {
				nowpage = totpage;
			}

			int pagestart = (nowpage - 1) * maxlist; // 페이지 시작번호(예 0, 10)
			int endpage = nowpage * maxlist; // 페이지 끝(10, 20)

			int listcount = totcount - ((nowpage - 1) * maxlist);
			
			List<RequestVO> list = dao.requestList(s_query, pagestart, endpage);

			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);

			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);

			request.setAttribute("list", dao.requestList(s_query, pagestart, endpage));

			System.out.println("리스트 사이즈 :" +list.size());
			
			
			
			RequestDispatcher dispater = request.getRequestDispatcher("request/request_list.jsp");
			dispater.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
		

	

}
