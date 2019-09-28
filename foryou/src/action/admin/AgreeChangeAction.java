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

public class AgreeChangeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		System.out.println(idx);
		int agree = Integer.parseInt(request.getParameter("agree"));
		System.out.println(agree);
		AdminDAO dao = AdminDAO.getInstance();
		if (agree == 2) {
			dao.agree(idx, 2);
		} else if (agree == 3) {
			dao.agree(idx, 3);
		} else if (agree == 1) {
			dao.agree(idx, 1);
		} else if(agree==4){
			dao.deletePublisher(idx);
		}
		List<PublisherVO> list = null;
		list = dao.agreeList();
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		RequestDispatcher rd = request.getRequestDispatcher("admin/publist.jsp");
		rd.forward(request, response);
	}
}
