package org.distracted.tracker.model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;

@Entity
public class Customer {

    private String firstName;
    private String lastName;
}
