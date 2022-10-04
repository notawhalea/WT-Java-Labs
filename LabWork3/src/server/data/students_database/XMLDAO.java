package server.data.students_database;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import server.data.students_database.model.StudentXMLModel;
import server.logic.entity.Student;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDAO {
    Document doc;
    Element root;

    public XMLDAO(){
        try {
            File input = new File("data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(input);
            root = doc.getDocumentElement();
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Student student){
        Element newbie = doc.createElement("student");
        root.appendChild(newbie);
        new StudentXMLModel(doc, newbie, student).save();
    }

    public Student read(int id){
        for (int i = 0; i < root.getChildNodes().getLength(); i += 1){
            Node student = root.getChildNodes().item(i);
            StudentXMLModel model = new StudentXMLModel(doc, (Element) student, new Student());
            model.load();
            if (model.getId() == id)
                return model.toEntity();
        }
        return null;
    }

    public Student read(String name){
        for (int i = 0; i < root.getChildNodes().getLength(); i += 1){
            Node student = root.getChildNodes().item(i);
            StudentXMLModel model = new StudentXMLModel(doc, (Element) student, new Student());
            model.load();
            if (model.getName().equals(name))
                return model.toEntity();
        }
        return null;
    }

    public void update(Student student){
        Node old = null;
        for (int i = 0; i < root.getChildNodes().getLength(); i += 1){
            Node x = root.getChildNodes().item(i);
            StudentXMLModel model = new StudentXMLModel(doc, (Element) x, new Student());
            model.load();
            if (model.getId() == student.getId()){
                old = x;
                break;
            }
        }
        new StudentXMLModel(doc, (Element) old, student).save();
    }
}