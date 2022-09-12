package com.mcguire.leadsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 The contact data model which stores data about the contact
 */

@Entity
public class Contact extends AbstractEntity {
    //Contact fields
    private UUID id;
    private String name;
    @NotEmpty
    private String firstName = "";
    @NotEmpty
    private String lastName = "";
    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Company company;
    @Email
    @NotEmpty
    private String email = "";
    @NotNull
    @ManyToOne
    private Status status;

    //Default Constructor
    public Contact() {
    }

    //Constructor to populate basic data
    public Contact(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }




    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getID() {
        return id;
    }
}