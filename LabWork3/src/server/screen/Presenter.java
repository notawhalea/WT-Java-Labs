package server.screen;

import server.data.students_database.XMLDAO;
import server.logic.entity.Role;
import server.logic.entity.Student;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Presenter {
    private static Presenter instance;
    public static Presenter getInstance(){
        if (instance == null)
            instance = new Presenter();
        return instance;
    }
    private Presenter(){}

    private final XMLDAO dao = new XMLDAO();

    //token -> id
    private final HashMap<Integer, Integer> tokens = new HashMap<>();

    public void create(int token, Student input) {
        if (!tokens.containsKey(token)) return;
        Student user = dao.read(tokens.get(token));
        if (user.getRole() != Role.ADMIN) return;

        if (dao.read(input.getId()) != null)
            dao.update(input);
        else
            dao.create(input);
    }

    public Student read(int id) {
        return dao.read(id);
    }

    public void update(int token, Student input) {
        if (!tokens.containsKey(token)) return;
        Student user = dao.read(tokens.get(token));
        if (user.getRole() != Role.ADMIN) return;

        if (dao.read(input.getId()) != null)
            dao.update(input);
        else
            dao.create(input);
    }

    public int getToken(String name, String password){
        if (Objects.equals(name, "") || Objects.equals(password, "")){
            System.out.println("Empty field");
            return -1;
        } else {
            Student user = dao.read(name);
            if (!Objects.equals(password, user.getPassHash())) return -1;
            Random random = new Random();
            return user.getGroup() ^ user.getId() ^ random.nextInt(1000, 9999);
        }
    }
}
