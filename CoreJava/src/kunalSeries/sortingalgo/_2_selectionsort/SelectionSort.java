package kunalSeries.sortingalgo._2_selectionsort;


// Babbar - Selection Sort Algorithm - Theory + Code : https://www.youtube.com/watch?v=UdO2NeHB46c
// Kunal - Selection Sort Algorithm - Theory + Code : https://www.youtube.com/watch?v=Nd4SCCIHFWk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=19
// [NotesKunalLect](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/11-sorting/Handwritten%20notes%20on%20Selection%20sort.pdf.pdf)
// GFG: https://www.geeksforgeeks.org/selection-sort-algorithm-2/

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            // assuming
                int minEleIndex = i; // since from this position we have to put the minimum value
                // finding minimum element
            for (int j = i+1; j < arr.length;  j++) { // j=i+1 since we already assumed minEleIndx = i hence will compare from next of ith element till the last index that's y arr.length
                if (arr[j]<arr[minEleIndex]){
                        minEleIndex = j;  // Update min_idx if a smaller element is found

                }
            }
            // now need to swap the ith element with the minimum element at the ith position
            // swap :  // put min at the correct position
            int temp = arr[i];
            arr[i] = arr[minEleIndex] ;
            arr[minEleIndex] = temp;

        } // outer
    }

    public static boolean mySelectionSortCheckArrayAlreadySortedOrNot(int[] arr){
        boolean alreadySorted = true;
        for (int i = 0; i < arr.length-1; i++) {
            // assuming
            int minEleIndex = i; // since from this position we have to put the minimum value
            // finding minimum element
            for (int j = i+1; j < arr.length;  j++) { // j=i+1 since we already assumed minEleIndx = i hence will compare from next of ith element till the last index that's y arr.length
                if (arr[j]<arr[minEleIndex]){
                    minEleIndex = j;
                    alreadySorted = false;
                }
            }
            // now need to swap the ith element with the minimum element at the ith position
            // swap
            int temp = arr[i];
            arr[i] = arr[minEleIndex] ;
            arr[minEleIndex] = temp;

        } // outer

        return alreadySorted;
    }


    public static void main(String[] args) {

//          int[] arr = {3,1,5,4,2};
          int[] arr = {3,1,-5,4,-2};
//        int[] arr = {1,2,3,4,5};
//        int[] arr = {10,4,67,3,9,57,25,58,0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After Selection Sort Array: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5] , [0, 3, 4, 9, 10, 25, 57, 58, 67]
        // Space : O(1) since array is in-place
        // TC: Best O(N^2) and also same for Worst : Since anyway way we have to find the minimum element. and the outer will run n times
        // let's check array already sorted or not ?
        int[] arr2 = {1,2,3,4,5}; // true
//        int[] arr2 = {3,1,5,4,2}; // false

        System.out.println("Original Array checking Already Sorted or Not: " + Arrays.toString(arr2));
        boolean res = mySelectionSortCheckArrayAlreadySortedOrNot(arr2);
        System.out.println("Array Already Sorted or Not ?   " + (res? "Already Sorted" : " Already Not Sorted"));


    }
}

/* TODO:  The selection sort is used when

--> a small list is to be sorted
--> cost of swapping does not matter
--> checking of all the elements is compulsory

 */
/*
TODO: Question 5: How does Selection Sort differ from Bubble Sort?
Answer: Selection Sort selects the minimum element and places it in the correct position with fewer swaps,
        while Bubble Sort repeatedly swaps adjacent elements to sort the array.
 */