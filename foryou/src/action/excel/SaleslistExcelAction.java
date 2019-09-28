package action.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.sales.SalesDAO;
import model.sales.SalesVO;

public class SaleslistExcelAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SalesDAO dao = SalesDAO.getInstance();
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		List<SalesVO> list = dao.list(year, month);
		request.setAttribute("list", list);
		int count = 0;
		request.setAttribute("count", count);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		action.excel.saleslistexcel excel = new action.excel.saleslistexcel();
		excel.testexcel(list,year,month);
		RequestDispatcher rd = request.getRequestDispatcher("manage/list.jsp");
		rd.forward(request, response);
	}
}
