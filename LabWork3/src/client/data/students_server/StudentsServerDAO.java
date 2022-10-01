package client.data.students_server;

import client.logic.entity.Student;

import java.io.*;
import java.net.Socket;

/**
 * 1 - login
 * 2 - create
 * 3 - read
 * 4 - update
 */
public class StudentsServerDAO {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private DataOutputStream dOutput;

    public void create(Student student) {

    }
    public void update(Student student) {

    }

    public boolean connect(String login, String password){
        try {
            Socket socket = new Socket("127.0.0.1", 224);
            DataInputStream dInput = new DataInputStream(socket.getInputStream());
            dOutput = new DataOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            dOutput.write(1);
            dOutput.writeUTF(login);
            dOutput.writeUTF(password);

            return dInput.readBoolean();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}