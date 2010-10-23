package org.distracted.tracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * This test is an example of using a ManyToMany association in JPA.  Spring Roo
 * helped us set this up by using the --cardinality MANY_TO_MANY option on the
 * related tables.  One entity (Task) is the owning entity, and the other (ActivityTag)
 * is the dependent entity.  
 * 
 * It doesn't really matter which one you persist, as long as the association in each
 * side of the relationship is updated with the proper reference.  Since each side can
 * reach the other, persistence begins at the owning entity and down the graph from there.
 * 
 * @author Ken Rimple
 *
 */
@ContextConfiguration(locations="classpath:META-INF/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
public class ManyToManyTest {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Insert five tasks and five tags, using a copy of the code from the DataOnDemand class.
	 * Add the collection of dependencies to each side of the relationship.
	 */
	@Test
	@Transactional
	public void testManyToMany() {
		List<Task> tasks = new ArrayList<Task>();
		for (int i = 0; i < 5; i++) {
			Task task = getNewTransientTask(0);
			tasks.add(task);
		}
		
		List<ActivityTag> tags = new ArrayList<ActivityTag>();
		for (int i = 0; i < 5; i++) {
			ActivityTag tag = getNewTransientActivityTag(i);
			tags.add(tag);
		}
		
		// now, add them to each other
		
		for (int i = 0; i < 5; i++) {			
			for (int j = 0; j < 5; j++) {
				tasks.get(i).getTags().add(tags.get(j));
				tags.get(j).getTaggedTasks().add(tasks.get(i));				
			}			
			
			// persistence by reachability - a task knows about its tags
			// therefore when you save the task, and it's the owner, 
			// it also saves the tags associated with the task.
			em.persist(tasks.get(i));			
		}		
	}
	
    private Task getNewTransientTask(int index) {
        org.distracted.tracker.model.Task obj = new org.distracted.tracker.model.Task();
        obj.setCompleted(new Boolean(true));
        obj.setDateComplete(new java.util.Date());
        obj.setDateCreated(new java.util.Date());
        obj.setDateDue(new java.util.Date());
        obj.setDescription("description_" + index);
        obj.setPriority(null);
        return obj;
    }
	
    private ActivityTag getNewTransientActivityTag(int index) {
        org.distracted.tracker.model.ActivityTag obj = new org.distracted.tracker.model.ActivityTag();
        obj.setTag("tag_" + index);
        return obj;
    }
}
