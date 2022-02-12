package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entites.orderlist;
import helper.ConPro;
import helper.Massage;

/**
 * Servlet implementation class OrderRes
 */
public class OrderRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRes() {
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
		orderlist Orderlist=	session.get(orderlist.class, id);
		
		Orderlist.setOrderStatus("Confrom");
		
		tx.commit();
		session.close();
		
		Massage msg = new Massage(Orderlist.getName()+"Order Status Changed", "bell", "Red");
		
		HttpSession session2= request.getSession();
		session2.setAttribute("msg", msg);
		
		response.sendRedirect("adminProfile.jsp");
	
	}

}
