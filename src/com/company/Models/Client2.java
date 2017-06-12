package com.company.Models;

import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by pavel on 12.06.17.
 */
public class Client2 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Student student = new Student("Ivan", "Ivanovich", "Ivanov", new Date(), 1L);

        student.serializeAsXml("serializeStudent.xml");
    }
}
