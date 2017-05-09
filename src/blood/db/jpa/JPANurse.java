package blood.db.jpa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import blood.db.pojos.Nurse;

public class JPANurse extends GeneralMethods {
	
	void SQLCreate(Nurse nurse){
		
		
		em.getTransaction().begin();
		em.persist(nurse);
		em.getTransaction().commit();
	}
	
	void SQLDelete(Nurse nurse){
		
		em.getTransaction().begin();
		em.remove(nurse);
		em.getTransaction().commit();
		
	}
	
/*	Nurse SQLSearch(String name){
		
		
		
	}*/
	
	
	

	}
	
	

