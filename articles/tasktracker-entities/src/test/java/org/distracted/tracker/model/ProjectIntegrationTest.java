package org.distracted.tracker.model;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.transaction.annotation.Transactional;

@RooIntegrationTest(entity = Project.class)
public class ProjectIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
    
    @Test
    @Transactional 
    public void testAddProjectAndTask() {
      Project p = new Project();  
      p.setProjectName("The Big One");

      TaskDataOnDemand dod = new TaskDataOnDemand();  
      Task randomTask = dod.getNewTransientTask(0);  
      p.getTasks().add(randomTask); 

      p.persist();  

      Project p2 = Project.findProject(p.getId()); 
      Assert.assertEquals(p.getTasks().size(), p2.getTasks().size());
    }
    
    @Test
    @Transactional
    public void testAddProjectAndTaskReverseFind() {
      Project p = new Project();
      p.setProjectName("The Big One");

      TaskDataOnDemand dod = new TaskDataOnDemand();
      Task randomTask = dod.getNewTransientTask(0);
      p.getTasks().add(randomTask);
      randomTask.setProject(p);  

      p.persist();

      Long savedTaskId = p.getTasks().iterator().next().getId(); 
      Task t = Task.findTask(savedTaskId);

      Assert.assertEquals(t.getProject().getProjectName(),
        p.getProjectName());  
    }
}
