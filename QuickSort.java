import java.util.Arrays;

public class QuickSort {



    private static final boolean DEBUG = true;

    public static void main(String[] args) {

        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorte
        System.out.println("to sort: " + Arrays.toString(input));
        QuickSort qs = new QuickSort();
        qs.sort(input);

        System.out.println("Sorted: " + Arrays.toString(input));

        



    }


    // public static void quickSort(int[] toSort) {
    //     quickSort(toSort, 0, toSort.length);
    // }

    // private static void quickSort(int[] toSort, int start, int end) {

    //     int pivotPos;
        
    //     if (2 == (end - start)) {
    //         if (toSort[start + 1] < toSort[start]) {
    //             swap(toSort, start, start + 1);
    //         }
    //     } else if (2 < (end - start) ) {
    //         choosePivot(toSort, start, end);
    //     }
    //     // if(1 < end - start) {
    //     //     choosePivot(toSort, start, end);
    //     //     pivotPos = partition(toSort, start, end);
    //     //     quickSort(toSort, start, pivotPos);
    //     //     quickSort(toSort, pivotPos + 1, end);
    //     // }
    // }

    // private static int partition(int[] toSort, int start, int end) {
    //     return 0;
    // }

    // private static void choosePivot(int[] toSort, int start, int end) {
    // }

    // private static void swap( int[] array, int i, int j ) {
	// 	int temp = array[ i ];
	// 	array[ i ] = array[ j ];
	// 	array[ j ] = temp;
    // } // end swap

    


































    //=-==================================================v2==============================================

    int[] array;

    public int[] sort (int[] array) {
        this.array = array;
        quickSort (0, array.length -1);
        return array;
    }

    public void quickSort(int start, int end) {
        if(start >= end) {
            return;
        }

        if(DEBUG)
            System.out.println("quicksort from " + array[start] + " to " + array[end]);


        int pivot = array[end];
        if(DEBUG)
            System.out.println("pivot selected as :" + pivot);

        
        int counter = start;

        for (int i = start; i < end; i++) {
            
            if((array[i] - pivot) <= 0) {

                if(DEBUG)
                    System.out.println(array[i] + " is smaller then " + pivot);


                swap(i, counter++);
                if(DEBUG){
                    System.out.println("sorting: " + Arrays.toString(array));
                    System.out.println("counter index position:" + counter);
                }

            } else {
                if(DEBUG)
                    System.out.println(array[i] + " is not smaller then " + pivot + "\t no change done");
            }
        }

        swap(counter, end);
        if(DEBUG)
            System.out.println("sorting: " + Arrays.toString(array));

        quickSort(start, counter -1);
        quickSort(counter +1, end);
    }

    public void swap(int i, int j) {
        if(DEBUG)
            System.out.println("Swaping " + array[i] + " with " + array[j]);
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    
}