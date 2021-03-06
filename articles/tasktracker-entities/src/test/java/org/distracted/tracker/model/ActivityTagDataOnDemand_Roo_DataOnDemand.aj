// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.distracted.tracker.model;

import java.util.List;
import java.util.Random;
import org.distracted.tracker.model.ActivityTag;
import org.springframework.stereotype.Component;

privileged aspect ActivityTagDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ActivityTagDataOnDemand: @Component;
    
    private Random ActivityTagDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<ActivityTag> ActivityTagDataOnDemand.data;
    
    public ActivityTag ActivityTagDataOnDemand.getNewTransientActivityTag(int index) {
        org.distracted.tracker.model.ActivityTag obj = new org.distracted.tracker.model.ActivityTag();
        java.lang.String tag = "tag_" + index;
        if (tag.length() > 15) {
            tag  = tag.substring(0, 15);
        }
        obj.setTag(tag);
        return obj;
    }
    
    public ActivityTag ActivityTagDataOnDemand.getSpecificActivityTag(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        ActivityTag obj = data.get(index);
        return ActivityTag.findActivityTag(obj.getId());
    }
    
    public ActivityTag ActivityTagDataOnDemand.getRandomActivityTag() {
        init();
        ActivityTag obj = data.get(rnd.nextInt(data.size()));
        return ActivityTag.findActivityTag(obj.getId());
    }
    
    public boolean ActivityTagDataOnDemand.modifyActivityTag(ActivityTag obj) {
        return false;
    }
    
    public void ActivityTagDataOnDemand.init() {
        data = new java.util.ArrayList<org.distracted.tracker.model.ActivityTag>();
        for (int i = 0; i < 10; i++) {
            org.distracted.tracker.model.ActivityTag obj = getNewTransientActivityTag(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
