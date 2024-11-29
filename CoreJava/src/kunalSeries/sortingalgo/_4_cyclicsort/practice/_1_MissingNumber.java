package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 22:00 TS
// TODO: 268. Missing Number : since [0, n] used in the question so directly think of CYCLE Sort concept
// Question : https://leetcode.com/problems/missing-number/description/

import java.util.Arrays;

public class _1_MissingNumber {

    // not useful for this question i have added this bcz i wanted to see the sorted array as well
    public void cyclicSortCase2(int[] arr){
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


    public void swap(int[]arr, int i , int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        // Cycle Sort
        while (i<n){
            int correctIndex = nums[i]; // since correctIndx = value since [0 N] case-2 type
            if (correctIndex<n && nums[i] != nums[correctIndex])
                swap(nums, i, correctIndex);
            else
                i++;
        }
        // to traver the array and if you found any element that is not equal to the index(ith) then that index will be our answer.
       // search for first missing number
        for (int j = 0; j < n; j++) { // 0 <= nums[i] <= n hence will start loop from 0
            if (nums[j] != j)
                return j;
        }
        // if all the index value present at their correct index then there is only one number that is missing the length of array.
        return n ;// if all present then the last index element will be missing that it did not encounter the return statement(after traversing loop) since loop end(last index = length-1) successfully without intern
    }

    public static void main(String[] args) {
        _1_MissingNumber obj = new _1_MissingNumber();
//        int[] arr = {4,6,1,5,3,2}; // not valid array since range is given. It's a case -2 type question asked=> [0 N]
//        int[] arr = {4,1,0,5,3,2}; // case -2 => [0 N]   - // correctIndex = value     since index starts from 0  and our lowest value will be 0
//        int[] arr = {3,0,1}; // 2,  // lc test case-2
//        int[] arr = {0,1}; // 2,  // lc test case-2
        int[] arr = {9,6,4,2,3,5,7,0,1}; // 8,  // lc test case-3
//        int[] arr = {0}; // 1, no need to check since in Constraints : it mentioned (1 <= n <= 10^4)the light and number wil lie. Hence, at least one element will be there
//        int[] arr = {}; // 0,
        System.out.println("Original Array: " + Arrays.toString(arr));
        int missingNumber = obj.missingNumber(arr);
        obj.cyclicSortCase2(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("Missing number from above Array: " + missingNumber);
    }
}
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
/*
Constraints:

        n == nums.length
        1 <= n <= 10^4
        0 <= nums[i] <= n
        All the numbers of nums are unique.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 */