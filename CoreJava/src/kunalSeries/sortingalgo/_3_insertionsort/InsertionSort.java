package kunalSeries.sortingalgo._3_insertionsort;

import java.util.Arrays;
// Babbar - INSERTION SORT  Algorithm - Theory + Code :https://www.youtube.com/watch?v=7kIVfVY6Axk
// Kunal - INSERTION SORT  Algorithm - Theory + Code : https://www.youtube.com/watch?v=By_5-RRqVeE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20
// [NotesKunalLect](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/11-sorting/Handwritten%20Notes%20on%20Insertion%20Sort.pdf.pdf)
// W3school: https://www.w3schools.com/dsa/dsa_algo_insertionsort.php
// GFG: https://www.geeksforgeeks.org/insertion-sort-algorithm/

public class InsertionSort {

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // we are taking 1st element is sorted that's y started from 1th index. ALso so that we can compare with i+1 index
            int current_value = arr[i];
            for (int j = i-1 ; j >= 0; j--) { // i-1 => so that we can  compare with 1st and oth element :  OR j = i-1 to 0 and int this case j+1 wont exceed the indexoutofBound
            // It basically saying sort the array till index ith.

                if (arr[j+1]<arr[j]){  // so basically comparing 1st with ith element and the one by i-1 , i-2 , i-3 .... till oth for that using j so that we can  traverse back. And for i only for traversing all the element till the lenght-1
                    int temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = temp;
                } else  // draw on paper you'll understand better.
                        break; // since from ith to RHS will be unsorted so if ith<i-1 then no need to go BACK(LHS of ith)

            } // innder loop

        } // outer loop
    } // U can also check whether this array is sorted already or Not . Check the Selection Sort program. Same connect will be used  here.

    public static void main(String[] args) {
//        int[] arr = {3,1,5,4,2};
//        int[] arr = {1,2,3,4,5};
        int[] arr = {1,-12,3,-4,5};
//        int[] arr = {10,4,67,3,9,57,25,58,0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Insertion Sort Array: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5] , [0, 3, 4, 9, 10, 25, 57, 58, 67]
        /*
        Time Complexity of Insertion Sort
                                        Best case: O(n) , If the list is already sorted, where n is the number of elements in the list.
                                        Average case: O(n^2 ) , If the list is randomly ordered
                                        Worst case: O(n^2 ) , If the list is in reverse order
        Space Complexity of Insertion Sort
                                        Auxiliary Space: O(1), Insertion sort requires O(1) additional space, making it a space-efficient sorting algorithm
         */
    }


}
