package org.distracted.tracker.model;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Project {

    @NotNull
    @Size(min = 1, max = 40)
    private String projectName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<org.distracted.tracker.model.Task> tasks = 
    		new java.util.HashSet<org.distracted.tracker.model.Task>();
}
