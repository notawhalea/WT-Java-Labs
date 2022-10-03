package client.screen;

import client.data.students_server.StudentsServerDAO;
import client.logic.entity.Student;


public class Presenter {
    private int token = -1;

    private StudentsServerDAO dao = new StudentsServerDAO();

    public void create(Student student) {
        dao.create(token, student);
    }

    public Student read(int id) {
        return dao.read(id);
    }

    public void update(Student student) {
        dao.update(token, student);
    }

    public boolean connect(String login, String password){
        token = dao.connect(login, password);
        return token > -1;
    }
}
