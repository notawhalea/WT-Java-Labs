package server.data.students_database.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import server.logic.entity.Role;
import server.logic.entity.Student;

public class StudentXMLModel extends Student {
    Document doc;
    Element node;

    public StudentXMLModel(Document doc, Element node, Student student){
        this.doc = doc;
        this.node = node;
        setId(student.getId());
        setName(student.getName());
        setSurname(student.getSurname());
        setLastname(student.getLastname());
        setBirthday(student.getBirthday());
        setGroup(student.getGroup());
        setRole(student.getRole());
        setPassHash(student.getPassHash());
    }

    public void save(){
        node.setAttribute("id", String.valueOf(getId()));
        node.setAttribute("name", getName());
        node.setAttribute("surname", getSurname());
        node.setAttribute("lastname", getLastname());
        node.setAttribute("birthday", getBirthday());
        node.setAttribute("group", String.valueOf(getGroup()));
        node.setAttribute("role", getRole().name());
        node.setAttribute("passHash", getPassHash());
    }

    public void load(){
        setId(Integer.parseInt(node.getAttribute("id")));
        setName(node.getAttribute("name"));
        setSurname(node.getAttribute("surname"));
        setLastname(node.getAttribute("lastname"));
        setBirthday(node.getAttribute("birthday"));
        setGroup(Integer.parseInt(node.getAttribute("group")));
        setRole(Role.valueOf(node.getAttribute("role")));
        setPassHash(node.getAttribute("passHash"));
    }

    public Student toEntity(){
        Student result = new Student();
        result.setId(getId());
        result.setName(getName());
        result.setSurname(getSurname());
        result.setLastname(getLastname());
        result.setBirthday(getBirthday());
        result.setGroup(getGroup());
        result.setRole(getRole());
        result.setPassHash(getPassHash());
        return result;
    }
}
