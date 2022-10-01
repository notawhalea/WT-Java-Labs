package server.screen;

import server.logic.entity.ClientManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(224);
            Thread thread;
            while (true){
                Socket client = socket.accept();
                thread = new Thread(() -> ClientManager.manage(client));
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
