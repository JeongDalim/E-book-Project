package action.request;

import java.io.IOException;
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

public class RequestListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("aaaaa");
		
			try {

			RequestDAO dao = RequestDAO.getInstance();
			
			String url = "Request?cmd=request_listGet";
			String addtag = "";

			int nowpage = 1;
			int maxlist = 10; // 페이지당 글 수
			int totpage = 1;

			// 총 페이지수 계산
			int totcount = dao.requestCount();
			
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

			List<RequestVO>list = dao.requestList(pagestart, endpage);

			
			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			
			// 페이지 스킵 처리
			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);

		System.out.println("totcount:" + totcount);
		System.out.println("addtag:" + addtag);
		System.out.println("url:" + url);
		System.out.println("nowpage:" +nowpage);
		System.out.println("totpage:" + totpage);
		System.out.println("listcount:"+ listcount);
		System.out.println("리스트 수 :" + list.size());
		
			RequestDispatcher rd = request.getRequestDispatcher("request/request_list.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();	

	}
	}



		
	}
