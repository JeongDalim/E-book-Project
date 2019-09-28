package action.sms;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;

public class PublisherTestAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		action.sms.test sms = new action.sms.test();
		
		int upLoadFileSizeLimit = 10 * 1024 * 1024;

		String encType = "UTF-8";
		String uploadFilePath = "C:\\Users\\dodunge\\UIDesign\\For_you\\WebContent\\upload";
		URLEncoder.encode(uploadFilePath, "utf-8");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, upLoadFileSizeLimit, encType,
				new DefaultFileRenamePolicy());
		
		String tel = multi.getParameter("tel");
		String randomStr = sms.testSMS(tel, request, response);
		//String randomStr = "11111";
		request.setAttribute("randomStr", randomStr);
		
		
		//System.out.println(tel);
		//request.setAttribute("tel", tel);
		//String randomStr = "145353"; 
		//request.setAttribute("randomStr", randomStr);
		RequestDispatcher rd = request.getRequestDispatcher("member/testend.jsp");
		rd.forward(request, response);
		
	}

}
