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

import entites.cover;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class UpdateCover
 */
public class UpdateCover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCover() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

		int id = Integer.parseInt(request.getParameter("id"));
		
		String cap1 = request.getParameter("caps");
		String cap2 = request.getParameter("capl");
		
		Part part = request.getPart("image");
		String photo= part.getSubmittedFileName();
		
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		cover cover = session.get(cover.class, id);
		
		cover.setCaptionS(cap1);
		cover.setCaptionL(cap2);
		cover.setImage(photo);
		
		tx.commit();
		session.close();
		
		Massage msg = new Massage("Cover Deatils Updated.","bell"," Green");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg", msg);
		
		response.sendRedirect("adminProfile.jsp");
	}

}
