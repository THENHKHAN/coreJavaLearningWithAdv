package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 22:00 TS
// TODO: (Amazon&Fb)- 287. Find the Duplicate Number : since [1, n] used in the question so directly think of CYCLE Sort concept
// Question : https://leetcode.com/problems/find-the-duplicate-number/description/

import java.util.Arrays;

public class _3_FindDuplicateNumber {

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

    public int findDuplicate(int[] nums) {
            int n = nums.length;
            int i = 0;

            while(i<n){
                int correctIndx = nums[i]-1; // since [1,n] range  so value -1 will be the correct index of this ith element
                if (correctIndx<n && nums[i]!=nums[correctIndx])
                    swap(nums, i, correctIndx);
                else
                    i++;
            }
            // now we have to find th duplicate num: check all element if any element is not equal to index+1 then that will be our answer
        for (int j = 0; j < n; j++) {
            if (nums[j] != j+1)
                return nums[j];
        }
            return n;
        }

    public static void main(String[] args) {
        _3_FindDuplicateNumber obj = new _3_FindDuplicateNumber();

//        int[] arr = {1,3,4,2,2}; // 2,  // lc test case-1 - after sorting [1, 2, 3, 4, 2] - ignore the repeated number
//        int[] arr = {3,1,3,4,2}; // 3,  // lc test case-1 - after sorting [1, 2, 3, 4, 3] - ignore the repeated number
//        int[] arr = {3,3,3,3,3}; // 3,
//        int[] arr = {1,1}; // 1,
        int[] arr = {1,1,2}; // 1,

        System.out.println("Original Array: " + Arrays.toString(arr));
        int repeatedNumber = obj.findDuplicate(arr);
        obj.cyclicSort(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("Missing number from above Array: " + repeatedNumber);
    }
}
/*
Problem:
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.


without modifying the array nums -- but still solivng with cyclic sort why???????????
HERE IS  why:
The reason why cyclic sort is a preferred technique comes down to two key factors: the constraints of the
 problem (constant space and no modification of the array) and the nature of the data (the range of numbers).

In the problem you've described, we have an array of size n + 1, where each integer is in the range [1, n].
    Given these constraints, the cyclic sort algorithm can still be applied without violating the "no modifying the array" condition, and it achieves a very efficient solution.


 When the problem statement says "without modifying the array nums", it means:
    - You cannot modify the values of the elements in the array. This means you are not allowed to directly change the value
        of any element (e.g., assigning nums[i] = 5).
    - There is no restriction on the positions of the elements. You are allowed to rearrange or swap elements in the array,
    as long as the final result doesn't modify the values themselves.

 */