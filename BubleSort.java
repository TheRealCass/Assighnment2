import java.util.Arrays;

public class BubleSort {



    //this might be bubble sort
    
    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorte
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));


    }


    //compleated sort
    public static void sort(int[] toSort) {

        while (!isSorted(toSort)) {
            for (int i = 0; i < toSort.length; i++) {
                if ((i + 1 < toSort.length) && (toSort[i] > toSort[i+1])) {
                    swap(toSort, i, i+1);
                    if(DEBUG)
                        System.out.println(Arrays.toString(toSort));
                }
            }
        }
    }


















    

    private static void swap( int[] array, int i, int j ) {
		int temp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = temp;
    } // end swap


    public static boolean isSorted( int[] array ) {
        boolean sorted = true;
    
        // Loop through all adjacent pairs in the
        // array and check if they are in proper order.
        // Stops at first problem found.
        for ( int i = 1; sorted && (i < array.length); i++ )
          sorted = array[i-1] <=  array[i];
        return sorted;
      } // end method isSorted
    public static int[] bubblesort(int[] args) {
        System.out.println("Normal BubbleSort:");
        for (int j = 0; j < args.length; j++) {
            for (int i = 0; i < args.length; i++) {
                int currentNumber = args[i];
                if (i + 1 < args.length) {
                    if (currentNumber > args[i + 1]) {
                        args[i] = args[i + 1];
                        args[i + 1] = currentNumber;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(args));
        return args;
    }


}