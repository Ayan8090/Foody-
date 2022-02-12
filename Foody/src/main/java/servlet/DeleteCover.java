package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entites.cover;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class DeleteCover
 */
public class DeleteCover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCover() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		cover cover =(cover)session.get(cover.class, id);
		
		session.delete(cover);
		
		tx.commit();
		session.close();
		
		Massage msg = new Massage("Cover Photo Delete.","bell"," Red");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg", msg);
		
		response.sendRedirect("adminProfile.jsp");
	}

}
