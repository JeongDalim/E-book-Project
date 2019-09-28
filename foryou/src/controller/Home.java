package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.home.HomeAction;
import action.home.PopAction;
import action.home.PopNoSeeAction;
import action.home.UpdatedataAction;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		Action action = null;
		if (cmd.equals("Home")) {
			action = new HomeAction();
		} else if (cmd.equals("Updatedata")) {
			action = new UpdatedataAction();
		} else if (cmd.equals("pop")) {
			action = new PopAction();
		} else if (cmd.equals("popNoSee")) {
			action = new PopNoSeeAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
