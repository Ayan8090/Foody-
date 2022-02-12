package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entites.Food;

public class FoodDao {

	

	private SessionFactory factory;

	
	public FoodDao(SessionFactory factory) {
		this.factory = factory;
	}
	 public List<Food> Listfood(){
		 
		Session session = this.factory.openSession();
		Query q = session.createQuery("from Food");
		List<Food> list =q.list();
		
		session.close();
		 
		 return list;
	 }
	
	 public Food byserach(String name) {
     Food food = null;
		 
		 Session session= this.factory.openSession();
		 Query query = session.createQuery("from Food where name like : e");
		 	query.setParameter("e","%"+name+"%");
		  food =(Food) query.uniqueResult();
	 
		 return food;
	 }
	 
	 }
