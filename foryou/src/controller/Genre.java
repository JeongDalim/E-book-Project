package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.genre.GenreListAction;
import action.genre.GenreSearchAction;

@WebServlet("/Genre")
public class Genre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("search")) {
			action = new GenreSearchAction();
		} else if (cmd.equals("list")) {
			action = new GenreListAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
