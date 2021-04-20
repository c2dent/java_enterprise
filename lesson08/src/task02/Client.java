package task02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void main() throws IOException {
        Socket socket = new Socket("127.0.0.1", 4999);
        System.out.println("Что бы выйти из чата отправьте сообщения quit, для отправки личных сообщении укажите начало " +
                "сообщения имя пользователя с \"@\".Example: @username msg. Для изменении свое имя отправьте сообщеня: name=new_name");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scannerIn = new Scanner(socket.getInputStream());


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (scannerIn.hasNext()){
                    System.out.println(scannerIn.nextLine());
                }
            }
        }).start();


        String message;
        while (!socket.isClosed()){
            message = new Scanner(System.in).nextLine();
            try {
                if(!message.equals("")) {
                    bufferedWriter.write(message);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                if (message.equals("quit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
