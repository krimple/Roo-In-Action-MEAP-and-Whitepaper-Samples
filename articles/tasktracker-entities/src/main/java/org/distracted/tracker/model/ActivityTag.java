package org.distracted.tracker.model;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class ActivityTag {

    @NotNull
    @Size(min = 1, max = 15)
    private String tag;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private Set<org.distracted.tracker.model.Task> taggedTasks = new java.util.HashSet<org.distracted.tracker.model.Task>();
}
