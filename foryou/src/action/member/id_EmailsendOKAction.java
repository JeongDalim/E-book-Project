package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class id_EmailsendOKAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String id = request.getParameter("id");
      
      request.setAttribute("name", name);
      request.setAttribute("id", id);
      System.out.println("test");
      RequestDispatcher rd = request.getRequestDispatcher("member/id_EmailSendOK.jsp");
      rd.forward(request, response);

   }

}