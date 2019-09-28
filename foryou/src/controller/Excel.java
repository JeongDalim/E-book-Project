package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.excel.BooklistExcelAction;
import action.excel.PlistExcelAction;
import action.excel.SaleslistExcelAction;
import action.excel.pSaleslistExcelAction;

@WebServlet("/Excel")
public class Excel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Excel() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("plistexcel")) {
			action = new PlistExcelAction();
		} else if (cmd.equals("booklistexcel")) {
			action = new BooklistExcelAction();
		} else if (cmd.equals("saleslistexcel")) {
			action = new SaleslistExcelAction();
		} else if (cmd.equals("psaleslistexcel")) {
			action = new pSaleslistExcelAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
