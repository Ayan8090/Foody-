package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entites.Food;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class DeleteFood
 */
public class DeleteFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int id = Integer.parseInt(request.getParameter("id").trim());
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		Food food = (Food)session.get(Food.class, id);
		
		session.delete(food);
		
		tx.commit();
		session.close();
		
		Massage massage = new Massage("Foods Delete Succesfully.", "bell", "Red");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg",massage);
		
		response.sendRedirect("adminProfile.jsp");
		
		

	
	}

}
