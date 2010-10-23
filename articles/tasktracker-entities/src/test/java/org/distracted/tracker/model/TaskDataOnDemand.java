package org.distracted.tracker.model;

import org.springframework.roo.addon.dod.RooDataOnDemand;
import org.distracted.tracker.model.Task;

@RooDataOnDemand(entity = Task.class, quantity = 100)
public class TaskDataOnDemand {
	
	public Task getNewTransientTask(int index) {
        org.distracted.tracker.model.Task obj = new org.distracted.tracker.model.Task();
        obj.setCompleted(new Boolean(false));
        obj.setDateComplete(new java.util.Date());
        obj.setDateCreated(new java.util.Date());
        obj.setDateDue(new java.util.Date());
        String description = "description_" + index;
        if (description.length() > 1000) {
            description = description.substring(0, 1000);
        }
        obj.setDescription(description);
        // fix priority to make it always pass (to make persist properly)
        return obj;
    }
}