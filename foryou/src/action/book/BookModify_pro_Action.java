package action.book;

import java.io.File;
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

public class BookModify_pro_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BookDAO dao = BookDAO.getInstance();
		BookVO bookvo = dao.book_view(idx);

		String oldfilename = bookvo.getFileName();
		String oldcontents = bookvo.getContents();

		String uploadFilePath = "C:\\hrdKorea\\For_you\\WebContent\\book\\";

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "utf-8";

		uploadFilePath = "C:\\hrdKorea\\For_you\\WebContent\\book\\";

		System.out.println(uploadFilePath);

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
					new DefaultFileRenamePolicy());
			String bookname = multi.getParameter("bookname");
			String writer = multi.getParameter("writer");
			String pdate = multi.getParameter("pdate");
			int price = Integer.parseInt(multi.getParameter("price"));
			String intro = multi.getParameter("intro");
			String[] gen = multi.getParameterValues("genre");
			String genre = gen[0];
			for (int i = 1; i < gen.length; i++) {
				genre += "," + gen[i];
			}

			String bookplot = multi.getParameter("bookplot");
			String filename = multi.getFilesystemName("filename");
			String contents = multi.getFilesystemName("contents");
			BookVO vo = new BookVO();
			vo.setBookName(bookname);
			vo.setWriter(writer);
			vo.setPdate(pdate);
			vo.setPrice(price);
			vo.setIntro(intro);
			vo.setGenre(genre);
			vo.setBookPlot(bookplot);

			if (filename == null) {
				vo.setFileName(oldfilename);
				System.out.println("aa");
			}
			if (filename != null) {
				vo.setFileName(filename);
				uploadFilePath = "C:\\hrdKorea\\For_you\\WebContent\\book\\";
				File a = new File(uploadFilePath + oldfilename);
				if (a.exists()) {
					a.delete();
				}
				System.out.println("bb");
			}
			if (contents == null) {
				vo.setContents(oldcontents);
				System.out.println("cc");
			}
			if (contents != null) {
				vo.setFileName(contents);
				uploadFilePath = "C:\\hrdKorea\\For_you\\WebContent\\book\\";
				File b = new File(uploadFilePath + oldcontents);
				if (b.exists()) {
					b.delete();
				}
				System.out.println("dd");

			}

			boolean result = dao.book_modify(vo, idx);

			request.setAttribute("result", result);

			RequestDispatcher rd = request.getRequestDispatcher("bookInfo/modify_pro.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
