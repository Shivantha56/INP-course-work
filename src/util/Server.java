package util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6000);

        Socket socket;


        while (true) {

            System.out.println("Waiting for Client ...");
            socket = serverSocket.accept();
            System.out.println("Client Connected");
            //=============================================================
            ClientHandler clientHandler = new ClientHandler(socket, clients);
            clients.add(clientHandler);
            //========================= run thread ========================
            clientHandler.start();
            System.out.println(Thread.currentThread().isAlive());
        }
    }
}
