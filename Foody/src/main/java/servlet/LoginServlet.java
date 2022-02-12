package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.userDao;
import entites.user;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String name = request.getParameter("email");
		
			String password = request.getParameter("password");
			
			userDao dao = new userDao(ConPro.gFactory());
			
			 user user=dao.login(name, password);
			 
			if(user==null) {
				
              Massage massage = new Massage("Wrong Deatails.","exclamation-triangle", "Red");
				
				
				HttpSession session=request.getSession();
				session.setAttribute("msg", massage);

        
              
				response.sendRedirect("Homepage.jsp");
			}
			else {
			
	
			if (user.getUserType().equals("admin")) {
				
				Massage massage = new Massage("Login Sucessfully.","bell", "Green");
				
				
				HttpSession session=request.getSession();
				session.setAttribute("msg", massage);
				
				HttpSession session1=request.getSession();
				session1.setAttribute("user", user);
				System.out.println("user page login");
               response.sendRedirect("adminProfile.jsp");
			}
			
			
			if (user.getUserType().equals("user")) {
				
                Massage massage = new Massage("Login Sucessfully.","bell", "Green");
				
				
				HttpSession session=request.getSession();
				session.setAttribute("msg", massage);
				
				HttpSession session1=request.getSession();
				session1.setAttribute("user", user);
				System.out.println("admin page login");
				response.sendRedirect("userProfile.jsp");
				
			}
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
