package client.screen;

import client.data.students_server.StudentsServerDAO;
import client.logic.entity.Student;


public class Presenter {
    private StudentsServerDAO dao = new StudentsServerDAO();

    public void create(Student student) {
        dao.create(student);
    }

    public Student read(int id) {
        return dao.read(id);
    }

    public void update(Student student) {
        dao.update(student);
    }

    public boolean connect(String login, String password){
        return dao.connect(login, password);
    }
}
