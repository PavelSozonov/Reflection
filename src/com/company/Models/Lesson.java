package com.company.Models;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pavel on 08.06.17.
 */
public class Lesson {
    private final Long id;
    private String name;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private String room;
    private String description;
    private String subject;
    private Person lecturer;
    private List<Group> groups;

    public Lesson(String name, LocalDateTime beginDateTime, LocalDateTime endDateTime, String room, String description, String subject, Person lecturer, List<Group> groups) {
        this.name = name;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.room = room;
        this.description = description;
        this.subject = subject;
        this.lecturer = lecturer;
        this.groups = groups;
        this.id = Service.generateId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(LocalDateTime beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Person getLecturer() {
        return lecturer;
    }

    public void setLecturer(Person lecturer) {
        this.lecturer = lecturer;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Lesson)) return false;
        if (id != ((Lesson)o).id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (35 + id * 71) + (47 + name.hashCode() * 19);
    }
}
