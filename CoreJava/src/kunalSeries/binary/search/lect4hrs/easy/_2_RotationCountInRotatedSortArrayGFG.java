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
            if (arr[i]<=min){
                min = arr[i];
                index  = i;
            }
        }
      System.out.println("Min ele indx : " + index  + " and Ele "  + arr[index ]);
      return index ;
    }

    // 1st way is to find as we find minimal in rotated sorted array. Here we have to find the index of maximal number
    // other way is kunal way. this is what will be doing here.
    public int findPivotIndex(int[] arr){
        int pivot = -1;
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;

            // case-1: when we found the pivot - m== m+1
            if (mid<r && arr[mid]> arr[mid+1]){ // m<r to avoid indexOutOfbound from  m+1. m<r if this false then  nums[m]<nums[m+1] won't even execute since && operator. That's m<r condition checked 1st
                pivot = mid;
                return pivot;
            } else if (mid>l && arr[mid]< arr[mid-1]){
                pivot = mid-1; // if 7>6 then it will be greater than the mid to r {4,5,6,7,1,2,3}. excluding mid since its already bigger than the previous one
                return pivot;
            } else if (arr[mid]<=arr[l]) {
                r = mid-1;
            } else {  // arr[m]>arr[l] // skipping the 0 to mid-1 (since it will be ASC)
                l = mid; // {4,5,6,7,1,2,3} here 4<7 is middle so we have to move forward but with mid as well
            }
        }

        return pivot;
    }

    public int countRotationsUsingPivotElement(int[]arr) {
                return findPivotIndex(arr);
    }

        // TODO: dry run this algo and rebuild ur logic and with Pivot concept
    public int countRotations(int[]arr){

//        if (arr[arr.length-1]==arr.length && arr[0]<arr[arr.length-1]) // The given array is not rotated. {1, 2, 3, 4, 5} BUT Won't work for this  {6, 9, 2, 4}; since here len=4 and last indx = 4 but still rotated
                                                                            // but after adding && arr[0]<arr[arr.length-1] condition we can avoid above issue
        int l = 0;
        int r = arr.length-1;
        int ind = -1 ;
        int ans = arr[0];
        while (l<=r) {


            // if not rotated
            // The current subarray is already sorted,
            // the minimum is at the l index
            if (arr[l]<=arr[r]){
                ind = l;
//                    System.out.println("not rotated");
                break;
            }

            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
            int mid = l+(r-l)/2;


            // if left part is sorted:  arr[0] <= ar[mid]
            // The right half is not sorted. So
            // the minimum element muSSSSSSst be in right half. But not in this case m<lower. [1,2] => mid =0 = > hence 1 but 1<=2 == l<=r the 1st case it will be handled there.

            if (arr[l]<=arr[mid]){
                if (arr[mid]<ans){
                    ans = arr[mid];
                    ind = mid;
                }
                l = mid+1;
            }
            else { // l>mid :   RIGHT part is sorted:
                if (arr[mid]<ans){
                    ind = mid;
                    ans = arr[mid];
                }
                // The right half is sorted. Note that in
                // this case, we do not change high to mid - 1
                // but keep it to mid. The mid element
                // itself can be the smallest . here will be searching from (0,mid) Ex- {15, 18, 2, 3, 6, 12};
                r = mid;
                // skipping right part : since mid<start (already checked) ==> start will always be greater than the right side from middle.
            }

        }

        return ind;
    }


    public static void main(String[] args) {
        _2_RotationCountInRotatedSortArrayGFG obj =new _2_RotationCountInRotatedSortArrayGFG();
//        int[] nums = {5, 1, 2, 3, 4}; // 1
//        int[] nums = {15, 18, 2, 3, 6, 12}; // 2
//        int[] nums = {7, 9, 11, 12, 5}; // 4
//        int[] nums = {6, 9, 2, 4}; // 2
//        int[] nums = {1, 2, 3, 4, 5}; // 0
        int[] nums = {4,5,6,7,1,2,3}; // 1
//        int[] nums = {24, 27, 45, 58, 61, 62, 64, 78, 81, 5}; // 5

        System.out.println("Array : " + Arrays.toString(nums));
        int rotationLS = obj.countRotationsBruteForce(nums); // with Brute Force Approach
        int rotationBS = obj.countRotations(nums); // with two BS
        int rotationBSPivot = obj.countRotationsUsingPivotElement(nums); // with two BS : with Pivot element
        System.out.println("With LS- The array is rotated " + rotationLS + " times.");
        System.out.println("WIth BS - The array is rotated " + rotationBS + " times.");
        System.out.println("WIth BS with Pivot element- The array is rotated " + (rotationBSPivot+1) + " times.");
    }
}

// TODO : Ans - pivotIndex+1 => since this many element will come after rotation before the pivot. +1 since index starts from zero
// Or We can easily observe that the number of rotations in an array is equal to the index(0-based index) of its minimum element.
        // So, in order to solve this problem, we have to find the index of the minimum element.