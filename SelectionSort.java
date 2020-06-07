/**
 * SelectionSort
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorted
        SelectionSort.sort(input);
    }

    // ======================================================END
    // PRODUCT=====================================//

    /**
     * non recursive selection sort
     * 
     * @param array array to sort
     * @return void
     */
    public static void selectionSort(int[] array) {

    }

    /**
     * *******add description******
     * 
     * @param array
     * @param start
     * @param end
     * @return ***add return statement***
     */
    private static int findMin(int[] array, int start, int end) {

        return 0;

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




    
}