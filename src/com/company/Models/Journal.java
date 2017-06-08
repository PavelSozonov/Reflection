package com.company.Models;

import java.util.HashMap;

/**
 * Created by pavel on 08.06.17.
 */
public class Journal {
    private Long id;
    private Lesson lesson;
    private HashMap<Student, Boolean> students;

    public Journal(Lesson lesson, HashMap<Student, Boolean> students) {
        this.lesson = lesson;
        this.students = students;
        this.id = System.currentTimeMillis();
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public HashMap<Student, Boolean> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Student, Boolean> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Journal)) return false;
        if (lesson != ((Journal)o).lesson) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 23 + lesson.hashCode() * 31;
    }
}
