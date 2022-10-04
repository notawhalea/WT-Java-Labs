package server.data.students_database;

import server.logic.entity.Student;

public class XMLDAO {
    public void create(Student student){

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

    public Student read(String login){
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