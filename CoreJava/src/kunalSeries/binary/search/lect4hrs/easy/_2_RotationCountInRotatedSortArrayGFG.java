package kunalSeries.binary.search.lect4hrs.easy;

import java.util.Arrays;

// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=15     at 3:20:00 TS
// TODO: GFG (flipkart amazon) : Rotation Count in a Rotated Sorted array
// GFG: https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
// Sol: Striver -> https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
//
public class _2_RotationCountInRotatedSortArrayGFG {

    // Brute Force Approach
    /*
    Algorithm: read above *striver link* for all brute to optimize
First, we will declare an ‘ans’ and an ‘index’ variable initialized with a large number and -1 respectively.
Next, we will iterate through the array and compare each element with the variable called ‘ans’. Whenever we encounter an element 'arr[i]' that is smaller than ‘ans’, we will update ‘ans’ with the value of 'arr[i]' and also update the 'index' variable with the corresponding index value, 'i'.
Finally, we will return ‘index’ as our answer.
     */
 // just need to find the min elem and return its index
    public int countRotationsBruteForce(int[]arr){
        // this check not neede since in loop we are handling everything
//        if (arr[arr.length-1]==arr.length && arr[0]<arr[arr.length-1]) // The given array is not rotated. {1, 2, 3, 4, 5} BUT Won't work for this  {6, 9, 2, 4}; since here len=4 and last indx = 4 but still rotated
//            return 0;                                                       // but after adding && arr[0]<arr[arr.length-1] condition we can avoid above issue

        int index  = -1;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
                index  = i;
            }
        }
      System.out.println("Min ele indx : " + index  + " and Ele "  + arr[index ]);
      return index ;
    }


    public int countRotations(int[]arr){

//        if (arr[arr.length-1]==arr.length && arr[0]<arr[arr.length-1]) // The given array is not rotated. {1, 2, 3, 4, 5} BUT Won't work for this  {6, 9, 2, 4}; since here len=4 and last indx = 4 but still rotated
                                                                            // but after adding && arr[0]<arr[arr.length-1] condition we can avoid above issue
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // Eliminate left half:
                low = mid + 1;
            } else { //if right part is sorted:

                // keep the minimum:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        _2_RotationCountInRotatedSortArrayGFG obj =new _2_RotationCountInRotatedSortArrayGFG();
//        int[] nums = {5, 1, 2, 3, 4}; // 1
        int[] nums = {15, 18, 2, 3, 6, 12}; // 2
//        int[] nums = {7, 9, 11, 12, 5}; // 4
//        int[] nums = {6, 9, 2, 4}; // 2
//        int[] nums = {1, 2, 3, 4, 5}; // 0

        System.out.println("Array : " + Arrays.toString(nums));
        int rotationLS = obj.countRotationsBruteForce(nums); // with Brute Force Approach
        int rotationBS = obj.countRotations(nums); // with two BS
        System.out.println("With LS- The array is rotated " + rotationLS + " times.");
        System.out.println("WIth BS - The array is rotated " + rotationBS + " times.");
    }
}

// TODO : Ans - pivotIndex+1 => since this many element will come after rotation before the pivot. +1 since index starts from zero
// Or We can easily observe that the number of rotations in an array is equal to the index(0-based index) of its minimum element.
        // So, in order to solve this problem, we have to find the index of the minimum element.