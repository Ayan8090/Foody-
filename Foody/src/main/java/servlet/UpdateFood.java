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

import entites.Food;
import helper.ConPro;
import helper.Massage;
import helper.savePhoto;

/**
 * Servlet implementation class UpdateFood
 */
@MultipartConfig
public class UpdateFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFood() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		
		
		Part part = request.getPart("image");
		String photo = part.getSubmittedFileName();
		
	
		
		Session session = ConPro.gFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Food food = session.get(Food.class, id);
		
		food.setName(name);
		food.setAbout(about);
		food.setImage(photo);
		
	
		
        String path = request.getRealPath("/")+"cover"+File.separator+food.getImage();
		
	    savePhoto.deletepic(path);
	    savePhoto.savepic(part.getInputStream(), path);
	
		tx .commit();
		session.close();
		
		Massage massage = new Massage("Food Updated Succesfully.", "bell", "Green");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg",massage);
		
	
		response.sendRedirect("adminProfile.jsp");
		
		} catch (Exception e) {
			e.printStackTrace();
			}
	}

}
