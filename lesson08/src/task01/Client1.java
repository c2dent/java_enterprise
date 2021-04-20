package task01;

import java.io.IOException;

public class Client1 {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.main();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
