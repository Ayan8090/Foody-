package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import helper.Massage;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Massage	massage = new Massage("You Have Logout Successfully.", "bell", "Green");
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");

	
		HttpSession session2 = request.getSession();
		session2.setAttribute("msg", massage);
		
		response.sendRedirect("homepage.jsp");
	}

}
