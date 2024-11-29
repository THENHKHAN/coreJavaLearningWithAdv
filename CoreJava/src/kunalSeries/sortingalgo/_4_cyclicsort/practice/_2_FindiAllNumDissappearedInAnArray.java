package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 39:00 TS
// TODO: 448. Find All Numbers Disappeared in an Array: (kind of Missing Number) : since [1, n] used in the question so directly think of CYCLE Sort concept. Case-1 type where correctIndx = value-1. where value the ith index element
// Question : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _2_FindiAllNumDissappearedInAnArray {

    // not useful for this question i have added this bcz i wanted to see the sorted array as well
    public void cyclicSortCase1(int[] arr){
        int n = arr.length;
        int i = 0 ;
        while (i<n){
            // correctIndex = value-1  // checking correct index for current element processing. It should be at this index. If yes then nothing will change and if NO, then swap the current
            // processing element(ith element) with this correctIndex.
            int correctIndex = arr[i]-1; // since values started from 1 [1, N] and since index also starts from 0
            if (correctIndex<n && arr[i] != arr[correctIndex] )  // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(arr, i , correctIndex); // we don't have to increment i since after swapping one element  will be at the correct index but may be the other element not. check this {4,1,0,5,3,2};
                // for ex: check CyclicSort Implementation for more
            else
                i++;
        } // since behaviours is not same in each iteration Hence not using for loop . So that's y using while loop.

    }


    public void swap(int[]arr, int i , int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    public List<Integer> findAllDissapearedNumInArray(int[] nums) {
        int n = nums.length;
//        if (nums.length==1) // already handling below
//            return new ArrayList<>(); // handling {1} - explained below where i had made test cases.
        int i = 0 ; // loop controlling variable
        List<Integer> lst =new ArrayList<>();
        while (i<n){
            int correctIndx = nums[i]-1;// since correctIndx = value since [1 N] case-1 type
            if (correctIndx< n && nums[i] != nums[correctIndx])
                swap(nums, i, correctIndx);
                // no increment in i ? // bcz it might be possible that one elelemt is at corect inddex but not the other
            else
                i++;  // if we get same element so it adjust the already correct element indx as well as  duplicate element.
        }

        // to traver the array and if you found any element(arr[i]) that is not equal to the index(ith+1) then that index will be our answer.
       // search for first missing number
        for (int j = 1; j < n; j++) { // 0 <= nums[i] <= n hence will start loop from 0
            if (nums[j] != j+1){
                lst.add(j+1);
            }
        }
        return lst ;
    }

    public static void main(String[] args) {
        _2_FindiAllNumDissappearedInAnArray obj = new _2_FindiAllNumDissappearedInAnArray();
//        int[] arr = {4,1,0,5,3,2}; // case -2 => [0 N]   - //not valid array since range is given. It's a case -1 type => [1 N]
//        int[] arr = {4,3,2,7,8,2,3,1}; // [5,6],  // lc test case-1
//          IMP : {4,3,2,7,8,2,3,1} after sorting --> 1,2,3,4,3,2,7,8 : here after 4 there is 3 and 2 which is not sorted so ignore it since we already got 2,3 in sorted order.
//        int[] arr = {1,1}; // [2],  // lc test case-2
//        int[] arr = {4,2,5,7,1}; //  not valid for the problem statement in LeetCode 448. problem clearly states that nums[i] must be in the range [1, n], where n is the length of the array.
//        int[] arr = {4,2,5,6,1,1,5}; // [3,7] , sort form - //[1, 2, 1, 4, 5, 6, 5]
//        int[] arr = {1}; // {}, WHY ?? The numbers in the valid range [1, 1] are {1} if n=1. The input array contains the number 1. Therefore, no numbers are missing. Since no numbers are missing, the output is an empty list: [].
        int[] arr = {1,2}; // {}, WHY ?? since range is 1<=2 . all are present so no missing
//        int[] arr = {1,1,2}; //[3]    // 1<=3
//        int[] arr = {}; // 0,no need to check since in Constraints : it mentioned (1 <= n <= 10^4)the light and number wil lie. Hence, at least one element will be there
        System.out.println("Original Array: " + Arrays.toString(arr));
        List<Integer> missingNumberLst = obj.findAllDissapearedNumInArray(arr);
        obj.cyclicSortCase1(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("Missing number from above Array: " + missingNumberLst);
    }
}
/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 */