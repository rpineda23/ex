package com.ex.servlets;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.User;
import com.ex.db.LoginDAO;  
  
  
public class LoginController extends HttpServlet {  
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
    LoginDAO loginDAO = new LoginDAO();
    
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	  response.setContentType("text/html");  
      PrintWriter out=response.getWriter();  
      request.getRequestDispatcher("link.html").include(request, response);  
      
      HttpSession session = request.getSession();
      String page = "";
      
     // if(request.getParameterMap().containsKey("password")) {
        
    	  int employeeId=request.getIntHeader("employeeId");  
    	  String password=request.getParameter("password");  
    	  
    	 // User temp = new User();
    	  //loginDAO.validate(employeeId, password);
    	  
    	  if(loginDAO.validate(employeeId, password)) {
    		  session.setAttribute("temp", employeeId);
    		  
    		  page = "./EmployeeHome";
    		  
    	  }
      	else
    	  page = "./LoginController";
        
    	  /*if(loginDAO.validate(employeeId, password)){  
    		  RequestDispatcher rd=request.getRequestDispatcher("EmployeeHomeController");  
    		  rd.forward(request,response);  
    	  }  
    	  else{  
    		  out.print("Sorry username or password error");  
    		  RequestDispatcher rd=request.getRequestDispatcher("login.html");  
    		  rd.include(request,response);  
    	  }  
      }*/
      response.sendRedirect(page);
      out.close();  
}
} 

