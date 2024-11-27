package kunalSeries.binary.search.assignment.easy;

// TODO : 704. Binary Search : Intuition :  sorted in ascending order and asked - You must write an algorithm with O(log n) runtime complexity.
// Hence Binary Search is the 1st choice
// https://leetcode.com/problems/binary-search/
// MyGit: https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/_1SearchEleAndReturnIndexInAscOrder.java
// for Order Agnostic (ASC or DSC) : https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/_3OrderAgnosticBInarySearch.java
import java.util.Arrays;

public class _2_BinarySearch {


    public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length-1;

            while (l<=r){
                int midIdx = l+(r-l)/2;
                if (nums[midIdx] == target)
                    return midIdx;
                else if (nums[midIdx]<target) // searching RIGHT from mid+1
                    l = midIdx+1; // starting from mid+1 since element in array are unique.
                else //|nums[midIdx]>target // searching LEFT from mid-1
                    r = midIdx-1;
            }

        return -1;
    }

    public static void main(String[] args) {
        _2_BinarySearch obj =new _2_BinarySearch();
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9; // 4 : 9 exists in nums and its index is 4

        int[] nums = {-1,0,3,5,9,12};
        int target = 2; // -1 : 2 does not exist in nums so return -1

        System.out.println("Array : " + Arrays.toString(nums));
        int targetIndx = obj.search(nums, target);
        System.out.println("The Searching target: " + target + " and its index is : " + targetIndx);

    }
}
/*
TODO: Sorted in ASC and ask for O(log n) hence BS used
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */