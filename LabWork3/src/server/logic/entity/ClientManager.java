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

            while (true){
                switch (dInput.read()){
                    case 1:
                        String login = dInput.readUTF();
                        String password = dInput.readUTF();

                        dOutput.write(presenter.getToken(login, password));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        }catch (Exception e){}
    }
}
