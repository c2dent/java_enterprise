package task01;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.GenerateArray();
    }

    public void GenerateArray(){
        Set<int[]> arr = new HashSet<int[]>();
        int[] temp;
        int i = 1;
        while (true){
            temp = new int[i];
            arr.add(new int[i]);
            i += 10;
        }
    }
}
