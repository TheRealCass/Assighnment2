import java.util.Arrays;

/**
 * SelectionSort
 */
public class SelectionSort {


    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorted
        int[] input2 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorted
        System.out.println("Asian dude\n");
        selectionSortv2(input);
        System.out.println("\nMe\n");
        sortV101(input2);






        //System.out.println(findMin(input, 0, input.length));


    }

    // =====================END PRODUCT=====================================//

    /**
     * non recursive selection sort
     * @param array array to sort
     * @return void
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            int nm = findMin(array, i, array.length);
            if(min != nm){
                swap(array, min, nm);
                if(DEBUG)
                    System.out.println("sorting: " + Arrays.toString(array));
            }
        }
    }

    /**
     * finds the index of the smallest item in an array within a given bound
     * @param array array to go through
     * @param start index to start looking from
     * @param end index to end looking
     * @return the index of the smallest item in the array
     */
    private static int findMin(int[] array, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            if( array[index] > array[i]) {
                index = i;
            }
        }    
        return index;
    }


    private static void swap( int[] array, int i, int j ) {
		int temp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = temp;
    } // end swap

    // ========================================TRIAL==============================================//

    /**
     * v1
     */
    public static void sort(int[] toSort) {
        int[] input = toSort.clone();
        int currentMIn = 0;
        int currentItem = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (input[currentMIn] < input[currentItem]) {
                swap(toSort, currentMIn, currentItem);
            } else {
                currentItem++;
            }
            
        }
    }

    /**
     * v2
     * asian dude
     */
    public static void selectionSortv2(int[] arr){

        System.out.println("to sort:  " + Arrays.toString(arr));

        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){    //选出之后待排序中值最小的位置
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];      //交换操作
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }

        System.out.println("Sorted:  " + Arrays.toString(arr));

    }

    /**
     * v1.1
     * piece de resistance
     * @param toSort
     */
    public static void sortV101(int[] toSort) {
        System.out.println("to sort: " + Arrays.toString(toSort));

        
        for (int i = 0; i < toSort.length; i++) {
            int min = i;
            int nm = findMin(toSort, i, toSort.length);
            if(min != nm){
                swap(toSort, min, nm);
                System.out.println("sorting: " + Arrays.toString(toSort));
            }
        }
       
        System.out.println("Sorted: " + Arrays.toString(toSort));

    }
    





    
}