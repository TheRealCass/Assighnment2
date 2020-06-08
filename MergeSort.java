import java.util.Arrays;
public class MergeSort {

    public static void main(String[] args) {
        int[] input2 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 }; // array to be sorted
        System.out.println("to Sort: " + Arrays.toString(input2));

        // mergingSort(input2);
        //mergeSortV2(input2);
        MergeSort.sortv3(input2);
        System.out.println("to Sort: " + Arrays.toString(input2));

    }

    // ================================END
    // PRODUCT=======================================================================

    /**
     * recursive merge sort
     * 
     * @param array
     */
    public void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }
    // ====================================================================================================================

    /**
     * asian dude v1
     */
    public static int[] mergingSort(int[] arr) {
        if (arr.length <= 1)
            return arr;

        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr)); // 不断拆分为最小单元，再排序合并
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length]; // 申请额外的空间存储合并之后的数组
        while (i < arr1.length && j < arr2.length) { // 选取两个序列中的较小值放入新数组
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) { // 序列1中多余的元素移入新数组
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) { // 序列2中多余的元素移入新数组
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }

    // =======================================================================================================================

    /*
     * v2 
     * 
     */
    public static void mergeSortV2(int[] input, int s, int e) {

        int m = (s + e) / 2;

        int temp[] = new int[e - s + 1];

        //=====================================

        int s1 = s;
        int s2 = m + 1;

        int i = s1;
        int j = s2;
        int p = 0;
        while (i <= m && j <= e) {
            if (input[i] > input[j]) {
                temp[p] = input[j];
                j++;
                p++;
            } else {
                temp[p] = input[i];
                i++;
                p++;
            }
        } // end of while loop

        while (i <= m) {
            temp[p] = input[i];
            p++;
            i++;
        }
        while (j <= e) {
            temp[p] = input[j];
            p++;
            j++;
        }

        for (int k = 0; k < temp.length; k++) {
            input[s + k] = temp[k];
        }
    }

    public static void callsort(int[] input, int s, int e) {

        if (s >= e) {
            return;
        }

        int m = (s + e) / 2;

        callsort(input, s, m);
        callsort(input, m + 1, e);
        merge(input, s, e);

    }

    /*
     * v2 
     * @author stackoverflow.com
     */
    public static void mergeSortV2(int[] input) {
        callsort(input, 0, input.length - 1);
    }

    // ==============================================================================================================

    /**
     * recursive merge sort
     * calls helep recursive method
     * 
     * @param toSort array to sort
     * @see private method: mergeSort
     * 
     */
    public static void sortv3(int[] toSort) {
        int[] newArr = null;
        mergeSort(toSort, 0, toSort.length -1, newArr);

    }

    /**
     * breaks downs the array till the length is 1 and calls merge method
     * @param toSort    array to sort
     * @param start start position to sort from
     * @param end   position to stop sorting from
     * @param newArr    temp array to store sorted data in
     * @see merge
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
     * sorts and merges the 2 halves as it progresses
     * @param toSort    array to sort
     * @param start     start position to sort from
     * @param mid       middle position of the array
     * @param end       position to stop sorting from
     * @param newArr    temp array to store the sorted data
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

        for (int k = 0; k < newArr.length; k++) {
            toSort[start + k] = newArr[k];
        }

    }
}

    