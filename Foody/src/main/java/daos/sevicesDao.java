package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entites.Services;

public class sevicesDao {

	private SessionFactory factory;

	
	public sevicesDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public List<Services> listService(){
		Session session = this.factory.openSession();
		Query q = session.createQuery("from Services");
		List<Services> list = q.list();
		
				session.close();
		
		return list;
	}
	
}
