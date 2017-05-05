package blood.db.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class generalMethods {
	EntityManager em;
	public generalMethods(){
		
	}
	
	public EntityManager StartMethod() {
	    em = Persistence.createEntityManagerFactory("company-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		return em;
	}
	
}
