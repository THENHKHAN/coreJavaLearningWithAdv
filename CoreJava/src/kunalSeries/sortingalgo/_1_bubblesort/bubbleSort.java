package kunalSeries.sortingalgo._1_bubblesort;

import java.util.Arrays;


// Kunal - Bubble Sort Algorithm - Theory + Code : https://www.youtube.com/watch?v=F5MZyqRp_IM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=17
// 32:00:00 for stable and unstable Algo conceptual knowledge - or go in readme.md there have multiple article.
// [NotesKunalLect](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/11-sorting/Handwritten%20notes%20on%20bubble%20sort.pdf.pdf)
public class bubbleSort {
    public static void myBubbleSort(int[]arr){
        // as a pass counter
        for (int i = 0; i < arr.length; i++) {
            // for each step, maximum element will come at last index to respective of ith pass. for i=0 then max will be at ArraySize-1, i=1 then ArraySize-1-1  OR simply size-i-1
            for (int j = 0; j < arr.length-i-1; j++) { // -1 since we can't compare last element to anyone
                // arr.length-i  since as we passed increases the ending element will be sorted so skipping. in Ith pass ith element will be sorted from end ith start from 1 since number of element can't be counted from 0th.
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp  ;
                }

            }// inner loop end
        } // outer loop end
    }

    public static boolean myBubbleSortCheckArrayAlreadySortedOrNot(int[]arr){
        boolean swapped = false;
        // as a pass counter
        for (int i = 0; i < arr.length; i++) {
            // for each step, maximum element will come at last index to respective of ith pass. for i=0 then max will be at ArraySize-1, i=1 then ArraySize-1-1  OR simply size-i-1
            for (int j = 0; j < arr.length-i-1; j++) { // -1 since we can't compare last element to anyone
                // arr.length-i  since as we passed increases the ending element will be sorted so skipping. in Ith pass ith element will be sorted from end ith start from 1 since number of element can't be counted from 0th.
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp  ;
                    swapped = true;
                }

            }// inner loop end

            // if did not swapped for a particular value or i, it means the is sorted hence stop the program and not need to check further pass.
            // If no swaps occurred in a pass, the array is already sorted
            if (!swapped) // !false will give me true - this will run only when if no swapping occurred.
                break;
        } // outer loop end

        // If no swaps were needed, the array was already sorted
        return !swapped;
    }

    public static void main(String[] args) {
//        int[] arr = {3,1,5,4,2};
//        int[] arr = {1,2,3,4,5};
        int[] arr = {10,4,67,3,9,57,25,58,0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        myBubbleSort(arr);
        System.out.println("After bubble sort Array: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5] , [0, 3, 4, 9, 10, 25, 57, 58, 67]
    // Space : O(1) since array is in-place

        // let's check array already sorted or not ?
//        int[] arr2 = {1,2,3,4,5}; // true
        int[] arr2 = {3,1,5,4,2}; // fasle

        boolean res = myBubbleSortCheckArrayAlreadySortedOrNot(arr2);
        System.out.println("Original Array checking Already Sorted or Not: " + Arrays.toString(arr2));
        System.out.println("Array Already Sorted or Not ?   " + (res? "Already Sorted" : "Not Already Sorted"));


    }
}

// TODO:
//  for (int i = 0; i < n - 1; i++) {    outer loop
/*
Explanation:
        Purpose: Controls the number of passes through the array.
Why n - 1?
    After each pass, the largest unsorted element moves to its correct position.
    For an array of size n, at most n - 1 passes are required because after sorting n - 1 elements, the last element is automatically in place.
    What does i represent?
        i tracks how many passes have been completed.
        It indirectly tells us how many elements at the end of the array are already sorted.
 */
// TODO: for (int j = 0; j < n - i - 1; j++) {   inner loop
/*
Explanation:
    Purpose: Compares adjacent elements and performs swaps during each pass.
Why n - i - 1?
    With each pass (i), the largest element from the unsorted portion of the array is moved to its correct position at the end.
    This means for the next pass, the last i elements are already sorted and don't need to be checked again.
    Hence, the inner loop's range decreases dynamically as i increases.
    What does j represent?
          j is the index of the current element being compared with its adjacent element (j + 1).
 */

/*
TODO: Key Insight:
The outer loop (i) controls the number of passes.
The inner loop (j) dynamically shortens the range of comparisons as sorted elements accumulate at the end of the array.
This combination ensures Bubble Sort avoids unnecessary comparisons and becomes more efficient as the array gets closer to being sorted.
 */