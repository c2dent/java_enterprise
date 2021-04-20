package task02;

import java.io.IOException;

public class Client3 {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.main();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
