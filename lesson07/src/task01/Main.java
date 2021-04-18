package task01;

public class Main {
   public static void main(String[] args) {
      Integer[] m = {3, 5, 1, 7, 4, 45, 23, 53};
      Util.javaSort(m);
      for(Integer l:m)
         System.out.println(l);
   }
}
