import java.util.*;
import java.io.*;


/*
 * A2Q1SortingTemplate
 *
 * COMP 2140 SECTION D01 SUMMER 2020
 *
 */
public class AhamedRubaitA2Q1 {
  // Control the testing
  private static final int ARRAY_SIZE = 10000;
  //private static final int SAMPLE_SIZE = 300; // The number of trials in each experiment.
  private static final int SAMPLE_SIZE = 5; // The number of trials in each experiment.
  //sample size ahs been reset.
  private static final String NS = " nano secounds.";

  // Control the randomness
  private static final int NUM_SWAPS = ARRAY_SIZE / 2;
  private static Random generator = new Random( System.nanoTime() );

  // Control the base cases for hybrid quick sort:
  private static final int BREAKPOINT = 50;

  // Controls which sort is tried.
  private static final int INSERTION_SORT = 0;
  private static final int BUBBLE_SORT = 1;
  private static final int SELECTION_SORT = 2;
  private static final int MERGE_SORT = 3;
  private static final int QUICK_SORT = 4;
  private static final int HYBRID_QUICK_SORT = 5;
  private static final int SHELL_SORT = 6;

  /*********** main and the method it calls *************************/

  /*******************************************************************
   * main
   *
   * Purpose: Print out "bookend" messages and call the method that
   *          does all the testing of the sorting algorithms.
   *
   ******************************************************************/
  public static void main( String[] args ) {
	System.out.println( "\n\nCOMP 2140 A2Q1 Sorting Test --- Summer 2020.\n" );

	testSorts();

	System.out.println( "\nProcessing ends normally.\n" );
  } // end main


  /*******************************************************************
   * testSorts
   *
   * Purpose: Run each sorting algorithm SAMPLE_SIZE times,
   *          on an array of size ARRAY_SIZE with NUM_SWAPS
   *          random swaps performed on it.
   *          Compute the arithmetic mean of the timings for each sorting algorithm.
   *
   *          Print the results.
   *
   ******************************************************************/
  private static void testSorts() {

    // Arrays used in timing experiments (create these arrays once)
	  int[] array = new int[ARRAY_SIZE]; // array to be sorted
	  long[] sortTime = new long[ SAMPLE_SIZE ]; // store timings for multiple runs of a single sorting method
	  // Fill array to be sorted with the numbers 0 to ARRAY_SIZE.
	  // (The numbers will be randomly swapped before each sort.)
	  fillArray( array );

	  // Now run the experiments on all the sorts
	  System.out.println("Array size: " + ARRAY_SIZE + ".\nNumber of swaps: " + NUM_SWAPS + ".");
	  System.out.println("Number of trials of each sort: " + SAMPLE_SIZE + "." );

	  // Stats for each run
	  System.out.println("\nInsertion sort mean: "+tryOneSort(array, sortTime, INSERTION_SORT) + NS );
	  System.out.println("Bubble sort mean: " + tryOneSort(array, sortTime, BUBBLE_SORT) + NS );
	  System.out.println("Selection sort mean: " + tryOneSort(array, sortTime, SELECTION_SORT)+ NS );
	  System.out.println("Merge sort mean: " + tryOneSort(array, sortTime, MERGE_SORT) + NS );
	  System.out.println("Quick sort mean: " + tryOneSort(array, sortTime, QUICK_SORT) + NS );
	  System.out.println("Hybrid quick sort mean: " + tryOneSort(array, sortTime, HYBRID_QUICK_SORT) + NS );
    System.out.println("Shell sort mean: " + tryOneSort(array, sortTime, SHELL_SORT)+ NS );
    
  } // end testSorts

  /*********** methods called by testSorts *************************/

  /*******************************************************************
  * tryOneSort:
   *
   * Purpose: Get an average run time for a sorting algorithm.
   *
   * Methodology: Run the chosen sorting algorithm SAMPLE_SIZE times,
   *          on an array of size ARRAY_SIZE with NUM_SWAPS
   *          random swaps performed on it.
   *          Return the arithmetic mean of the timings.
   *
   ******************************************************************/
  private static double tryOneSort( int[] array, long[] sortTime, int whichSort ) {

	  long start, stop, elapsedTime;  // Time how long each sort takes.

		start = stop = 0; // because the compiler complains that they might not have been initialized inside the for-loop

		for ( int i = 0; i < SAMPLE_SIZE; i++ ) {
		  randomizeArray( array, NUM_SWAPS );
		  if ( whichSort == INSERTION_SORT ) {
			  start = System.nanoTime();
				insertionSort( array );
				stop = System.nanoTime();
        checkArray(array, "Insertion sort");
        
      } else if ( whichSort == BUBBLE_SORT ) {

				start = System.nanoTime();
        bubbleSort( array );
				stop = System.nanoTime();
        checkArray(array, "Bubble sort");
        
      } else if ( whichSort == SELECTION_SORT ) {
				start = System.nanoTime();
				selectionSort( array );
				stop = System.nanoTime();
        checkArray(array, "Selection sort");
        
      } else if ( whichSort == MERGE_SORT ) {
        start = System.nanoTime();
				mergeSort( array );
				stop = System.nanoTime();
        checkArray(array, "Merge sort");
        
      } else if ( whichSort == QUICK_SORT ) {
				start = System.nanoTime();
				quickSort( array );
				stop = System.nanoTime();
				checkArray(array, "Quick sort");
      } else if ( whichSort == HYBRID_QUICK_SORT ) {
				start = System.nanoTime();
				hybridQuickSort( array );
				stop = System.nanoTime();
				checkArray(array, "Hybrid quick sort");
      } else if ( whichSort == SHELL_SORT ) {
				start = System.nanoTime();
				shellSort( array );
				stop = System.nanoTime();
				checkArray(array, "Shell sort");
        }
		    elapsedTime = stop - start;
		    sortTime[i] = elapsedTime;
		} // end for

    return arithmeticMean( sortTime );
    
  } // end tryOneSort


  /********** Add sort methods here ********************/


  /**
    * non recursive shell short
    * @param toSort array to sort
    */
   public static void shellSort(int[] toSort) {
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


  /**
   * non recurcive insertion sort
   * 
   * @param array arry of intergers to sort
   * @param start index position to start sorting from
   * @param end   index position to stop sorting
   * @see swap
   */
  private static void insertionSort(int[] toSort, int start, int end) {


    for (int i = start; i < end -1; i++) {
      for (int j = i+1; j > 0; j--) {
          if (toSort[j-1] >= toSort[j]) {
              swap(toSort, j, j-1);
          }
      }
    }
	}


  /**
   * non recurcive bubble sort
   * @param array arry of intergers to sort
   * @see swap
   * @see isSorted
   */
  private static void bubbleSort(int[] array) {
    while (!isSorted(array)) {
      for (int i = 0; i < array.length; i++) {
          if ((i + 1 < array.length) && (array[i] > array[i+1])) {
              swap(array, i, i+1);
          }
      }
    }
  }


  /**
   * non recursive selection sort
   * @param array array to sort
   * @return void
   * @see swap
   * @see findMin
   */
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      int nm = findMin(array, i, array.length);
      if(min != nm){
        swap(array, min, nm);
      }
    }
  }


  /**
  * sorts and merges the 2 halves as it progresses
   * @param toSort    array to sort
   * @param start     start position to sort from
   * @param mid       middle position of the array
   * @param end       position to stop sorting from
   * @param newArr    temp array to store the sorted data
   * @see private method: mergeSort
   */
  private static void merge(int[] toSort, int start, int mid, int end, int[] newArr) {

    newArr = new int [end - start +1];

    int leftArrIndex = start;
    int rightArrIndex = mid + 1;
    int newArrIndex = 0;
      
    while (leftArrIndex <= mid && rightArrIndex <= end) {
      if (toSort[leftArrIndex] > toSort[rightArrIndex]) {
        newArr[newArrIndex] = toSort[rightArrIndex];
        rightArrIndex++;
        newArrIndex++;
      } else {
        newArr[newArrIndex] = toSort[leftArrIndex];
        leftArrIndex++;
        newArrIndex++;
      }
    }

    while (leftArrIndex <= mid) {
      newArr[newArrIndex] = toSort[leftArrIndex];
      newArrIndex++;
      leftArrIndex++;
    }
    while (rightArrIndex <= end) {
      newArr[newArrIndex] = toSort[rightArrIndex];
      newArrIndex++;
      rightArrIndex++;
    }

    for (int index = 0; index < newArr.length; index++) {
      toSort[start + index] = newArr[index];
    }

  }


  /**
    * recursive quick sort
    * just swaps value if only 2 item to sort
    * @param toSort arrt to sort
    * @param start index to start ffrom
    * @param end index to stop sorting
    */
  private static void quickSort(int[] toSort, int start, int end) {
    // base condition
    if (start >= end) {
      return;
    } else { 
    // rearrange the elements across pivot
    int pivot = partition(toSort, start, end);
    quickSort(toSort, start, pivot - 1);
    quickSort(toSort, pivot + 1, end);
    }
  }


  /**
   * hybrid quick sort
   * if array to sort has less then 50 items, insertion sort is done
   * else, quick sort is done recurcively
   * @param toSort array to sort
   * @param start index position to start sorting from
   * @param end index position to end sortiog
   * @see driver Method: hybridQuickSort 
   */
  private static void hybridQuickSort(int[] toSort, int start, int end) {
		while (start < end) {
			// do insertion sort if 50 or smaller
			if (end - start <= BREAKPOINT) {
        insertionSort(toSort, start, end +1);
        break;
			} else {
				int pivot = partition(toSort, start, end);
				// tail call optimizations - recur on smaller sub-array
				if ((pivot - start) < (end - pivot)) {
					hybridQuickSort(toSort, start, pivot - 1);
					start = pivot + 1;
				} else {
					hybridQuickSort(toSort, pivot + 1, end);
					end = pivot - 1;
				}
			}
		}
  }

  /****************** Other miscellaneous methods ********************/


  /**
   * recurcive hybrod quick sort
   * calls herlper method to do recurtion
   * @param array
   * @see private method: hybridQuickSort
   */
  private static void hybridQuickSort(int[] array) {
    hybridQuickSort(array, 0 , array.length - 1);
  }

  /**
   * swaps the small elements to the left and the big elemnts to the right of the
   * pivot
   * 
   * @param toSort array to sort
   * @param start  start position of the partition
   * @param end    end position of the array to partition
   * @return (int)
   * @see quickSort
   */
  public static int partition (int[] toSort, int start, int end)
	{
		// Pick rightmost element as pivot from the array
    int pivot = toSort[end];
    
		// elements less than pivot will be pushed to the left of pIndex
		// elements more than pivot will be pushed to the right of pIndex
		// equal elements can go either way
		int pIndex = start;

		// each time we finds an element less than or equal to pivot,
		// pIndex is incremented and that element would be placed
		// before the pivot.
		for (int i = start; i < end; i++) {
			if (toSort[i] <= pivot) {
        swap(toSort, i, pIndex++);
			}
    }
        
    // swap pIndex with Pivot
    swap(toSort, end, pIndex);

		// return pIndex (index of pivot element)
		return pIndex;
	}


  /**
    * chooces a number using the median of 3 method
    * then swaps it wwith the first element in the array
    * @param toSort array to choose pivot from
    * @param start index position to start from
    * @param end index position to end to
    * @see quickSort
    */
  private static void choosePivot(int[] toSort, int start, int end) {
    int med = start + ((end - start) / 2);
    swap(toSort, med+1, end);
  }


  /**
    * recursive quick sort by callin ganother private method
    * @param toSort
    * @see private method: quickSort
    */
   public static  void quickSort(int [] toSort) {
     choosePivot(toSort, 0, toSort.length - 1);
    quickSort(toSort, 0, toSort.length - 1);
  }


  /**
   * breaks downs the array till the length is 1, recursively and calls merge method
   * @param toSort    array to sort
   * @param start start position to sort from
   * @param end   position to stop sorting from
   * @param newArr    temp array to store sorted data in
   * @see merge
   * @see public method: mergeSort
   */
  private static void mergeSort(int[] toSort, int start, int end, int[] newArr) {
    if (start >= end) {
      return;
    } else {
      int midPoint = (start + end) /2;
      mergeSort(toSort, start, midPoint, newArr);
      mergeSort(toSort, midPoint + 1, end, newArr);
      merge(toSort, start, midPoint, end, newArr);
    }
  }


  /**
     * recursive merge sort
     * calls helep recursive method
     * 
     * @param toSort array to sort
     * @see private method: mergeSort
     * 
     */
    public static void mergeSort(int[] toSort) {
      int[] newArr = null;
      mergeSort(toSort, 0, toSort.length -1, newArr);

  }

  /**
   * non recurcive insertion sort
   * @param array arry of intergers to sort
   * @return (void)
   * @see private method: insertionSort
   */
  public static void insertionSort(int[] array) {
    insertionSort(array, 0, array.length);
  }


  /**
   * finds the index of the smallest item in an array within a given bound
   * @param array array to go through
   * @param start index to start looking from
   * @param end index to end looking
   * @return the index of the smallest item in the array
   * @see selectionSort
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

  /*******************************************************************
   * swap
   *
   * Purpose: Swap the items stored in positions i and j in array.
   *
   ******************************************************************/
  private static void swap( int[] array, int i, int j ) {
    int temp = array[ i ];
    array[ i ] = array[ j ];
    array[ j ] = temp;
  } // end swap

  /*******************************************************************
  * isSorted
   *
   * Purpose: Return true if the input array is sorted into
   *          ascending order; return false otherwise.
   *
   * Idea: If every item is <= to the item immediately after it,
   *       then the whole list is sorted.
   *
   ******************************************************************/
  public static boolean isSorted( int[] array ) {
    boolean sorted = true;

    // Loop through all adjacent pairs in the
    // array and check if they are in proper order.
    // Stops at first problem found.
    for ( int i = 1; sorted && (i < array.length); i++ )
      sorted = array[i-1] <=  array[i];
    return sorted;
  } // end method isSorted


  /*******************************************************************
  * checkArray
   *
   * Purpose: Print an error message if array is not
   *          correctly sorted into ascending order.
   *          (If the array is correctly sorted, checkArray does nothing.)
   *
   ******************************************************************/
  private static void checkArray(int[] array, String sortType) {
    if ( !isSorted( array ) )
      System.out.println( sortType + " DID NOT SORT CORRECTLY *** ERROR!!" );
  }

  /*******************************************************************
  * fillArray
   *
   * Purpose: Fills the given array with the numbers 0 to array.length-1.
   *
   ******************************************************************/
  public static void fillArray( int[] array ) {

    for ( int i = 0; i < array.length; i++ ) {
      array[i] = i;
    } // end for
  } // end fillArray

  /*******************************************************************
  * randomizeArray
   *
   * Purpose: Does numberOfSwaps swaps of randomly-chosen positions
   *          in the given array.
   *
   ******************************************************************/
  public static void randomizeArray( int[] array, int numberOfSwaps ) {
    for ( int count = 0; count < numberOfSwaps; count++ ) {
      int i = generator.nextInt( array.length );
      int j = generator.nextInt( array.length );
        swap( array, i, j );
    }
  } // end randomizeArray

  /*******************************************************************
  * arithmeticMean
   *
   * Purpose: Compute the average of long values.
   *          To avoid long overflow, use type double in the computation.
   *
   ******************************************************************/
  public static double arithmeticMean(long data[]) {
    double sum = 0;
    for (int i = 0; i < data.length; i++)
        sum += (double)data[i];
    return sum / (double)data.length;
  } // end arithmeticMean

} // end class A2Q1SortingTemplate
