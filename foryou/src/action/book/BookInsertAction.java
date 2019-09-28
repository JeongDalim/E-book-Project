package action.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import model.book.BookDAO;
import model.book.BookVO;

public class BookInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "utf-8";

		String uploadFilePath = "C:/Users/FOREVER/Desktop/For_you0729/WebContent/book/";

		System.out.println(uploadFilePath);

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
					new DefaultFileRenamePolicy());
			String bookname = multi.getParameter("bookname");
			String writer = multi.getParameter("writer");
			String company = multi.getParameter("company");
			String pdate = multi.getParameter("pdate");
			int price = Integer.parseInt(multi.getParameter("price"));
			String intro = multi.getParameter("intro");
			String[] gen = multi.getParameterValues("genre");
			String genre = gen[0];
			for (int i = 1; i < gen.length; i++) {
				genre += "," + gen[i];
			}

			String bookplot = multi.getParameter("bookplot");
			String fileName = multi.getFilesystemName("filename");
			String contents = multi.getFilesystemName("contents");
			String published = multi.getParameter("published");
			BookVO vo = new BookVO();
			vo.setBookName(bookname);
			vo.setWriter(writer);
			vo.setCompany(company);
			vo.setPdate(pdate);
			vo.setPrice(price);
			vo.setIntro(intro);
			vo.setGenre(genre);
			vo.setBookPlot(bookplot);
			vo.setFileName(fileName);
			vo.setContents(contents);
			vo.setPublished(published);
			BookDAO dao = BookDAO.getInstance();
			boolean result = dao.book_insert(vo);

			request.setAttribute("result", result);

			RequestDispatcher rd = request.getRequestDispatcher("bookInfo/insert_pro.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
