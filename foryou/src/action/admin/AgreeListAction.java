package action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.AdminDAO;
import model.member.PublisherVO;

public class AgreeListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PublisherVO> list = null;
		AdminDAO dao = AdminDAO.getInstance();
		list = dao.agreeList();
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		RequestDispatcher rd = request.getRequestDispatcher("admin/publist.jsp");
		rd.forward(request, response);
	}
}
