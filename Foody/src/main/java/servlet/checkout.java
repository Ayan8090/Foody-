package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import entites.Food;
import helper.ConPro;

/**
 * Servlet implementation class checkout
 */
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkout() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Session session = ConPro.gFactory().openSession();
			Food food = session.get(Food.class, id);
			
			session.close();
			
			System.out.println("this is food name"+food.getName());
			
			HttpSession  session2= request.getSession();
			session2.setAttribute("food", food);
			
			response.sendRedirect("checkout.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
