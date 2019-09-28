package action.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class BooklistExcelAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = session.getAttribute("session").toString();
		BookDAO dao = BookDAO.getInstance();
		String company = dao.campanysearch(id);
		List<BookVO> list = dao.my_insert_list(company);
		int count = list.size();
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		action.excel.booklistexcel excel = new action.excel.booklistexcel();
		excel.testexcel(id);
		RequestDispatcher rd = request.getRequestDispatcher("bookInfo/list.jsp");
		rd.forward(request, response);
	}
}
