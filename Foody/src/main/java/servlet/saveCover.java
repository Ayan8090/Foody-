package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import helper.savePhoto;

/**
 * Servlet implementation class saveCover
 */
@MultipartConfig
public class saveCover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveCover() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String captionL = request.getParameter("captionL");
			String captionS = request.getParameter("captionS");
			
			
		 Part part = request.getPart("image");
		  String photo= part.getSubmittedFileName();
		  
		 cover cover = new cover(photo, captionL, captionS,"order Button");
	
			String path = request.getRealPath("/")+"cover"+File.separator+cover.getImage();
			
			savePhoto.savepic(part.getInputStream(),path);
			
			Session session = ConPro.gFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(cover);
			
			tx.commit();
			session.close();
			
			System.out.println("save cover");
			Massage massage = new Massage("Cover Photo Saved", "bell", "Green");
				
			
			HttpSession session2=request.getSession();
			session2.setAttribute("msg", massage);
			
			response.sendRedirect("adminProfile.jsp");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
