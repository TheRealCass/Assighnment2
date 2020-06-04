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

    
    private static void swap( int[] array, int i, int j ) {
		int temp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = temp;
    } // end swap
}