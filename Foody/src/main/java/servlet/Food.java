package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.ConPro;
import helper.savePhoto;

/**
 * Servlet implementation class Food
 */
@MultipartConfig
public class Food extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Food() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name = request.getParameter("Name");
			
			String about = request.getParameter("About");
			int price = Integer.parseInt(request.getParameter("price"));
			 Part part = request.getPart("image");
			 String photo = part.getSubmittedFileName();
			 
			 
			entites.Food food = new entites.Food(name, about, photo,price);
			
			String path = request.getRealPath("/")+"cover"+File.separator+food.getImage();
			
			savePhoto.savepic(part.getInputStream(), path);
			
			Session session = ConPro.gFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(food);
			
			tx.commit();
			session.close();
			
			System.out.println("pic save");
			response.sendRedirect("adminProfile.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
