package blood.db.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import blood.db.pojos.Nurse;

public class JPANurse implements FunctionsDB<Nurse> {

	public EntityManager StartMethod() {
		EntityManager em = Persistence.createEntityManagerFactory("company-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		return em;
	}	
	
	void JPACreate(Nurse nurse){
		
		
		em.getTransaction().begin();
		em.persist(nurse);
		em.getTransaction().commit();
	}
}
