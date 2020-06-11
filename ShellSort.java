import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int) (Math.random() * 100.0);
        }
        System.out.println("to sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("sorted: " + Arrays.toString(arr));

    }
    

    public static void sortv2(int[] array) {
        int inner, outer;
        int t;
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                t = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= t) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = t;
            }
            h = (h - 1) / 3;
        }
    }
        






    /**
     * non recursive shell short
     * @param toSort array to sort
     */
    public static void sort(int[] toSort) {
        int size = toSort.length;
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int key = toSort[i];
                int j = i;
                while ((j >= gap) && (toSort[j - gap] > key)) {
                    toSort[j] = toSort[j - gap];
                    j -= gap;
                }
                toSort[j] = key;
            }
        }
    }
  
}