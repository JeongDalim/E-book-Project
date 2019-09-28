package action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class EmailCheckAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      String email = request.getParameter("email");
      
      
      
      System.out.println("email:"+email);
      
      if(email.contains("com")== true) {
         
         MemberDAO dao  = MemberDAO.getInstance();
         boolean flag = dao.member_email_check(email);
         response.setContentType("text/html;charset=UTF-8");
         response.setHeader("Cache-Control", "no-cache");
         PrintWriter out = response.getWriter();
         String result = null;

         if(flag == true) {
            
            
            result = email + "<font color=red>this email can used.</font>";
      
            
         }else {
            
            
            result = email + "this email can not used.";
  
         }
         
         out.println(result);

         
         
         
      }
      
      
      

   }

}