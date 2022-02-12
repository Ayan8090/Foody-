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

import entites.orderlist;
import entites.user;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class Order
 */

public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
 
		HttpSession session = request.getSession();
	    user user=(user)session.getAttribute("user");
		
		if (user==null) {
			
			Massage msg = new Massage("Create Your Account.", "bell", "Red");
			
			HttpSession session3 = request.getSession();
			session3.setAttribute("msg", msg);
			
			response.sendRedirect("signin.jsp");
			
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name= request.getParameter("name") ;
		String phone= request.getParameter("phone") ;
		String email= request.getParameter("email") ;
		String address = request.getParameter("address") ;
		String city= request.getParameter("city") ;
		
		
		orderlist order = new orderlist();
		
		Session session2 = ConPro.gFactory().openSession();
		Transaction tx = session2.beginTransaction();
		Food food = session2.get(Food.class, id);
		
		order.setUserID(user.getId());
		order.setName(food.getName());
		order.setAbout(food.getAbout());
		order.setImage(food.getImage());
		order.setPrice(food.getPrice());
		order.setUsername(name);
		order.setUserAddress(address);
		order.setUserPhone(phone);
		order.setUserCIty(city);
		order.setOrderStatus("Panding");
		
		session2.save(order);
       
		tx.commit();
		session2.close();
		
		Massage msg = new Massage(user.getName()+" Your "+food.getName()+" Orderd Succesfully. ", "bell", "Green");
		
		HttpSession session3 = request.getSession();
		session3.setAttribute("msg", msg);
		
		response.sendRedirect("userProfile.jsp");
		
	}


}
