package kunalSeries.sortingalgo._4_cyclicsort;

import java.util.Arrays;

public class CyclicSortType2RangeType {

    public static void swap(int[] arr , int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
                // other without using 3rd variable
        /*
                if a=10, b= 20;
           a = a+b; // 10+20 => 30
           b = a-b; // 30 - 20 => 10 replaced b done
           a = a-b; // 30- 10 => 20 replaced a done

         */

    }

    public static void cyclicSort(int[] arr){
        int n = arr.length;
        int i = 0 ;
        while (i<n){
            // correctIndex = value -1  // checking correct index for current element processing. It should be at this index. If yes then nothing will chnage and if NO, then swap the current
            // processing element(ith element) with this correctIndex.
            int correctIndex = arr[i]-1;
            if (correctIndex<n && arr[i] != arr[correctIndex] )  // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(arr, i, correctIndex);
            else
                i++;
        }
    }

    public static void cyclicSortCase2(int[] arr){
        int n = arr.length;
        int i = 0 ;
        while (i<n){
            // correctIndex = value  // checking correct index for current element processing. It should be at this index. If yes then nothing will change and if NO, then swap the current
            // processing element(ith element) with this correctIndex.
            int correctIndex = arr[i]; // since values started from 0 [0, N] and since index also starts from 0
            if (correctIndex<n && arr[i] != arr[correctIndex] )  // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(arr, i , correctIndex); // we don't have to increment i since after swapping one element  will be at the correct index but may be the other element not. check this {4,1,0,5,3,2};
                                                // i=0:  {3,1,0,5,4,2} 4 is at correct but not 3
            else
                i++;
        } // since behaviours is not same in each iteration Hence not using for loop . So that's y using while loop.

    }

    public static void cyclicSortHandleBothCase(int[] arr){
        int n = arr.length;
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i]<min)
                min = arr[i];
        }
        if (min == 1){  // case-1
            cyclicSort(arr);
        } else { // min == 0 case-2
            cyclicSortCase2(arr);
        }

    }

    public static void main(String[] args) {
//                int[] arr = {3,1,5,4,2}; // case -1 => [1 N]     -   // correctIndex = value -1
//                int[] arr = {3,5,1,4,2}; // case -1 => [1 N]     -   // correctIndex = value -1
//        int[] arr = {1,2,3,4,5};
//        int[] arr = {1,-2,3,-4,5}; // can't use Cyclic Sort (see the range where it valid only (read readme) ) - so Sol??
//        int[] arr = {4,6,1,5,3,2};
        int[] arr = {4,1,0,5,3,2}; // case -1 => [0 N]   - // correctIndex = value     since index starts from 0  and our lowest value will be 0
        System.out.println("Original Array: " + Arrays.toString(arr));
//        cyclicSort(arr);
//        cyclicSortCase2(arr);
        cyclicSortHandleBothCase(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5] , [0, 1, 2, 3, 4, 5]
        /*
        Time Complexity of Cyclic Sort
                                        Best case: O(n), as each element is moved at most once.
                                        Average case: O(n )
                                        Worst case: O(n) , as each element is moved at most once.
                                        Auxiliary Space: O(1), Insertion sort requires O(1) additional space, making it a space-efficient sorting algorithm
         */
    }
}

// Read Readme under Sorting Algo Package (parent of this package) - explained well and mentioned reference articles.
/*
Why Cyclic Sort Fails for Negative Numbers?????????????
Negative numbers cannot be handled directly in cyclic sort because the algorithm assumes a fixed range [1, n] or [0, 1] and relies on mapping elements to indices.
        If your dataset contains negatives, you need to either:


What If You Want to Handle Negative Numbers????????
        If your dataset includes negative numbers and you want to sort the array:
            Modify the Problem Scope:
                        Separate the negative and positive numbers, and sort them independently using different techniques.

                   Example: Partition the array into negatives and positives, and apply cyclic sort only to the positive section.

Exclude them from the cyclic sort process.
Use a different algorithm altogether.
    Use a Different Algorithm:
            For arrays with both negative and positive numbers, use general-purpose sorting algorithms like:
                -> QuickSort
                -> MergeSort
                -> Counting Sort (if numbers are within a known range
 */
/* TODO :  Handling Both Positive and Negative Numbers
public static void sortWithNegatives(int[] arr) {
    // Partition the array into negatives and positives
    int n = arr.length;
    int[] negatives = Arrays.stream(arr).filter(x -> x < 0).toArray();
    int[] positives = Arrays.stream(arr).filter(x -> x > 0).toArray();

    // Sort positives using Cyclic Sort
    cyclicSort(positives);

    // Combine the negatives and sorted positives
    int i = 0;
    for (int num : negatives) arr[i++] = num;
    for (int num : positives) arr[i++] = num;
}

public static void cyclicSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; ) {
        if (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
            swap(arr, i, arr[i] - 1);
        } else {
            i++;
        }
    }
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

 */