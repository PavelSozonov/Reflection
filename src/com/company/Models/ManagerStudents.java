package com.company.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 08.06.17.
 */
public class ManagerStudents {

    private List<Student> students = new ArrayList<>();

    public void serialize() throws IOException {
        FileOutputStream out = new FileOutputStream("students.dat");
        ObjectOutputStream stream = new ObjectOutputStream(out);
        for (Student student : students) {
            stream.writeObject(student);
        }
        stream.close();
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("students.dat");
        ObjectInputStream stream = new ObjectInputStream(in);
        // TODO: loop
        Student student = (Student)stream.readObject();
        stream.close();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void get() {

    }

    public void update() {

    }

    public void remove() {

    }

    public void showListOfStudents() {

    }

}
