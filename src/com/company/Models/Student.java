package com.company.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pavel on 08.06.17.
 */
public class Student extends Person implements Serializable {
    private Long groupId;

    public Student(String firstName, String middleName, String secondName, Date dateOfBirth, Long groupId, List<Contact> contacts) {
        super(firstName, middleName, secondName, dateOfBirth, contacts);
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        return (int) (21 + getId() * 37);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student)) return false;
        if (this.getId() != ((Student)obj).getId()) return false;
        return true;
    }
}
