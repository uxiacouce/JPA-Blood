package blood.db.jpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import blood.db.pojos.Hospital;
import sample.db.pojos.Employee;

public class JPAHospital {
	
public EntityManager StartMethod() {
	EntityManager em = Persistence.createEntityManagerFactory("company-provider").createEntityManager();
	em.getTransaction().begin();
	em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
	em.getTransaction().commit();
	return em;
}

public void JPACreate() throws IOException{
	EntityManager em = StartMethod();
	System.out.println("Please, input the hospital info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Name: ");
	String name = reader.readLine();
	System.out.print("Adress: ");
	String address = reader.readLine();
	System.out.println("Range: ");
	Integer range = Integer.parseInt(reader.readLine());
				
	// Create the object
	Hospital hosp1 = new Hospital(name, address,range);
	
	// Begin transaction 
	em.getTransaction().begin();
	// Store the object
	//Insert something in the db.
	em.persist(hosp1);
	// End transaction
	em.getTransaction().commit();
	
	// Close the entity manager
	em.close();
}

public void JPADelete(){
	
	public PrintHospital (EntityManager em1) {
		Query q1 = em1.createNativeQuery("SELECT * FROM Hospital", Hospital.class);
		List<Hospital> hosps = (List<Hospital>) q1.getResultList();
		for (Hospital hosp : hosps) {
			System.out.println(hosp);
		}
	}

	EntityManager em = StartMethod();
	System.out.println("Company's employees:");
	printEmployees(em);
	System.out.print("Choose a employee to fire. Type it's ID:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	int emp_id = Integer.parseInt(reader.readLine());
	Query q2 = em.createNativeQuery("SELECT * FROM employees WHERE id = ?", Employee.class);
	q2.setParameter(1, emp_id);
	Employee poorGuy = (Employee) q2.getSingleResult();

	// Begin transaction
	em.getTransaction().begin();
	// Store the object
	//Se eliminan todos los datos relacionados con este objeto que le pasamos.
	em.remove(poorGuy);
	// End transaction
	em.getTransaction().commit();

	// Close the entity manager
	em.close();
	
	
}



}