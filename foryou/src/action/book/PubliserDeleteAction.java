package action.book;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class PubliserDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BookDAO dao = BookDAO.getInstance();
		BookVO bookvo = dao.book_view(idx);

		String filename = bookvo.getFileName();
		String contents = bookvo.getContents();
		String uploadFilePath = "C:\\hrdKorea\\For_you\\WebContent\\book\\";
		File a = new File(uploadFilePath + filename);
		if (a.exists()) {
			a.delete();
		}

		File b = new File(uploadFilePath + contents);
		if (b.exists()) {
			b.delete();
		}

		boolean result = dao.book_delete(idx);

		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("bookInfo/delete_pro.jsp");
		rd.forward(request, response);

	}
}
