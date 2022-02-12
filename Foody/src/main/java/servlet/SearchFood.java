package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.FoodDao;
import helper.ConPro;

/**
 * Servlet implementation class SearchFood
 */
public class SearchFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("search");
		
		FoodDao doo = new FoodDao(ConPro.gFactory());
		entites.Food food =  doo.byserach(name);
		
		System.out.println("this is"+food.getName());
		
		HttpSession session= request.getSession();
		session.setAttribute("food", food);
		response.sendRedirect("checkout.jsp");
	}

}
