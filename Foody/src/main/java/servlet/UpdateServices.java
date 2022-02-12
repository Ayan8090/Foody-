package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daos.coverDao;
import entites.Services;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class UpdateServices
 */
public class UpdateServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		String icon = request.getParameter("Icon");
		
		Session s = ConPro.gFactory().openSession();
		Transaction tx = s.beginTransaction();
		Services services= s.get(Services.class, id);
		
		services.setName(name);
		services.setAbout(about);
		services.setLogo(icon);
		
		
		tx.commit();
		s.close();
		
		Massage msg = new Massage("Services Updated.", "bell", "Green");
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		response.sendRedirect("adminProfile.jsp");
		
	}

}
