package action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import model.member.MemberDAO;

public class PublisherIDcheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean flag = dao.publisher_id_check(userid);

		response.setContentType("text/html;charset=UTF-8");
	    response.setHeader("Cache-Control", "no-cache");
	    PrintWriter out = response.getWriter();
		String result = null;
			
		if(flag == true) {
			result =  userid + "<font color=red>This id can used</font>\"";
			
		}else{
			result =  userid + "This id can not used";		
		}
			out.println(result);
		

	}

}
