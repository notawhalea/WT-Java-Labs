package server.screen;

import java.util.List;

public class Presenter {
    private static Presenter instance;
    public static Presenter getInstance(){
        if (instance == null)
            instance = new Presenter();
        return instance;
    }
    private Presenter(){}

    public void create(int token, Object input) {

    }

    public Student read(int id) {
        return dao.read(id);
    }

    public void update(int token, Object input) {

    }

    public int getToken(String login, String password){
        if (Objects.equals(login, "") || Objects.equals(password, "")){
            System.out.println("Empty field");
            return -1;
        } else {
            Student user = dao.read(login);
            if (!Objects.equals(password, user.getPassHash())) return -1;
            Random random = new Random();
            return user.getGroup() ^ user.getId() ^ random.nextInt(1000, 9999);
        }
    }
}
