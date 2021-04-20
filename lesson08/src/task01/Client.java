package task01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void main() throws IOException {
        Socket socket = new Socket("127.0.0.1", 4999);

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
        while (!(message = new Scanner(System.in).nextLine()).equals("")){
            try {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
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
