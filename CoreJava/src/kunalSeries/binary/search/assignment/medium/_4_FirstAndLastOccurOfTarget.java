package kunalSeries.binary.search.assignment.medium;

import java.util.Arrays;

// TODO: 34. Find First and Last Position of Element in Sorted Array-   Input Array Is Sorted :  Intuition for BS - sorted in non-decreasing order, OR You must write an algorithm with O(log n) runtime complexity.
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
// https://takeuforward.org/arrays/first-and-last-occurrences-in-array/
//preRequisite(if U Want):  https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/assignment/extrawithstriver/_1_ImplementUpperBound.java
// myGitSol (duringKunalLect): https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/lect4hrs/medium/_1_FindFirstLastPositionOfTargetInSortedArr.java
// In this i have simplified my above ref GIT for Binary  and also added Linear Search in 2 ways.
// Aditya verma : https://www.youtube.com/watch?v=zr_AoTxzn0Y
public class _4_FirstAndLastOccurOfTarget {
    // my or kunal way
    public int[] searchRangeLS1(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {-1, -1};
       // simple way is to run TWO for loop : One from 0 to n-1 and other from n-1 to 0
         // 1st will give the 1st position and 2nd will give the last position.
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                ans[0] = i;
                break;
            }
        }
        // find last
        for (int j = len-1; j >= 0; j--) {
            if (nums[j] == target) {
                ans[1] = j;
                break;
            }
        }

        return ans;

        }

        // striver way
    public int[] searchRangeLS2(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {-1, -1} ;
        for(int i = 0 ; i<len; i++){

            if (nums[i] == target){ // met with target
                if (ans[0] == -1)
                        ans[0] = i; // 1st target met
                ans[1] = i; // everytime when target we'll get 2nd , 3rd or ... last occurrence.
            }
        }
        return  ans;
    }

    public int[] searchRangeBS(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {-1,-1};
        int  l = 0;
        int  r = len-1;


        // 1st occurrence : will search LEFT from mid   - take the example of  [2,4,10,10,10,18,20] , t =10 -> ans-[2,4]
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid] == target){
                ans[0] = mid; // temp storage bcz it may be the 1st occurrence
                r = mid-1; // looking for 1st occurrence bcz we may have left side some more target value.
            } else if (nums[mid]>target){ // means last occurrence be left side of mid.
                r = mid-1;
            } else  // nums[mid] < target
                l = mid+1;
        }

        // 2nd occurrence: will search RIGHT from mid
        l = 0;
        r = len-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid] == target){
                ans[1] = mid;
                l = mid+1;  // Continue searching on the right side
            }else if (nums[mid]<target)
                l = mid+1;  // Target must be in the right half
            else  // nums[mid]>target
                r = mid-1; // Target must be in the left half
         }

        return ans;
    }

    public static void main(String[] args) {

        _4_FirstAndLastOccurOfTarget obj = new _4_FirstAndLastOccurOfTarget();
//        int[] nums = {5,7,7,8,8,10} ;
//        int target = 8; // [3,4]

//        int[] nums = {5,7,7,8,8,10} ;
//        int target = 6; // [-1,-1]

//        int[] nums = {} ;
//        int target = 0; // [-1,-1]

        int[] nums = {5,7,7,8,8,8,8,8,10} ;
        int target = 8; // [3,7]

//        int[] nums = {2,4,10,10,10,18,20} ;
//        int target = 10; // [2,4]

        int[] indLS1 = obj.searchRangeLS1(nums, target); // O(N)
        int[] indLS2 = obj.searchRangeLS2(nums, target); // O(N)
        int[] indBS = obj.searchRangeBS(nums, target); // O(LogN) + O(LogN) = 2O(logN) => O(logN)
        System.out.println("LS1 - 1st  & last occurrence of target: " + target + " indices are : " + Arrays.toString(indLS1));
        System.out.println("LS2 - 1st  & last occurrence of target: " + target + " indices are : " + Arrays.toString(indLS2));
        System.out.println("BS  - 1st  & last occurrence of target: " + target + " indices are : " + Arrays.toString(indBS));


    }
}

// Intuition for BS - sorted in non-decreasing order, OR You must write an algorithm with O(log n) runtime complexity.
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
    target value.

If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */