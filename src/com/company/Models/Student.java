package com.company.Models;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by pavel on 08.06.17.
 */
public class Student extends Person implements Serializable {
    private Long groupId;

    public Student(String firstName, String middleName, String secondName, Date dateOfBirth, Long groupId) {
        super(firstName, middleName, secondName, dateOfBirth);
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

    public void serializeAsXml(String fileName) {
        Field[] fields = this.getClass().getDeclaredFields();
        Class parent = this.getClass().getSuperclass();
        Field[] parentFields = parent.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        for (Field field : parentFields) {
            System.out.println(field.getName());
        }
        writeFields(fields, parentFields);
    }

    private void writeFields(Field[] fields, Field[] paretnFields) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("object");
            doc.appendChild(rootElement);

            Attr attrType = doc.createAttribute("type");
            attrType.setValue("Student");
            rootElement.setAttributeNode(attrType);

            for (Field field : fields) {

            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("student.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

class CreateXmlFileDemo {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("cars");
            doc.appendChild(rootElement);

            //  supercars element
            Element supercar = doc.createElement("supercars");
            rootElement.appendChild(supercar);

            // setting attribute to element
            Attr attr = doc.createAttribute("company");
            attr.setValue("Ferrari");
            supercar.setAttributeNode(attr);

            // carname element
            Element carname = doc.createElement("carname");
            Attr attrType = doc.createAttribute("type");
            attrType.setValue("formula one");
            carname.setAttributeNode(attrType);
            carname.appendChild(doc.createTextNode("Ferrari 101"));
            supercar.appendChild(carname);

            Element carname1 = doc.createElement("carname");
            Attr attrType1 = doc.createAttribute("type");
            attrType1.setValue("sports");
            carname1.setAttributeNode(attrType1);
            carname1.appendChild(doc.createTextNode("Ferrari 202"));
            supercar.appendChild(carname1);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("cars.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}