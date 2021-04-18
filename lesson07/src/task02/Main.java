package task02;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        Integer[] m = {6, 1, 5, 6, 23, 89, 43, 34, 63, 223, 547, 33, 23, 67};
        ArraySort arrSort = new ArraySort();

        Sorts sort = (Sorts) Proxy.newProxyInstance(
                arrSort.getClass().getClassLoader(),
                arrSort.getClass().getInterfaces(),
                new SortProxy(arrSort)
        );
        sort.bubbleSort(m);

        for(Integer l:m)
            System.out.println(l);
    }
}
