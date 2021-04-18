package task02;

public interface Sorts {
    public <T extends Comparable<T>> void bubbleSort(T[] arr);
    public <T extends Comparable<T>> void javaSort(T[] arr);
}
