package task01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 4999;
    private ArrayList<ConnectClient> clients = new ArrayList<>();
    private ServerSocket serverSocket;
    private Socket socketClient;
    int i = 1;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запушен");

            while (true) {
                socketClient = serverSocket.accept();
                ConnectClient client = new ConnectClient(socketClient, this, "guest0" + i);
                clients.add(client);
                new Thread(client).start();
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socketClient.close();
                System.out.println("Сервер остановлен");
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void sendMessageAllClients(String message, ConnectClient client) {
        for(ConnectClient c: clients) {
            if (!c.equals(client)){
                c.sendMessage(message);
            }
        }
    }

    public void removeClient(ConnectClient client) {
        clients.remove(client);
        client.close();
    }



}






//
//while (true){
//        Socket socket = serverSocket.accept();
//        new ConnectClient(socket, "guest0" + i);
//        System.out.println("guest0" + (i+1) + " подключился к чату");
//        i++;
//        }