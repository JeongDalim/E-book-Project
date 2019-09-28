package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.request.AdminRequestOKAction;
import action.request.AdminRequestOKAction2;
import action.request.RequestDeleteGetAction;
import action.request.RequestDeletePostAction;
import action.request.RequestListAction;
import action.request.RequestListActionPost;
import action.request.RequestModifyGetAction;
import action.request.RequestModifyPostAction;
import action.request.RequestViewAction;
import action.request.RequestWriteGetAction;
import action.request.RequestWritePostAction;

@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Request() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		Action action = null;

		if (cmd.equals("request_listGet")) {
			action = new RequestListAction();
		} else if (cmd.equals("request_listPost")) {
			action = new RequestListActionPost();
		} else if (cmd.equals("requestView")) {
			action = new RequestViewAction();
		} else if (cmd.equals("request_writeGet")) {
			action = new RequestWriteGetAction();
		} else if (cmd.equals("request_wrtiePost")) {
			action = new RequestWritePostAction();
		} else if (cmd.equals("request_modifyGet")) {
			action = new RequestModifyGetAction();
		} else if (cmd.equals("request_modifyPost")) {
			action = new RequestModifyPostAction();
		} else if (cmd.equals("request_deleteGet")) {
			action = new RequestDeleteGetAction();
		} else if (cmd.equals("request_deletePost")) {
			action = new RequestDeletePostAction();
		} else if(cmd.equals("AdminRequestOK")) {
			action = new AdminRequestOKAction();
		}else if(cmd.equals("AdminRequestOK2")) {
			action = new AdminRequestOKAction2();
		}

		action.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);

	}
}
