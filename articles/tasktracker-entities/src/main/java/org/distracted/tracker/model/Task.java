package org.distracted.tracker.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Task {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateDue;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateComplete;

    @NotNull
    @Size(max = 1000)
    private String description;

    @Min(1L)
    @Max(5L)
    private Short priority;

    private Boolean completed;

    @ManyToMany(cascade = CascadeType.ALL)    
    private Set<org.distracted.tracker.model.ActivityTag> tags = new java.util.HashSet<org.distracted.tracker.model.ActivityTag>();

   @ManyToOne(targetEntity = org.distracted.tracker.model.Project.class)
      @JoinColumn
      private org.distracted.tracker.model.Project project;
   
    @OneToOne(targetEntity = TaskExtendedAttributes.class)
    @JoinColumn
    private TaskExtendedAttributes extendedAttributes;
}
