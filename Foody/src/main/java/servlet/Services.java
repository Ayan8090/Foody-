package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;


import helper.ConPro;
/**
 * Servlet implementation class Services
 */
public class Services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Services() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String name = request.getParameter("Name");
		String logo = request.getParameter("Logo");
		String about = request.getParameter("About");
		
		entites.Services services = new entites.Services(logo, name, about);
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(services);
		
		tx.commit();
		session.close();
		
		System.out.println("serivecs");
		response.sendRedirect("adminProfile.jsp");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
		

}
