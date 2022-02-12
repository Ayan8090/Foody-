package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entites.orderlist;

public class OrderDao {

	
	private SessionFactory factory;

	public OrderDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public List<orderlist> OrderList(int id) {
		
		
		Session session = this.factory.openSession();
		Query query =session.createQuery("from orderlist where userID =:e");
		query.setParameter("e", id);
		
		List<orderlist> list=  query.list();
		
		session.close();
		
		
		return list;
		
		
	}
	
public List<orderlist> AllOrder() {
		
		
		Session session = this.factory.openSession();
		Query query =session.createQuery("from orderlist");

		List<orderlist> list=  query.list();
		
		session.close();
		
		
		return list;
		
		
	}
	
}
