package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import entites.user;
import helper.ConPro;

public class userDao {

	
	private SessionFactory factory;


	public userDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public user login(String email , String password) {
		user user =null;
		try {
			
			Session session = ConPro.gFactory().openSession();
			Query q = session.createQuery("from user where email =:e and password =:p");
			q.setParameter("e", email);
			q.setParameter("p", password);
			
			 user = (user) q.uniqueResult();
			
		
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
	}
	
	
}
