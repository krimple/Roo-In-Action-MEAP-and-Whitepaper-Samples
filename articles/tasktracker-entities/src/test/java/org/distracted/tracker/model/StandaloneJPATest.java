package org.distracted.tracker.model;

import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations="classpath:META-INF/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class StandaloneJPATest {
	
	@Autowired
	private StandaloneJPADemonstrator demonstrator;
	
	@Test
	public void testFindAndUpdate() {
		// generate 100 random rows - see TaskDataOnDemand class
		// for pushed-in method to create "
		TaskDataOnDemand dod = new TaskDataOnDemand();		
		dod.init();
					
		Long countDODRows = (Long)Task.entityManager()
			.createQuery("select count(t) from Task AS t " +
					"where t.description like 'description%' and " +
					"t.completed = 0")
			.getSingleResult();
		
		Assert.assertTrue("Should have 100 rows of incomplete tasks. ", 
				countDODRows == 100L);
		
		demonstrator.findAndCompleteTasks("description");
		
		Query query = Task.entityManager()
			.createQuery("select count(t) from Task AS t " +
				"where t.description like 'description%' and " +
				"t.completed = 0");
		
		Long count = (Long)query.getSingleResult();
		Assert.assertTrue(count == 0);
	}
	
}
