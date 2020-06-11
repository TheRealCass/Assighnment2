import java.util.Arrays;
import java.util.Random;

class Main
{
	// Number of elements to be sorted
	private static final int N = 10;

	// Number of sorting runs
	private static final int NUM = 10;

	// perform insertion sort on arr[]
	public static void insertionSort(int[] arr, int low, int n)
	{
		// Start from second element (element at index 0
		// is already sorted)
		for (int i = low + 1; i <= n; i++)
		{
			int value = arr[i];
			int j = i;

			// Find the index j within the sorted subset arr[0..i-1]
			// where element arr[i] belongs
			while (j > low && arr[j - 1] > value)
			{
				arr[j] = arr[j - 1];
				j--;
			}
			// Note that subarray arr[j..i-1] is shifted to
			// the right by one position i.e. arr[j+1..i]

			arr[j] = value;
		}
	}

	public static int Partition (int[] a, int low, int high)
	{
		// Pick rightmost element as pivot from the array
		int pivot = a[high];

		// elements less than pivot will be pushed to the left of pIndex
		// elements more than pivot will be pushed to the right of pIndex
		// equal elements can go either way
		int pIndex = low;

		// each time we finds an element less than or equal to pivot,
		// pIndex is incremented and that element would be placed
		// before the pivot.
		for (int i = low; i < high; i++)
		{
			if (a[i] <= pivot)
			{
				
                swap(a, i, pIndex++);
			}
		}
        // swap pIndex with Pivot
        swap(a, pIndex, pivot);
		

		// return pIndex (index of pivot element)
		return pIndex;
	}

	public static void QuickSort(int[] a, int low, int high)
	{
		// base condition
		if (low >= high)
			return;

		// rearrange the elements across pivot
		int pivot = Partition(a, low, high);

		// recur on sub-array containing elements less than pivot
		QuickSort(a, low, pivot - 1);

		// recur on sub-array containing elements more than pivot
		QuickSort(a, pivot + 1, high);
	}

	public static void optimizedQuickSort(int[] A, int low, int high)
	{
		while (low < high)
		{
			// do insertion sort if 10 or smaller
			if (high - low < 10)
			{
				insertionSort(A, low, high);
				break;
			}
			else
			{
				int pivot = Partition(A, low, high);

				// tail call optimizations - recur on smaller sub-array
				if (pivot - low < high - pivot) {
					optimizedQuickSort(A, low, pivot - 1);
					low = pivot + 1;
				} else {
					optimizedQuickSort(A, pivot + 1, high);
					high = pivot - 1;
				}
			}
		}
    }
    

    

    private static void swap( int[] array, int i, int j ) {
		int temp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = temp;
    } // end swap

	public static void main(String[] args)
	{
		int[] arr = new int[N];

		
        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int) (Math.random() * 100.0);
        }
        
        System.out.println("to sort: " + Arrays.toString(arr));

        optimizedQuickSort(arr, 0, N-1);

        System.out.println("to sort: " + Arrays.toString(arr));


			
		

	}
}