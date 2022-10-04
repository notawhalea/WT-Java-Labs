package server.logic.entity;

import server.screen.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientManager {
    private static Presenter presenter = Presenter.getInstance();

    public static void manage(Socket socket){
        try {
            DataInputStream dInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dOutput = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            int token;
            Student newbie;
            while (true){
                switch (dInput.read()){
                    case 1:
                        String name = dInput.readUTF();
                        String password = dInput.readUTF();

                        dOutput.write(presenter.getToken(name, password));
                        break;

                    case 2:
                        token = dInput.readInt();
                        newbie = (Student) input.readObject();
                        presenter.create(token, newbie);
                        break;

                    case 3:
                        int id = dInput.readInt();
                        output.writeObject(presenter.read(id));
                        break;

                    case 4:
                        token = dInput.readInt();
                        newbie = (Student) input.readObject();
                        presenter.update(token, newbie);
                        break;
                }
            }
        }catch (Exception e){}
    }
}
