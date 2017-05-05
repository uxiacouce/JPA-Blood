package blood.db.jpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import blood.db.pojos.Hospital;
import blood.db.pojos.Nurse;
public class JPAHospital extends generalMethods {
	
	
	
	
	
	public void SQLCreate(Hospital hospital){
		
		
		em.getTransaction().begin();
		em.persist(hospital);
		em.getTransaction().commit();
	}
	
	public void SQLDelete(Hospital hospital){
		
		em.getTransaction().begin();
		em.remove(hospital);
		em.getTransaction().commit();
		
	}
	
	
	 Hospital SQLSearch1(String name){
		Query q1 = em.createNativeQuery("SELECT * FROM hospitals WHERE name LIKE ?", Hospital.class);
		q1.setParameter(1, "%" + name + "%");
		Hospital hospital = (Hospital) q1.getSingleResult();
		return hospital;
	}
	
	public List<Hospital> SQLSearch(String name){
		
		Query q1 = em.createNativeQuery("SELECT * FROM hospitals WHERE name LIKE ?", Hospital.class);
		q1.setParameter(1, "%" + name + "%");
		List<Hospital> hospitals = (List<Hospital>) q1.getResultList();
		return hospitals;
		
	}
	
	public void SQLUpdate(Hospital oldHosp, Hospital newHosp){
		em.getTransaction().begin();
		newHosp.setName(oldHosp.getName());
		newHosp.setLocation(oldHosp.getLocation());
		newHosp.setRange(oldHosp.getRange());
		em.getTransaction().commit();
	}
	




}