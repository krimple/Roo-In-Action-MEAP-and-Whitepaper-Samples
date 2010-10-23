package org.distracted.tracker.model;

import java.math.BigDecimal;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.transaction.annotation.Transactional;

@RooIntegrationTest(entity = Task.class)
public class TaskIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
    
    @Test
    @Transactional
    public void testAddAndFetchNewTask() {
    		Task t = new Task();
    		t.setDescription("Write a test");
    		t.setDateCreated(new Date());
    		t.setDateDue(new Date());    		
    		t.persist();
    		
    		Task t2 = Task.findTask(t.getId());
    		Assert.assertEquals(t.getId(), t2.getId());
    		Assert.assertEquals(t.getDescription(), t2.getDescription());
    }
    
    @Test
    public void testStoreTaskWithExtendedAttributes() {
    		TaskDataOnDemand tdod = new TaskDataOnDemand();
    		Task t = tdod.getNewTransientTask(0);
    		TaskExtendedAttributes tei = new TaskExtendedAttributes();
    		tei.setComments("This is a complex task");
    		tei.setCost(new BigDecimal("10000.00"));
    		tei.setLastUpdateDate(new Date());
    		tei.persist();
    		
    		t.setExtendedAttributes(tei);
    		
    		t.persist();
    		
    		Task t2 = Task.findTask(t.getId());
    		Assert.assertNotNull(t2.getExtendedAttributes());
    		
    }
}
