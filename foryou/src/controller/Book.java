package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.book.BadUpAction;
import action.book.BookBookViewAction;
import action.book.BookCommentWriteAction;
import action.book.BookInsertAction;
import action.book.BookModify_pro_Action;
import action.book.BookPageProAction;
import action.book.BookPreviewAction;
import action.book.BookSearchAction;
import action.book.BookViewAction;
import action.book.GoodUpAction;
import action.book.PubliserDeleteAction;
import action.book.PubliserInsertAction;
import action.book.PubliserListAction;
import action.book.PubliserModifyAction;
import action.member.BookCartAction;

@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("view")) {
			action = new BookViewAction();
		} else if (cmd.equals("search")) {
			action = new BookSearchAction();
		} else if (cmd.equals("preview")) {
			action = new BookPreviewAction();
		} else if (cmd.equals("bookview")) {
			action = new BookBookViewAction();
		} else if (cmd.equals("bookCart")) {
			action = new BookCartAction();
		} else if (cmd.equals("commentWrite")) {
			action = new BookCommentWriteAction();
		} else if (cmd.equals("publisherList")) { // 도서리스트
			action = new PubliserListAction();
		} else if (cmd.equals("publisherInsert")) { // 도서등록
			action = new PubliserInsertAction();
		} else if (cmd.equals("bookinsert_pro")) { // 도서등록프로
			action = new BookInsertAction();
		} else if (cmd.equals("publishermodify")) { // 도서수정
			action = new PubliserModifyAction();
		} else if (cmd.equals("bookmodify_pro")) { // 도서수정프로
			action = new BookModify_pro_Action();
		} else if (cmd.equals("publisherdelete")) { // 도서삭제
			action = new PubliserDeleteAction();
		} else if (cmd.equals("bookpage_pro")) {
			action = new BookPageProAction();
		} else if (cmd.equals("goodup")) {
			action = new GoodUpAction();// 좋아요 1증가
		} else if (cmd.equals("badup")) {
			action = new BadUpAction();// 싫어요 1증가
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
