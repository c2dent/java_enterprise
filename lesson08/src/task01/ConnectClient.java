package task01;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ConnectClient implements Runnable {
    Socket socket;
    Server server;
    Scanner inMessage;
    OutputStreamWriter outMessage;
    String name;

    public ConnectClient(Socket socket, Server server, String name) {
        try {
            this.name = name;
            this.server = server;
            this.socket = socket;
            this.outMessage = new OutputStreamWriter(socket.getOutputStream());
            inMessage = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(outMessage);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void close() {
        server.removeClient(this);
    }

    @Override
    public void run() {
        server.sendMessageAllClients(name + " вошел в чат", null);
        while (inMessage.hasNext()) {
            String clientMessage = inMessage.nextLine();
            if(clientMessage.trim().contains("name=") && clientMessage.trim().split("=").length == 2) {
                String tempName = clientMessage.trim().split("=")[1];
                clientMessage = name + " изменил свое имя на " + tempName;
                name = tempName;
            } else {
                clientMessage = name + ": " + clientMessage;
            }
            System.out.println(clientMessage);
            server.sendMessageAllClients(clientMessage, this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectClient that = (ConnectClient) o;
        return Objects.equals(socket, that.socket) && Objects.equals(server, that.server) && Objects.equals(inMessage, that.inMessage) && Objects.equals(outMessage, that.outMessage) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, server, inMessage, outMessage, name);
    }
}
