package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.sales.SalesListAction;
import action.sales.SalesListProAction;
import action.sales.SalesViewAction;

@WebServlet("/Sales")
public class Sales extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("saleslist")) { // 출판사 매출액 리스트
			action = new SalesListAction();
		} else if (cmd.equals("saleslist_pro")) { // 리스트 검색 후
			action = new SalesListProAction();
		} else if (cmd.equals("salesview")) { // 각 출판사별 일 매출액 뷰
			action = new SalesViewAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
