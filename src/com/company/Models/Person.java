package com.company.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pavel on 08.06.17.
 */
public class Person {
    private String firstName;
    private String middleName;
    private String secondName;
    private Date dateOfBirth;
    private Long id;
    private List<Contact> contacts;

    public Person(String firstName, String middleName, String secondName, Date dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.id = Service.generateId();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        return (int) (21 + id * 75);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;
        if (this.id != ((Person)obj).id) return false;
        return true;
    }
}
