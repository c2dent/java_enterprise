package task01;

import java.util.Arrays;

public class Util {
    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        T temp;
        for (int out = arr.length -1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (arr[in].compareTo(arr[in + 1]) > 0) {
                    temp = arr[in + 1];
                    arr[in + 1] = arr[in];
                    arr[in] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void javaSort(T[] arr){
        Arrays.sort(arr);
    }
}
