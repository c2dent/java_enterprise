package task02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ConnectClient implements Runnable {
    private Socket socket;
    private Server server;
    private Scanner inMessage;
    private OutputStreamWriter outMessage;
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
        server.sendMessageAllClients(name + " вошел в чат", this);
        sendMessage("Вы вошли в чат с именем " + name);
        server.countUsers(this);
        try {
            while (inMessage.hasNext()) {
                String clientMessage = inMessage.nextLine();
                if(clientMessage.trim().contains("name=") && clientMessage.trim().split("=").length == 2) {
                    String tempName = clientMessage.trim().split("=")[1];
                    server.changeName(tempName, this);
                } else if (clientMessage.charAt(0) == "@".charAt(0)) {
                    server.sendPersonalMessage(clientMessage, this);
                } else if (clientMessage.toLowerCase().equals(("quit"))){
                    server.sendMessageAllClients(name + " вышел из чата", this);
                    break;
                } else {
                    clientMessage = name + ": " + clientMessage;
                    server.sendMessageAllClients(clientMessage, this);
                }
                System.out.println(clientMessage);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.close();
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
