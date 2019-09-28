package action.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import KISA.SHA256;
import action.Action;
import model.member.MemberDAO;
import model.member.PublisherVO;
import sun.misc.BASE64Encoder;

public class MemberInsert3_BAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		int upLoadFileSizeLimit = 10 * 1024 * 1024;

		String encType = "UTF-8";
		String uploadFilePath = "C:\\Users\\dodunge\\UIDesign\\For_you\\WebContent\\upload";
		URLEncoder.encode(uploadFilePath, "utf-8");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, upLoadFileSizeLimit, encType,
				new DefaultFileRenamePolicy());

		String id = multi.getParameter("userid");
		String pw = multi.getParameter("pw");
		SHA256 s = new SHA256(pw.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		pw = Base64Encoder.encode(s.GetHashCode());
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String tel = multi.getParameter("tel");
		String bno = multi.getParameter("bno");
		String bfile = multi.getFilesystemName("bfile");

		request.setAttribute("name", name);

		PublisherVO vo = new PublisherVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setBno(bno);
		vo.setBfile(bfile);

		MemberDAO dao = MemberDAO.getInstance();
		int flag = dao.insertPub(vo);

		if (flag == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("member/MemberInsert4_B.jsp");
			rd.forward(request, response);
		} else {
		}
	}
}