package action.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.request.RequestDAO;
import model.request.RequestVO;

public class RequestViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		try {
		
		int nowpage = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("nowpage", nowpage);
		int idx = Integer.parseInt(request.getParameter("idx"));
		RequestDAO dao = RequestDAO.getInstance();
		RequestVO vo = dao.requestView(idx);
		
		
		request.setAttribute("vo", vo);

		boolean found = false;
		Cookie info = null; 
		Cookie [] cookies = request.getCookies(); // 쿠키 다가져오기
		
		for(int i=0; i<cookies.length; i++){
			info = cookies[i];
		if(info.getName().equals("RequestCookie" + idx)){	//이름을 준거랑  같냐고 물어봐야됨
			found =true; //있으면 트루주자 //기본키랑 결합시켜서 물어볼꺼야 
			break;
		}	
		}
		
		String newValue = "" + System.currentTimeMillis();
		
		if(!found){//쿠키가 없으면 
			info = new Cookie("RequestCookie" + idx, newValue); //쿠키 만들어주는 생성식
			info.setMaxAge(24*60*60); //하루  //시간 정해주기~
			response.addCookie(info); //여기에 추가 해줘야해 
			dao.requestHits(idx); //조회수 
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("request/requestView.jsp");
		rd.forward(request, response);


		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}

	
	}

}
