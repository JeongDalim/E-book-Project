package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.bookcart.BookCartBookCartAction;
import action.bookcart.BookCartDeleteAction;
import action.bookcart.BookCartInsertAction;
import action.bookcart.BookRentDeleteAction;

@WebServlet("/BookCart")
public class BookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("insert")) { // 장바구니 책 넣기
			action = new BookCartInsertAction();
		} else if (cmd.equals("delete")) { // 장바구니 책 삭제
			action = new BookCartDeleteAction();
		} else if (cmd.equals("bookCart")) { // 내 장바구니
			action = new BookCartBookCartAction();
		} else if (cmd.equals("rentDelete")) { // 대여하고 내장바구니에서 삭제
			System.out.println(request.getParameter("idx"));
			System.out.println("렌탈딜리트테스트");
			action = new BookRentDeleteAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
