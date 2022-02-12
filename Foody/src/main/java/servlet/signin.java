package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entites.user;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			
			user user = new user(name, email, password, phone,"user");
			
			Session session = ConPro.gFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
			session.close();
			
            Massage massage = new Massage("You Have Succesfully Signin.", "bell", "Green");
				
			
			HttpSession session2=request.getSession();
			session2.setAttribute("msg", massage);
			
			
			response.sendRedirect("homepage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
