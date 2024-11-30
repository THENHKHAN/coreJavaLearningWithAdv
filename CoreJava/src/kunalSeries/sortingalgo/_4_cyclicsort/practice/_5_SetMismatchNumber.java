package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 1:12:00 TS
// TODO: 645. Set Mismatch : since [1, n] used in the question so directly think of CYCLE Sort concept
                        // CLue for Cyclic sort concept use: //originally contains all the numbers from 1 to n.
// Question : https://leetcode.com/problems/set-mismatch/description/
// try to read question statement and then you dont have think much. it clearly said what is given wrong and what can be right
import java.util.Arrays;

public class _5_SetMismatchNumber {

    // not useful for this question i have added this bcz i wanted to see the sorted array as well
    public void cyclicSort(int[] arr){
        int n = arr.length;
        int i = 0 ;
        while (i<n){
            // correctIndex = value-1  // checking correct index for current element processing. It should be at this index. If yes then nothing will change and if NO, then swap the current
            // processing element(ith element) with this correctIndex.
            int correctIndex = arr[i]-1; // since values started from 1 [1, N] and since index also starts from 0
            if (correctIndex<n && arr[i] != arr[correctIndex] )  // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(arr, i , correctIndex); // we don't have to increment i since after swapping one element  will be at the correct index but may be the other element not. check this {4,1,0,5,3,2};
                // i=0:  {3,1,0,5,4,2} 4 is at correct but not 3
            else
                i++;
        } // since behaviours is not same in each iteration Hence not using for loop . So that's y using while loop.

    }


    public void swap(int[]arr, int i , int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        int[] res = new int[2];
        // Cycle Sort
        while (i<n){
            int correctIndex = nums[i]-1; // since correctIndx = value-1 since [1 N] case-1 type
            if (correctIndex<n && nums[i] != nums[correctIndex]) // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(nums, i, correctIndex); // we don't have to increment i since after swapping one element  will be at the correct index but may be the other element not. check this {4,1,0,5,3,2};
                   // i=0:  {3,1,0,5,4,2} 4 is at correct but not 3
            else
                i++;

        }
        // to traverse the array and if you found any element that is not equal to the index(ith+1 sine [1,N]) then that index will be our answer.
       // search for Error number and finding the correct number that can be place at the correct index
        for (int indx = 0; indx < n; indx++) {
            if (nums[indx] != indx+1){
                  res[0] = nums[indx]; // error or duplicate number
                  res[1] = indx+1; // correct number
                  break;
            }

        }

        return res ;
    }

    public static void main(String[] args) {
        _5_SetMismatchNumber obj = new _5_SetMismatchNumber();
//          int[] arr = {1,2,2,4}; // [2,3], - [error, correctNum]
          int[] arr = {1,1}; // [1,2], - [error, correctNum]
        System.out.println("Original Array: " + Arrays.toString(arr));
        int[] errorNums = obj.findErrorNums(arr);
        obj.cyclicSort(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("Error number and correct number from above Array: " + Arrays.toString(errorNums));
    }
}
/*

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]


 */