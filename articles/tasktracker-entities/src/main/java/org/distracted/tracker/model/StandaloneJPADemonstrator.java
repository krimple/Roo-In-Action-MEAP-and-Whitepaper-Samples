package org.distracted.tracker.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository	    
public class StandaloneJPADemonstrator {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void findAndCompleteTasks(String description) {
		Query query = em.createQuery("select t from Task t " +
		"where t.description like :description")
			.setParameter("description", description + "%");
		List<Task> resultList = query.getResultList();
		for (Task t : resultList) {
			t.setCompleted(true);
		}				
	}
}
