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

public class pSaleslistExcelAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		String company = request.getParameter("company");
		System.out.println(company);
		SalesDAO dao = SalesDAO.getInstance();
		List<SalesVO> list = dao.view_list(year, month, company);
		List<SalesVO> list2 = dao.view_list_sales(year, month, company); // 아래 표를 위한 책별 매출액 리스트
		int cnt = 1;
		request.setAttribute("company", company);
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("cnt", cnt);
		request.setAttribute("year", year);
		request.setAttribute("month", month);

		action.excel.psaleslistexcel excel = new action.excel.psaleslistexcel();
		excel.testexcel(list2,year,month,company);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage/sales_view.jsp");
		rd.forward(request, response);

	}
}
