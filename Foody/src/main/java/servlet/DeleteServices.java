package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entites.Food;
import entites.Services;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class DeleteServices
 */
public class DeleteServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int id = Integer.parseInt(request.getParameter("id").trim());
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		Services ser = (Services)session.get(Services.class, id);
		
		session.delete(ser);
		
		tx.commit();
		session.close();
		
		Massage massage = new Massage("Services Delete Succesfully.", "bell", "Red");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg",massage);
		
		response.sendRedirect("adminProfile.jsp");
		
		
	}

	

}
