public class InsertionSort {
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorted
        sort(input, 0, input.length);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
        
    }



    //fianl compleate version without wile loop
    public static void sort (int[] toSort, int start, int end) {

        for (int i = 0; i < toSort.length -1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (toSort[j-1] >= toSort[j]) {
                    swap(toSort, j, j-1);
                }
            }
        }
    }



    
    
    /**
     * non recurcive insertion sort
     * @param toSort int array to sort
     * @return sorted int array
     */
    public static int[] insertionSort2 (int[] toSort) {
        int[] input = toSort.clone();
        //int tracker;

        while (!isSorted(input)) {
            for (int i = 1; i < input.length; i++) {
                if (input[i] < input[i-1]) {
                    swap(input, i, i-1);
                }
            }
        }
        return input;
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




    //got from the web
    public static void insertionSort (int[] toSort) {
        int[] input = toSort.clone();
        int key;  
        int i;
        int j; //the number of items sorted so far
        
        for ( j = 1; j < input.length ; j++) { // start with 1 not 0
            key = input[j];
            
            
            for (i = j-1; (i > -1) && ( input [i] > key ); i -- ) { // smaller values moving up
                
                input [i+1] = input [i];
                
            }
            
            input[i+1] = key; // put the key in its proper location
        }
        
        // Display the sorted Array
         for (j = 0; j < input.length ; j++) {
           
            System.out.print(input[j] +"," );
        }
    }
   
}
