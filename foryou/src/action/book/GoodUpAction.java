package action.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.book.BookDAO;

public class GoodUpAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String member_id = request.getParameter("member_id");
		BookDAO dao = BookDAO.getInstance();
		boolean sw = true;

		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getValue().equals(idx + member_id + "") && cookies[i].getName().equals("cookie" + idx)) { // 以묐났�릺硫�
				sw = false;
				PrintWriter out = response.getWriter();
				String str = "";
				str = "<script language='javascript'>alert('Successfully completed.'),";
				str += "opener.window.location.reload();"; // �삤�봽�꼫 �깉濡쒓퀬移�
				str += "self.close();"; // 李쎈떕湲�
				str += "</script>";
				out.print(str);
			}
		}
		if (sw) { // 以묐났�븞�릺硫�
			dao.goodUp(idx, member_id);
			Cookie cookie = new Cookie("cookie" + idx, idx + member_id + "");
			response.addCookie(cookie);
			PrintWriter out = response.getWriter();
			String str = "";
			str = "<script language='javascript'>";
			str += "opener.window.location.reload();"; // �삤�봽�꼫 �깉濡쒓퀬移�
			str += "self.close();"; // 李쎈떕湲�
			str += "</script>";
			out.print(str);
		}

	}

}
