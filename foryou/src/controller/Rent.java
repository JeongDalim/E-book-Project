package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.rent.RentBookMarkAction;
import action.rent.RentBookRentAction;
import action.rent.RentBookRetrunAction;
import action.rent.RentMyRentAction;

@WebServlet("/Rent")
public class Rent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("bookRent")) { // 책 대여
			action = new RentBookRentAction();
		} else if (cmd.equals("bookReturn")) { // 책 반납
			action = new RentBookRetrunAction();
		} else if (cmd.equals("myRent")) { // 내 서재
			action = new RentMyRentAction();
		} else if (cmd.equals("bookmark")) {
			action = new RentBookMarkAction(); // 북마크 저장
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
