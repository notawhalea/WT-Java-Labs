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

    public void read(int id) {

    }

    public void update(int token, Object input) {

    }

    public int getToken(String login, String password){
        return -1;
    }
}
