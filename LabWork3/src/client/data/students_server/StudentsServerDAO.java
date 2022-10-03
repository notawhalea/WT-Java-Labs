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

    public void create(int token, Student student) {
        try {
            dOutput.write(2);
            dOutput.writeInt(token);
            output.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Student read(int id) {
        try {
            dOutput.write(3);
            dOutput.write(id);
            return (Student) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int token, Student student) {
        try {
            dOutput.write(4);
            dOutput.writeInt(token);
            output.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int connect(String login, String password){
        try {
            Socket socket = new Socket("127.0.0.1", 224);
            DataInputStream dInput = new DataInputStream(socket.getInputStream());
            dOutput = new DataOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            dOutput.write(1);
            dOutput.writeUTF(login);
            dOutput.writeUTF(password);

            return dInput.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}