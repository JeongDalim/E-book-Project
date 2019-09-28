package action.sales;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.sales.SalesDAO;
import model.sales.SalesVO;

public class SalesListProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesDAO dao = SalesDAO.getInstance();
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int foryouusersales = dao.real_sales(year, month); // 일반결제 금액들
		List<SalesVO> list = dao.list(year, month); // 출판사별 매출액
		List<SalesVO> list2 = dao.foryou_list(year, month); // ForYou 매출액
		List<SalesVO> list3 = new ArrayList<SalesVO>(); // ForYou 매출액에서 20%뺀금액
		int r = dao.foryou_list_people(year, month); // 총구독자수
		int foryousales = r * 29900; //총구독자수 금액
		
	
		
		SalesVO vo = null;
		int sales = 0;
		int sales2=0;
		for (int i = 0; i < list2.size(); i++) {
			vo = new SalesVO();
			vo.setDay(list2.get(i).getDay());
			sales = (list2.get(i).getSales() * 2) / 10;
			sales2+=sales;
			vo.setSales(sales);
			list3.add(vo);
		}
		//일반결제금액+총구독자수금액 - 출판사 20% 금액
		int total = (foryouusersales+foryousales)-sales2;
		
		
		int count = 1;
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("r", r);
		request.setAttribute("foryousales", foryousales);
		request.setAttribute("foryouusersales", foryouusersales);
		request.setAttribute("total", total);
		request.setAttribute("sales2", sales2);
		RequestDispatcher rd = request.getRequestDispatcher("manage/list.jsp");
		rd.forward(request, response);

	}

}
