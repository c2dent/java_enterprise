package task03;
import task01.Util;
public class Main {
    public static Integer[] generateArr(int arrLen){
        Integer[] tmp = new Integer[arrLen];
        for (int i = 0; i < arrLen; i++) {
            tmp[i] = (int) ((Math.random() * 1000001));
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10000, 100000, 1000000};

        for (int i = 0; i < arr.length; i++) {
            long meanValueBubble = 0;
            long meanValueArrSort = 0;
            for (int j = 0; j < 2; j++) {
                long t = System.currentTimeMillis();
                Util.bubbleSort(generateArr(arr[i]));
                meanValueBubble += System.currentTimeMillis() - t;

                t = System.currentTimeMillis();
                Util.javaSort(generateArr(arr[i]));
                meanValueArrSort += System.currentTimeMillis() - t;
            }

            System.out.println(
                    "Среднее время выполнения сортировки на пузырковым алг с " + arr[i] + " элементом: " + (meanValueBubble / 10) + " мс\n" +
                            "Среднее время выполнения сортировки на Arrays.Sort с " + arr[i] + " элементом: " + (meanValueArrSort / 10) + " мс\n"
            );
        }
    }
}
