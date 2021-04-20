package task02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 4999;
    private ArrayList<ConnectClient> clients = new ArrayList<ConnectClient>();
    private ServerSocket serverSocket;
    int i = 1;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запушен");

            while (true) {
                Socket socketClient = serverSocket.accept();
                ConnectClient client = new ConnectClient(socketClient, this, "guest0" + i);
                clients.add(client);
                new Thread(client).start();
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                System.out.println("Сервер остановлен");
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void sendMessageAllClients(String msg, ConnectClient client) {
        for(ConnectClient c: clients) {
            if (!c.equals(client)){
                c.sendMessage(msg);
            }
        }
    }

    public void sendPersonalMessage(String msg, ConnectClient client){
        String name = msg.split(" ")[0];
        boolean sentMsg = false;
        if (name.equals("@")) {
            client.sendMessage("Что бы отправить личное сообшения укажите имя пользователя начало сообщении (@name) т.о.");
        } else {
            for (ConnectClient c: clients) {
                if (name.substring(1).equals(c.name)) {
                    c.sendMessage("Личное сообщ от @" + client.name + " " + msg.substring(name.length(), msg.length()));
                    sentMsg = true;
                    break;
                }
            }
            if (!sentMsg) {
                client.sendMessage("Нету пользователя с таким именем " + name);
            }
        }
    }

    public void changeName(String name, ConnectClient client) {
        boolean isName = false;
        for (ConnectClient c: clients){
            if (c.name.equals(name)) {
                isName = true;
            }
        }

        if (isName) {
            client.sendMessage("Пользователь с таким именим уже существует");
        } else {
            sendMessageAllClients(client.name + " изменил свое имя на " + name, client);
            client.name = name;
            client.sendMessage("Ваша имя изменено на " + client.name);
        }
    }

    public void removeClient(ConnectClient client) {
        clients.remove(client);
    }

    public void countUsers(ConnectClient client){
        client.sendMessage("Сейчас в чате количество пользователей: " + clients.size() + ", включая Вас!");
    }
}
