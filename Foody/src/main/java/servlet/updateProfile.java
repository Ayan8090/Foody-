package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import entites.user;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class updateProfile
 */
public class updateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
   
	 int id = Integer.parseInt(request.getParameter("id"));
	
	 String name= request.getParameter("name");
	 String email= request.getParameter("email");
	 String phone= request.getParameter("phone");
	 String password= request.getParameter("password");
	 
	 Session session= ConPro.gFactory().openSession();
	 user user = session.get(user.class, id);
	 
	 user.setName(name);
	 user.setEmail(email);;
	 user.setPhone(phone);;
	 user.setPassword(password);;
	 
	 session.close();
	 

	
	 if (user.getUserType().equals("admin")) {
		 
		 
		 Massage massage = new Massage("Profile Updated.", "bell", "Green");
			
			
			HttpSession session2=request.getSession();
			session2.setAttribute("msg", massage);
			
		
		 
		 HttpSession session3= request.getSession();
		 session3.setAttribute("user", user);
		 
		 response.sendRedirect("adminProfile.jsp");
	}
	 
	 
	 if (user.getUserType().equals("user")) {
		 
		 
		    Massage massage = new Massage("Profile Updated.", "bell", "Green");
			
			
			HttpSession session2=request.getSession();
			session2.setAttribute("msg", massage);
			
		 
		 HttpSession session3= request.getSession();
		 session3.setAttribute("user", user);
		 response.sendRedirect("userProfile.jsp");
		}
		 
	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}

	
}
