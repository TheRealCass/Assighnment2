import java.util.*;

public class QuickSortv2 {



    private static final boolean DEBUG = true;
    private static Random generator = new Random(System.nanoTime());

    public static void main(String[] args) {

        int[] input = new int[50];
        for (int i = 0; i < input.length; i++) {
            input[i] =(int) (Math.random() * 100.0);
        }
        System.out.println("to sort: " + Arrays.toString(input));
        QuickSort qs = new QuickSort();
        //qs.sort(input);

        quickSort(input);
        System.out.println("Sorted: " + Arrays.toString(input));

        



    }



    

    public static  void quickSort(int [] toSort) {
        quickSort(toSort, 0, toSort.length - 1);

    }
    
    
    private static void quickSort(int[] toSort, int start, int end) {
        int pivotPos;
        if (2 == (end - start)) {
            if (toSort[start + 1] < toSort[start]) {
                swap(toSort, start, start + 1);   
            }
        } else if (2 < (end - start) ) {
            choosePivot(toSort, start, end);
            pivotPos = partition(toSort, start, end);
            quickSort(toSort, start, pivotPos);
            quickSort(toSort, pivotPos + 1, end); 
        }  
    }

    private static int partition(int[] toSort, int start, int end) {
        int bigStart = start + 1;
        int pivot = toSort[start];
        for (int curr = start + 1; curr < end; curr++) {
            if(toSort[curr] <= pivot) {
                swap(toSort, bigStart++, curr);
            }
        }
        swap(toSort, start, bigStart - 1);
        return bigStart -1;
    }

    private static void choosePivot(int[] toSort, int start, int end) {
        int medOfThree = (end - start) >> 1;
        if(DEBUG)
            System.out.println("pivot: " + toSort[medOfThree]);
        swap(toSort, medOfThree, start);
    }

    private static void swap( int[] array, int i, int j ) {
        if(DEBUG)
            System.out.println("to swap : " + array[i] + " and " + array[j]);
		int temp = array[ i ];
		array[ i ] = array[ j ];
        array[ j ] = temp;
        if(DEBUG)
            System.out.println("swaped: " + Arrays.toString(array));

    }

    


































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