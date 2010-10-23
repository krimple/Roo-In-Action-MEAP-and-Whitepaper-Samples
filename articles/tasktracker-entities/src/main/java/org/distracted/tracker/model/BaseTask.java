package org.distracted.tracker.model;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@RooJavaBean
@RooToString
@RooEntity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseTask {

	@NotNull
    @Size(max = 80)
    private String name;
 
    @Size(max = 800)
    private String description;
    
}
