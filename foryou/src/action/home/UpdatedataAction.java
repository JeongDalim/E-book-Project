package action.home;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.*;

public class UpdatedataAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				MemberDAO dao = MemberDAO.getInstance();
				List<MemberVO> list = new ArrayList<MemberVO>();
				list = dao.subcustList();
				//System.out.println("�떆�뒪�뀥 �뾽�뜲�씠�듃 吏꾪뻾");
				for(int i=0; i<list.size(); i++) {
					try {
						Calendar cal = Calendar.getInstance(); // 캘占쏙옙占쏙옙
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String subdate = list.get(i).getSubdate().substring(0, 10); // 占쏙옙占쏙옙 占쏙옙청占쏙옙 
						// 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 +1占쏙옙
						Date subday = formatter.parse(subdate);
						cal.setTime(subday);
						cal.add(Calendar.MONTH, 1); // 占싼댐옙 占쏙옙占싹깍옙(占쏙옙占쏙옙占쏙옙 )

						// 占쏙옙占쏙옙 占쏙옙짜
						LocalDate date = LocalDate.now();
						String date2 = date.toString();
						Date nowdate = formatter.parse(date2);

						// 占쏙옙占썹남占쏙옙占싹쇽옙 占쏙옙占�
						long diff = cal.getTime().getTime() - nowdate.getTime();
						long diffday = diff / (24 * 60 * 60 * 1000);
						
						if(diffday < 0 ) {
							String id = list.get(i).getId();
							dao.subcon(id);
							//System.out.println("�뾽�뜲�씠�듃�맂 �븘�씠�뵒 : " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
						//System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙");
					} 
				}
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 1000 * 10, 1000 *5); //占쏙옙占쏙옙키占쏙옙 10占쏙옙 占쏙옙 4占시곤옙占쏙옙占쏙옙 占쏙옙占쏙옙
		RequestDispatcher rd = request.getRequestDispatcher("Home?cmd=Home");
		rd.forward(request, response);
	}
	
}
