package action.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.AdminDAO;
import model.member.PublisherVO;

public class PlistExcelAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action.excel.plistexcel excel = new action.excel.plistexcel();
		excel.testexcel();
		List<PublisherVO> list = null;
		AdminDAO dao = AdminDAO.getInstance();
		list = dao.agreeList();
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		RequestDispatcher rd = request.getRequestDispatcher("admin/publist.jsp");
		rd.forward(request, response);
	}

}
