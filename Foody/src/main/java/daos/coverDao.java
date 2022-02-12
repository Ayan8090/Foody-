package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entites.cover;

public class coverDao {

	private SessionFactory factory;


	public coverDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	public List<cover> covers() {
		
		
		 Session Session = this.factory.openSession();
		 Query query = Session.createQuery("from cover");
		 List<cover> list= query.list();
		 

		 Session.close();
	
		return list;
	}
}
