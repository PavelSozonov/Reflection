package com.company.Models;

import java.util.List;

/**
 * Created by pavel on 08.06.17.
 */
public class Group {

    private List<Student> studentList;
    private Integer id;
    private String name;

    public Group(List<Student> studentList, Integer id, String name) {
        this.studentList = studentList;
        this.id = id;
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Group)) return false;
        if (id != ((Group)o).id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (39 + id.hashCode() * 13) + (41 + name.hashCode() * 99);
    }
}
